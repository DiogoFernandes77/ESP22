
const uluru = { lat: 53.702116, lng: -4.133879 };
let map = new google.maps.Map(document.getElementById("map"), {
  zoom: 6,
  center: uluru,
});

// function makeMarker(lat2, lng2) {
//
//   const uluru = { lat: 53.702116, lng: -4.133879 };
//   // The map, centered at Uluru
//
//   const marker = new google.maps.Marker({
//     position: { lat: lat2, lng: lng2 },
//     map: map,
//   });
// }

// function initMap() {
//   map = new google.maps.Map(document.getElementById("map"), {
//     center: { lat: 53.702116, lng: -4.133879 },
//     zoom: 6,
//   });
// }
