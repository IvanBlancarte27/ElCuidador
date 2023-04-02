function errorLog(){
    Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'El usuario o la contraseña son incorrectos!',
            footer: '<a href="">Recuperar cuenta</a>'
        });
}

function inicioDeSesio(){
  const Toast = Swal.mixin({
  toast: true,
  position: 'top-end',
  showConfirmButton: false,
  timer:3000,
  timerProgressBar: true,
  didOpen: (toast) => {
    toast.addEventListener('mouseenter', Swal.stopTimer)
    toast.addEventListener('mouseleave', Swal.resumeTimer)
    
  }
})

Toast.fire({
  icon: 'success',
  title: 'Iniciando Sesion con exito'
})

    
}

export function mandarConfirmacionGuardar()
{
    Swal.fire({
        position: 'top-center',
        icon: 'success',
        title: 'Guardado correctamente',
        showConfirmButton: false,
        timer: 1500
    });
}