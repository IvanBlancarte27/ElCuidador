// COMENZANDO EN GOOGLE MAPS
let mapaG;
let lat;
let lng;
let latAdulto0;
let lngAdulto0;

export function verMapa() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            lat = position.coords.latitude;
            lng = position.coords.longitude;
            // Hacer algo con la ubicación obtenida
            // alert(lat + " " + lng);

            mapaG = new google.maps.Map(document.getElementById("contenidoMapa"), {
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
                map: mapaG
            })

            let persona2 = new google.maps.Marker({
                position: {
                    lat: 21.07087720853898,
                    lng: -101.56375151054621
                },
                map: mapaG
            });

            let persona3 = new google.maps.Marker({
                position: {
                    lat: 21.07773093695163,
                    lng: -101.59335483628323
                },
                map: mapaG
            });
        });

    } else {
        // El navegador no soporta geolocalización
        alert("no soporto");
    }

}




export function cargarRuta(index) {

//    let arregloAdulto = Array(document.querySelectorAll("#adultosMayores section"));
//    console.log(arregloAdulto);
//    let aux = index;
//    alert(aux);

    switch (index) {
        case 0:
            latAdulto0 = 21.07773298262589;
            lngAdulto0 = -101.59336273123942;
            break;
        case 1:
            latAdulto0 = 21.099371187504392;
            lngAdulto0 = -101.61771692121387;
            break;
        case 2:
            latAdulto0 = 21.071116617791525;
            lngAdulto0 = -101.60623471004418;
            break;
        case 3:
            latAdulto0 = 21.078526046978926;
            lngAdulto0 = -101.61647380009573;
            break;

        default:

            break;
    }

    //alert(latAdulto0 +" , "+ lngAdulto0);

    var directionsService = new google.maps.DirectionsService();

    var inicio = {lat: lat, lng: lng};
    var fin = {lat: latAdulto0, lng: lngAdulto0};

    var solicitud = {
        origin: inicio,
        destination: fin,
        travelMode: 'DRIVING'
    };

    let resultado;
    directionsService.route(solicitud, function (resultado, estado) {
        if (estado == 'OK') {
            // Crea una ruta en el mapa
            var ruta = new google.maps.DirectionsRenderer({
                map: mapaG,
                directions: resultado,
                suppressMarkers: true,
                polylineOptions: {
                    strokeColor: 'blue',
                    strokeWeight: 6,
                    strokeOpacity: 0.7
                }
            });
        }
        console.log(resultado.routes[0].legs[0].distance.text);
        console.log(resultado.routes[0].legs[0].duration.text);
    });
    mandarMensajeSMS();
}


//function mandarMensajeSMS() {
//
//    const accountSid = 'ACf8594ca06f63cf267d753adad16fee75';  // Reemplaza con el Account SID DE TWILO
//    const authToken = '52909cea9c6419d0c6365cd12ddd3cd1';  // Reemplaza con la auteticacion de twilo 
//    const url = `https://api.twilio.com/2010-04-01/Accounts/${accountSid}/Messages.json`;
//
//    const data = {
//        To: '+524771189966', // Reemplaza con el número de teléfono del destinatario en formato E.164
//        From: '+15136546257', // Reemplaza con tu número de teléfono de Twilio en formato E.164
//        Body: 'Tu cuidador va en camino!', // Reemplaza con el mensaje que deseas enviar
//    };
//    Swal.fire({
//        title: '¿Te gustaría que (NOMBRE) te acompañe?',
//        icon: 'warning',
//        showCancelButton: true,
//        confirmButtonColor: '#3085d6',
//        cancelButtonColor: '#d33',
//        confirmButtonText: 'Aceptar!'
//    }).then((result) => {
//        if (result.isConfirmed) {
//            Swal.fire(
//                    'En un momento llegará tu cuidador :)!',
//                    'Estar atento para recibirlo',
//                    'success'
//
//                    );
//            fetch(url, {
//                method: 'POST',
//                headers: {
//                    'Content-Type': 'application/x-www-form-urlencoded',
//                    'Authorization': `Basic ${btoa(`${accountSid}:${authToken}`)}`, // Codifica las credenciales de autenticación en Base64
//                },
//                body: new URLSearchParams(data).toString(), // Convierte los datos a una cadena de consulta URL codificada
//            })
//                    .then(response => response.json())
//                    .then(data => console.log(data))
//                    .catch(error => console.error(error));
//
//        } else if (!result.isConfirmed) {
//            Swal.fire(
//                    'Te invitamos a buscar a un cuidador que te agrade',
//                    'Queremos lo mejor para tí',
//                    'info'
//                    );
//        }
//    });
//}


