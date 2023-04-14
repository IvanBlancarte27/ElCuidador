
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