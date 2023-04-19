
let datos;
let cuidador;
const modal_container = document.getElementById('modal_container');

function ver(){
  modal_container.classList.add('show');
}

function quitar(){
  modal_container.classList.remove('show');
}

function logout(){
    window.location.replace('../login.html');
}

function cargarMapa() {
    window.location.replace('../mapa/mapa.html');
}

function cargarDatos(){
    cuidador=JSON.parse(localStorage.getItem("currentUser"));
    let nombre=cuidador.persona.nombre;
    let primerApell=cuidador.persona.primerApellido;
    let segundoApell=cuidador.persona.segundoApellido;
    let rfc=cuidador.rfc;
    let celCasa=cuidador.numTelefonoCasa;
    let telMovil=cuidador.numTelefonoMovil;
    let genero=cuidador.persona.genero;
    let nomUser=cuidador.usuario.nombreUsuario;
    let contrasenia=cuidador.usuario.contrasenia;
    let emai=cuidador.correo;
    
    
    document.getElementById("txtNombreCuidador").value=nombre;
    document.getElementById("txtPrimerApellidoCuidador").value=primerApell;
    document.getElementById("txtSegundoApellidoCuidador").value=segundoApell;
    document.getElementById("txtRFC").value=rfc;
    document.getElementById("txtTelefonoCasaCuidador").value=celCasa;
    document.getElementById("txtTelefonoMovilCuidador").value=telMovil;
    document.getElementById("txtGeneroCuidador").value=genero;
    document.getElementById("txtUsuarioCuidador").value=nomUser;
    document.getElementById("txtPasswordCuidador").value=contrasenia;
    document.getElementById("txtEmail").value=emai;
    
}

function cargarInfoADivPerfil() {

    let contenido = "";

    let nombre = cuidador.persona.nombre;
    let primAp = cuidador.persona.primerApellido;
    let segAp = cuidador.persona.segundoApellido;
    let celCasa = cuidador.numTelefonoCasa;
    let telMovil = cuidador.numTelefonoMovil;
    let emai = cuidador.correo;

    contenido += "<div>";
    contenido += "<h5 style='color:#3085d6'>Nombre:</h5>";
    contenido += "<h5>" + nombre + ' ' + primAp + ' ' + segAp + "</h5>";
    contenido += "<h5 style='color:#3085d6'>Numeros Telefonicos:</h5>";
    contenido += "<h5>" + celCasa + "</h5>";
    contenido += "<h5>" + telMovil + "</h5>";
    contenido += "<h5 style='color:#3085d6'>Correo Electronico:</h5>";
    contenido += "<h5>" + emai + "</h5>";
    contenido += "</div>";



    document.getElementById("perfilCu").innerHTML = contenido;
}

cargarDatos();

function cargarDocumentos() {
    cuidador=JSON.parse(localStorage.getItem("currentUser"));
    
    let ine=cuidador.fotorafiaIne;
    let cartaRecomendacion=cuidador.cartaRecomendacion;
    let cartaAntecedentes=cuidador.cartaAntecedentesPenles;
    let comprobanteDom=cuidador.comprobanteDomicilio;
    
    
}