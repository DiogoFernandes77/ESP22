FROM python:3

ADD main.py /

RUN pip3 install kafka-python
RUN pip3 install requests

CMD [ "python", "./main.py" ]
