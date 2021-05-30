from kafka import KafkaProducer
from kafka.errors import KafkaError
import json
import requests
import time


f = requests.get("https://opensky-network.org/api/states/all?lamin=50.3389&lomin=-10.4962&lamax=58.5229&lomax=1.0026")
print(f.text)

producer = KafkaProducer(bootstrap_servers=['localhost:9092:9092'],value_serializer=lambda m: json.dumps(m).encode('ascii'))

json_object = json.loads(f.text)

while True:
    producer.send('user', "delete")
    time.sleep(1)
    for key in json_object:
        if key == "states":
            for flight in json_object[key]:
                print(flight)
                producer.send('user', flight)
    time.sleep(60)     # Wait 1 min for next request



i = 0



# block until all async messages are sent
producer.flush()

# configure multiple retries
producer = KafkaProducer(retries=5)
