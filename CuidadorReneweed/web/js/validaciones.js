function soloLetras(event) {
  var input = event.target;
  var regex = /[^A-Za-z]/gi;
  input.value = input.value.replace(regex, "");
}
function soloNumeros(e){
  var key = window.event ? e.keyCode : e.which;
  if (key < 48 || key > 57){
    e.preventDefault();
}
}
function validarCorreoElectronico(input) {
  // Expresión regular para validar el correo electrónico
  const regexCorreoElectronico = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

  // Si el valor del input no cumple con la expresión regular, devuelve falso
  if (!regexCorreoElectronico.test(input.value)) {
    Swal.fire({
                        position: 'top-center',
                        icon: 'warning',
                        title: 'Ingresa un correo electronico valido',
                        showConfirmButton: false,
                        timer: 1500
                    });
    input.value = "";
    return false;
  }

  return true;
}
function verificarEdad() {
  var fechaNacimiento = new Date(document.getElementById("txtFechaNacCuidador").value); // Obtener el valor del input de fecha de nacimiento
  
  var hoy = new Date(); // Obtener la fecha actual
  
  var edad = hoy.getFullYear() - fechaNacimiento.getFullYear(); // Calcular la edad en años
  
  if (hoy.getMonth() < fechaNacimiento.getMonth() || (hoy.getMonth() == fechaNacimiento.getMonth() && hoy.getDate() < fechaNacimiento.getDate())) { // Restar un año si la persona no ha cumplido años todavía este año
    edad--;
  }
  
  if (edad < 18) { // Verificar si la edad es menor a 18
    Swal.fire({
                        position: 'top-center',
                        icon: 'warning',
                        title: 'Revise sus datos necesita ser mayor de edad',
                        showConfirmButton: false,
                        timer: 1500
                    });
   document.getElementById("txtFechaNacCuidador").value = "";
  } 
  
  
}

document.getElementById("txtFechaNacCuidador").addEventListener("change", verificarEdad);

function validarInput(input) {
  // Remover caracteres no permitidos
  input.value = input.value.replace(/[^a-zA-Z0-9]/g, '');

  // Convertir a mayúsculas
  input.value = input.value.toUpperCase();

  // Validar la longitud
  if (input.value.length > 12) {
    input.value = input.value.substring(0, 12);
  }
}