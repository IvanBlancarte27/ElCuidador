let adulto;

function formateoFecha(fech) {

    let fecha = new Date(fech);

    let dia = fecha.getDate() + 1;
    let mes = fecha.getMonth() + 1;
    let año = fecha.getFullYear();

    let fechaForm = dia + "/" + mes + "/" + año;

    return fechaForm;
}


function insertarAdultoMayor() {

    let nombreAdulto = document.getElementById("txtNombreAdulto").value;
    let primerApellidoAdulto = document.getElementById("txtPrimerApellidoAdulto").value;
    let segundoApellidoAdulto = document.getElementById("txtSegundoApellidoAdulto").value;
    let fechaNacAdulto = formateoFecha(document.getElementById("txtFechaNacAdulto").value);
    let generoAdulto = document.getElementById("txtGenero").value;
    let usuarioAdulto = document.getElementById("txtUsuarioAdulto").value;
    let contraseniaAdulto = document.getElementById("txtContraseñaAdulto").value;
    let fotoAdulto = document.getElementById("txtImagenAdulto").value;
    let nombreFam = document.getElementById("txtNombreFamiliar").value;
    let primerApellidoFam = document.getElementById("txtPrimerApellidoFamiliar").value;
    let segundoApellidoFam = document.getElementById("txtSegundoFamiliar").value;
    let numTelFam = document.getElementById("txtNumTelFamiliar").value;
    let generoFam = document.getElementById("txtGeneroFamiliar").value;
    let nobreMedic = document.getElementById("txtNombreMedico").value;
    let primerApellidoMedic = document.getElementById("txtPrimerApellidoMedico").value;
    let segundoApellidoMedic = document.getElementById("txtSegundoApellidoMedico").value;
    let numTelMedic = document.getElementById("txtNumTelMedico").value;
    let generoMedic = document.getElementById("txtGeneroMedico").value;



    let personaAdulto = {nombre: nombreAdulto, primerApellido: primerApellidoAdulto, segundoApellido: segundoApellidoAdulto, genero: generoAdulto};
    let personaFam = {nombre: nombreFam, primerApellido: primerApellidoFam, segundoApellido: segundoApellidoFam, genero: generoFam};
    let personaMedic = {nombre: nobreMedic, primerApellido: primerApellidoMedic, segundoApellido: segundoApellidoMedic, genero: generoMedic};

    let familiar = {numeroTelefono: numTelFam, persona: personaFam};
    let medico = {numeroTelefono: numTelMedic, persona: personaMedic};

    let usuario = {nombreUsuario: usuarioAdulto, contrasenia: contraseniaAdulto, rol: ""};

    let adultoMayor = JSON.stringify({fotografia: fotoAdulto, fechaNacimiento: fechaNacAdulto, familiarCargo: familiar, medico: medico, persona: personaAdulto, usuario: usuario});


    let parametros = new URLSearchParams({datos: adultoMayor});

    fetch("api/adultoMayor/insertAdulto",
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

function getAll() {

    fetch("http://localhost:8080/CuidadorReneweed/api/adultoMayor/getAll",
            {
                method: 'POST',
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert(data.error)
                } else
                    alert(JSON.stringify(data));
                cargarInformacion(data);
            });

}

function cargarInformacion(data) {
    adulto = data;
    let contenido = "";

    for (var i = 0; i < adulto.length; i++) {
        contenido += "<div style='border-radius:30px;background: #ffffff;box-shadow: 15px 15px 30px #666666,-15px -15px 30px #ffffff; margin: 10px; width:500px; height:200px; margin-left:150px;'";
        contenido += "<div>";
        contenido += "<h3 class='adultos'>Adulto Mayor</h3>";
        let nombre = adulto[i].persona.nombre;
        let primAp=adulto[i].persona.primerApellido;
        let segAp=adulto[i].persona.segundoApellido;
        contenido += "<h5 class='nombres'>" +nombre+" "+" "+primAp+' '+' '+segAp+ "</h5>";
        let num = adulto[i].familiarCargo.numeroTelefono;
        contenido += "<h5 class='nombres'>" + num + "</h5>";
        contenido += "<button class='btn btn-secondary booton' onclick=' '>Solicitar Servicio</button>";
        contenido += "</div>";
        contenido += "</div>";

    }

    document.getElementById("adultosMayores").innerHTML = contenido;

}


