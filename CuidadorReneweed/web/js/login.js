function login()
{
    window.location.replace('login.html');
}

function creaAnAcount() {
    window.location.replace('pagReguistre.html');

}

function entrar() {

    let usuario = document.getElementById("txtUsuario").value;
    let password = document.getElementById("txtPassword").value;

    if (usuario == "AroonPe" && password == 123456) {
        window.location.replace('cuidador/cuidador.html');
    } else {
        errorLog();
    }


}

