function reguisterCuidador() {
    window.location.replace('formCuidador.html');

}

function reguisterAdultoMayor() {
    window.location.replace('formAdultoMayor.html');

}

let cm = null;

function cargarVentanaFormulario() {
    fetch('formActualizar.html')
            .then(respuesta => {
                return respuesta.text();
            })
            .then(datos => {
                document.getElementById('contenedor_principal').innerHTML = datos;
                import('./formCuidador.js').then(obj => {
                    cm = obj;
                    cargarDatos();
                    cargarInfoADivPerfil();
                });
            });
}

function cargarMapa() {
    fetch('../mapa/mapa.html')
            .then(respuesta => {
                return respuesta.text();
            })
            .then(datos => {
                document.getElementById('contenedor_principal').innerHTML = datos;
                import('./mapa.js').then(obj => {
                    cm = obj;
                    cm.verMapa();
                    getAll();
                });
            });
}

function cargarVentanaFormularioAdulto() {
    fetch('formActualizarAdulto.html')
            .then(respuesta => {
                return respuesta.text();
            })
            .then(datos => {
                document.getElementById('contenedor_principal').innerHTML = datos;
                import('./formAdultoMayor.js').then(obj => {
                    cm = obj;
                    cargarDatos();
                    cargarInfoADivPerfil();
                });
            });
}

//let ad = null;
//function cargarAdultoJS() {
//
//    import('./formAdultoMayor.js').then(obj => {
//                    ad = obj;
//                    ad.getAll();
//                });
//}