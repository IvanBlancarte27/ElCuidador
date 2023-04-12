// COMENZANDO EN GOOGLE MAPS
let cargarMapa;

function verMapa() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var lat = position.coords.latitude;
            var lng = position.coords.longitude;
            // Hacer algo con la ubicación obtenida
            alert(lat + " " + lng);

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
        });
    } else {
        // El navegador no soporta geolocalización
        alert("no soporto");
    }
}

function localizar() {

    let json = JSON.stringify({

        homeMobileCountryCode: 334,
        homeMobileNetworkCode: 03,
        radioType: "LTE",
        carrier: "Movistar"
    })

    let parametros = new URLSearchParams({ data: json })

    fetch('https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyBrXEvC_p4TrXp-tq2W8qJLbFt3p5JvqAA',
        {
            method: 'POST',
            body: (parametros),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8' }
        }).then(response => response.json())
        .then(data => {
            //alert(JSON.stringify(data));

            let lat = data.location.lat;
            
            let lng = data.location.lng;

            

            let iconoMarker = new google.maps.Marker({
                position: {
                    lat: lat,
                    lng: lng
                },
                map: cargarMapa
            })
        });
}


