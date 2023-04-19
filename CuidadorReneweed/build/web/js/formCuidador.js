
function insertarCuidador() {
    let nombre = document.getElementById("txtNombreCuidador").value;
    let primerAp = document.getElementById("txtPrimerApellidoCuidador").value;
    let segundoAp = document.getElementById("txtSegundoApellidoCuidador").value;
    let rfc = document.getElementById("txtRFC").value;
    let telCasa = document.getElementById("txtTelefonoCasaCuidador").value;
    let telMovil = document.getElementById("txtTelefonoMovilCuidador").value;
    let genero = document.getElementById("txtGeneroCuidador").value;
    let correo = document.getElementById("txtEmail").value;
    let fechaNac = document.getElementById("txtFechaNacCuidador").value;
    let usuario = document.getElementById("txtUsuarioCuidador").value;
    let contrasenia = document.getElementById("txtPasswordCuidador").value;
    let docIne = document.getElementById("imgIne").value;
    let docCartaRecomen = document.getElementById("imgCartaRecomendacion").value;
    let docCartaAntecedent = document.getElementById("imgCartaAntecedentes").value;
    let docComprobanteDom = document.getElementById("imgComprobanteDomicilio").value;
    let docFoto = document.getElementById("imgFotoPerfil").value;


    let fechaN = new Date(fechaNac);
    let dia = fechaN.getDate() + 1;
    let mes = fechaN.getMonth() + 1;
    let año = fechaN.getFullYear();

    let fecha = dia + "/" + mes + "/" + año;


    let persona = {nombre: nombre,
        primerApellido: primerAp,
        segundoApellido: segundoAp,
        genero: genero};

    let user = {nombreUsuario: usuario,
        contrasenia: contrasenia,
        rol: ""};

    let cuidador = JSON.stringify({fotografiaIne: docIne,
        cartaRecomendacion: docCartaRecomen,
        cartaAntecedentesPenales: docCartaAntecedent,
        comprobanteDomicilio: docComprobanteDom,
        rfc: rfc,
        numTelefonoMovil: telMovil,
        numTelefonoCasa: telCasa,
        correo: correo,
        fotografia: docFoto,
        persona: persona,
        usuario: user,
        fechaNacimiento: fecha
    });


    let parametros = new URLSearchParams({datos: cuidador});
    if (nombre === "" ||
            primerAp === "" || segundoAp === "" || rfc === "" || telCasa === "" || telMovil === "" || genero === "" ||
            correo === "" || fechaNac === "" || usuario === "" || contrasenia === "" || docIne === "" || docCartaRecomen === "" || docCartaAntecedent === "" ||
            docComprobanteDom === "" || docFoto === "") {
        Swal.fire({
            position: 'top-center',
            icon: 'error',
            title: 'Revisa dejaste campos vacios',
            showConfirmButton: false,
            timer: 1500
        });
    } else {


        fetch("api/cuidador/insertCuidador",
                {
                    method: 'POST',
                    body: (parametros),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
                }).then(response => response.json())
                .then(data => {

                    if (data.error)
                        alert(data.error);
                    else {

                        Swal.fire({
                            position: 'top-center',
                            icon: 'success',
                            title: 'Guardado correctamente',
                            showConfirmButton: false,
                            timer: 1500
                        });
                    }
                });
    }
}

function actualizarCuidador() {
    let cu = JSON.parse(localStorage.getItem("currentUser"));
    let nombre = document.getElementById("txtNombreCuidador").value;
    let primerAp = document.getElementById("txtPrimerApellidoCuidador").value;
    let segundoAp = document.getElementById("txtSegundoApellidoCuidador").value;
    let rfc = document.getElementById("txtRFC").value;
    let telCasa = document.getElementById("txtTelefonoCasaCuidador").value;
    let telMovil = document.getElementById("txtTelefonoMovilCuidador").value;
    let genero = document.getElementById("txtGeneroCuidador").value;
    let correo = document.getElementById("txtEmail").value;
    let usuario = document.getElementById("txtUsuarioCuidador").value;
    let contrasenia = document.getElementById("txtPasswordCuidador").value;
    let email = document.getElementById("txtEmail").value;

    let idCuidador = cu.idCuidador;
    let idPersona = cu.persona.idPersona;
    let idUsuario = cu.usuario.idUsuario;

    let persona = {nombre: nombre,
        primerApellido: primerAp,
        segundoApellido: segundoAp,
        genero: genero,
        idPersona: idPersona
    };
    let user = {nombreUsuario: usuario,
        contrasenia: contrasenia,
        idUsuario: idUsuario
    };

    let cuidador = JSON.stringify({persona: persona,
        usuario: user,
        rfc: rfc,
        numTelefonoMovil: telMovil,
        numTelefonoCasa: telCasa,
        correo: email,
        idCuidador: idCuidador
    });
    let parametros = new URLSearchParams({datos: cuidador});


    fetch("http://localhost:8080/CuidadorReneweed/api/cuidador/actualizar",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {

                if (data.error)
                    alert(data.error);
                else {
                    Swal.fire({
                        position: 'top-center',
                        icon: 'success',
                        title: 'Guardado correctamente',
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            });

}


document.addEventListener("DOMContentLoaded", function (event) {

    const showNavbar = (toggleId, navId, bodyId, headerId) => {
        const toggle = document.getElementById(toggleId),
                nav = document.getElementById(navId),
                bodypd = document.getElementById(bodyId),
                headerpd = document.getElementById(headerId)

// Validate that all variables exist
        if (toggle && nav && bodypd && headerpd) {
            toggle.addEventListener('click', () => {
// show navbar
                nav.classList.toggle('show')
// change icon
                toggle.classList.toggle('bx-x')
// add padding to body
                bodypd.classList.toggle('body-pd')
// add padding to header
                headerpd.classList.toggle('body-pd')
            })
        }
    }

    showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header')

    /*===== LINK ACTIVE =====*/
    const linkColor = document.querySelectorAll('.nav_link')

    function colorLink() {
        if (linkColor) {
            linkColor.forEach(l => l.classList.remove('active'))
            this.classList.add('active')
        }
    }
    linkColor.forEach(l => l.addEventListener('click', colorLink))

    // Your code to run since DOM is loaded and ready
});
