let datos;

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


    let persona = {nombre: nombre, primerApellido: primerAp, segundoApellido: segundoAp, genero: genero};
    let user = {nombreUsuario: usuario, contrasenia: contrasenia, rol: ""};

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

    fetch("api/cuidador/insertCuidador",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {

                if (data.error)
                    alert(data.error);
                else{
                    Swal.fire({
                        position: 'top-center',
                        icon: 'success',
                        title: 'Guardado correctamente',
                        showConfirmButton: false,
                        timer: 1500
                    }); }
            });
}







