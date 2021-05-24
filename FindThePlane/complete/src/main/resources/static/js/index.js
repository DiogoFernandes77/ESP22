let map;

function initMap() {
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 53.702116, lng: -4.133879 },
    zoom: 6,
  });
}
