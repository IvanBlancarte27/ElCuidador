function cargarDatosAdultoMayor(){
    let user=JSON.parse(localStorage.getItem("currentUserAC"));
    
    //datos de Adulto mayor
    let nombre=user.persona.nombre;
    let primerApell=user.persona.primerApellido;
    let segundoApell=user.persona.segundoApellido;
    let fechaNac = user.fechaNacimiento;
    let genero=user.persona.genero;
    let nomUser=user.usuario.nombreUsuario;
    let contrasenia=user.usuario.contrasenia;
    
    //datos de familiar a cargo
    let nombreFamiliar = user.familiarCargo.persona.nombre;
    let primerApellFamiliar = user.familiarCargo.persona.primerApellido;
    let segundoApellFamiliar = user.familiarCargo.persona.segundoApellido;
    let telFamiliar = user.familiarCargo.numeroTelefono;
    let generoFamiliar = user.familiarCargo.persona.genero;

    //datos de medico
    let nombreMedico = user.medico.persona.nombre;
    let primerApellMedico = user.medico.persona.primerApellido;
    let segundoApellMedico = user.medico.persona.segundoApellido;
    let telMedico = user.medico.numeroTelefono;
    let generoMedico = user.medico.persona.genero;
    
    //alert(nombreFamiliar);
    //datos del Adulto Mayor
    document.getElementById("txtNombreAdulto").value=nombre;
    document.getElementById("txtPrimerApellidoAdulto").value=primerApell;
    document.getElementById("txtSegundoApellidoAdulto").value=segundoApell;
    document.getElementById("txtFechaNacAdulto").value=fechaNac;
    document.getElementById("txtGenero").value=genero;
    document.getElementById("txtUsuarioAdulto").value=nomUser;
    document.getElementById("txtContraseniaAdulto").value=contrasenia;
    
    //datos del familiar a cargo
    document.getElementById("txtNombreFamiliar").value=nombreFamiliar;
    document.getElementById("txtPrimerApellidoFamiliar").value=primerApellFamiliar;
    document.getElementById("txtSegundoFamiliar").value=segundoApellFamiliar;
    document.getElementById("txtNumTelFamiliar").value=telFamiliar;
    document.getElementById("txtGeneroFamiliar").value=generoFamiliar;
    
    //datos del medico
    document.getElementById("txtNombreMedico").value=nombreMedico;
    document.getElementById("txtPrimerApellidoMedico").value=primerApellMedico;
    document.getElementById("txtSegundoApellidoMedico").value=segundoApellMedico;
    document.getElementById("txtNumTelMedico").value=telMedico;
    document.getElementById("txtGeneroMedico").value=generoMedico;
}