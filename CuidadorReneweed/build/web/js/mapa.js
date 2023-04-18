// COMENZANDO EN GOOGLE MAPS
let cargarMapa;
let lat;
let lng;

export function verMapa() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            lat = position.coords.latitude;
            lng = position.coords.longitude;
            // Hacer algo con la ubicación obtenida
            // alert(lat + " " + lng);

            cargarMapa = new google.maps.Map(document.getElementById("contenidoMapa"), {
                center: {
                    lat: lat,
                    lng: lng
                },
                zoom: 16
            });

            let iconoMarker = new google.maps.Marker({
                position: {
                    lat: lat,
                    lng: lng
                },
                map: cargarMapa
            })

            let persona2 = new google.maps.Marker({
                position: {
                    lat: 21.07087720853898,
                    lng: -101.56375151054621
                },
                map: cargarMapa
            });

            let persona3 = new google.maps.Marker({
                position: {
                    lat: 21.07773093695163,
                    lng: -101.59335483628323
                },
                map: cargarMapa
            });
        });

    } else {
        // El navegador no soporta geolocalización
        alert("no soporto");
    }
    
}

export function localizar() {
    var directionsService = new google.maps.DirectionsService();

    var inicio = { lat: lat, lng: lng };
    var fin = { lat: 21.077944184665803, lng: -101.61679955712157 };

    var solicitud = {
        origin: inicio,
        destination: fin,
        travelMode: 'DRIVING'
    };

    let resultado;
    directionsService.route(solicitud, function (resultado, estado) {
        if (estado == 'OK') {
            console.log(resultado.routes[0].legs[0]); // Muestra la ruta en la consola

            // Crea una ruta en el mapa
            var ruta = new google.maps.DirectionsRenderer({
                map: cargarMapa,
                directions: resultado,
                suppressMarkers: true,
                polylineOptions: {
                    strokeColor: 'blue',
                    strokeWeight: 6,
                    strokeOpacity: 0.7
                }
            });
        }
    });
}


