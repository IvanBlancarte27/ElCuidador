function loginCuidador()
{

    let user = document.getElementById("txtUsuario").value;
    let password = document.getElementById("txtPassword").value;

    let usuario = {"usuario":JSON.stringify({nombreUsuario: user, contrasenia: password})};

    let params = new URLSearchParams(usuario);
    alert(usuario);

    fetch("api/login/acceder",
            {method: "POST",
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                body: params
            })
            .then(response => {
                return response.json();
            })
            .then(function (data)
            {
                if (data == null)
                {
                    Swal.fire('', 'Usuario o contraseña incorrecto, verifica los datos', 'error');
                    return;
                }
                if (data.error != null)
                {
                    Swal.fire('', data.error, 'warning');
                    return;
                }
                if (data.usuario.rol === 'Cuidador')
                {
                    localStorage.setItem('currentUser', JSON.stringify(data));
                     window.location.replace('cuidador/cuidador.html');

                }if(data.usuario.rol === 'Adulto Mayor'){
                    localStorage.setItem('currentUserAC', JSON.stringify(data));
                     window.location.replace('adultoMayor/adultoMayor.html');
                } else
                    Swal.fire('', 'Por el momento, solo los administradores tienen acceso al sistema.', 'warning');
            });
    
}

function creaAnAcount() {
    window.location.replace('pagReguistre.html');

}

function login()
{
    window.location.replace('login.html');
}

function entrar() {

    let usuario = document.getElementById("txtUsuario").value;
    let password = document.getElementById("txtPassword").value;

    if (usuario == "AroonPe" && password == 123456) {
        window.location.replace('cuidador/cuidador.html');
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'El usuario o la contraseña son incorrectos!',
            footer: '<a href="">Recuperar cuenta</a>'
        });
    }


}

