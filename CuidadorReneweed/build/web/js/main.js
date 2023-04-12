function reguisterCuidador(){
    window.location.replace('formCuidador.html');
    
}

function reguisterAdultoMayor(){
    window.location.replace('formAdultoMayor.html');
    
}


function cargarVentana() {
    fetch('../ventanaModal/ventana.html')
            .then(respuesta => {
                return respuesta.text();
            })
            .then(datos => {
                document.getElementById('contenedor_principal').innerHTML = datos;
                import('./CuidadorScript.js').then(obj => {
                    cm = obj;
                     cm.cargarInfo();
                });
            });
    
}