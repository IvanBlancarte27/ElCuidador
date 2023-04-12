
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

function cargarMapa() {
    window.location.replace('../mapa/mapa.html');
}