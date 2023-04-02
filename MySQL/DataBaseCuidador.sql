#      Nombre: Daiana Guadalupe Ulloa Mendoza y Yahir Alejandro Salmeron Martinez
#       Fecha: 12 de marzo del 2023
# Descripción: Se crearon las tablas correspondientes a los modelados
create database cuidador;
use cuidador;
 
 
CREATE TABLE persona(
	idPersona int not null AUTO_INCREMENT primary key,
	nombre varchar(64) not null,
	primerApellido varchar(64) not null,
	segundoApellido varchar(64),
	genero varchar(64)

);
 
CREATE TABLE usuario(
	idUsuario int not null AUTO_INCREMENT primary key,
	nombreUsuario varchar(64),
	contrasenia varchar(64),
	rol varchar(64)
); 

CREATE TABLE familiarACargo(
    idPersona int,
	FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
	idFamiliarACargo int not null AUTO_INCREMENT primary key,
    numTelefono varchar(64)
	
);

CREATE TABLE medico(
	idPersona int,
	FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
	idMedico int not null AUTO_INCREMENT primary key,
    numTelefono varchar(64)
	
);

CREATE TABLE adultoMayor(
	idAdultoMayor int not null AUTO_INCREMENT primary key,
	numeroUnico varchar(64),
	idFamiliarACargo int,
	idMedico int,
	idPersona int,
	idUsuario int,
    fechaNac date,
    fortografia longtext,
		FOREIGN KEY (idFamiliarACargo) REFERENCES familiarACargo(idFamiliarACargo),
		FOREIGN KEY (idMedico) REFERENCES medico(idMedico),
		FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
		FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
);

CREATE TABLE cuidador(
idCuidador int not null AUTO_INCREMENT primary key,
numeroUnico varchar(64),
fotoINE longtext,
cartaRecomendacion longtext,
cartaAntecedentesPenales longtext,
comprobanteDomicilio longtext,
rfc varchar(64),
fechaNac date,
telefonoMovil varchar(64),
telefonoCasa varchar(64),
correo varchar(64),
fortografia longtext,
idPersona int,
idUsuario int,

	FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
	FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
);

CREATE TABLE servicio(
	idPaquete int not null AUTO_INCREMENT primary key,
	nombre varchar(64),
	descripcion varchar(64),
	precioPorHora double
);
CREATE TABLE servicioAdultoMayor(
idServicioPaciente int not null AUTO_INCREMENT primary key,
idCuidador int,
	FOREIGN KEY (idCuidador) REFERENCES cuidador(idCuidador),
idUsuario int,
	FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
idAdultoMayor int,
	FOREIGN KEY (idAdultoMayor) REFERENCES adultoMayor(idAdultoMayor),
    idPaquete int,
	FOREIGN KEY (idPaquete) REFERENCES servicio(idPaquete)
);
CREATE TABLE servicioCuidador(
idServicioCuidador int not null AUTO_INCREMENT primary key,
idCuidador int,
	FOREIGN KEY (idCuidador) REFERENCES cuidador(idCuidador),
idUsuario int,
	FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
idAdultoMayor int,
	FOREIGN KEY (idAdultoMayor) REFERENCES adultoMayor(idAdultoMayor),
    idPaquete int,
	FOREIGN KEY (idPaquete) REFERENCES servicio(idPaquete)
);


