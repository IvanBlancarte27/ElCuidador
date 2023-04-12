
let datos;
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

function cargarInfo() {
    datos=JSON.parse(localStorage.getItem('currentUser'));
    alert(datos);
    let nombre=datos.persona.nombre;
    let apellidoUno=datos.persona.primerApellido;
    let apellidoDos=datos.persona.segundoApellido;
    let rfc=datos.rfc;
    let telCasa=datos.numTelefonoCasa;
    let telMovil=datos.numTelefonoMovil;
    let genero=datos.persona.genero;
    let email=datos.correo;
    let usuario=datos.usuario.nombreUsuario;
    let password=datos.usuario.contrasenia;
    
    alert(nombre);
    alert(apellidoUno);
    
    document.getElementById('txtNombreCuidador').innerHTML=nombre;
    document.getElementById('txtPrimerApellidoCuidador').innerHTML=apellidoUno;
    
    
    
    
}