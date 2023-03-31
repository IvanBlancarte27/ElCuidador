#      Nombre: Daiana Guadalupe Ulloa Mendoza y Yahir Alejandro Salmeron Martinez
#       Fecha: 12 de marzo del 2023
# Descripción: Se crearon las tablas correspondientes a los modelados

create database cuidador;
use cuidador;
 
 
CREATE TABLE persona(
	idPersona int not null AUTO_INCREMENT primary key,
	nombre varchar(50) not null,
	primerApellido varchar(40) not null,
	segundoApellido varchar(40),
	genero varchar(20),
	fechaNac date

);
 
CREATE TABLE usuario(
	idUsuario int not null AUTO_INCREMENT primary key,
	nombreUsuario varchar(20),
	contrasenia varchar(20),
	rol varchar(25)
); 

CREATE TABLE familiarACargo(
    idPersona int,
	FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
	idFamiliarACargo int not null AUTO_INCREMENT primary key,
    numTelefono varchar(15)
	
);

CREATE TABLE medico(
idPersona int,
	FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
	idMedico int not null AUTO_INCREMENT primary key,
    numTelefono varchar(15)
	
);

CREATE TABLE adultoMayor(
	idAdultoMayor int not null AUTO_INCREMENT primary key,
	numeroUnico varchar(25),
	idFamiliarACargo int,
	idMedico int,
	idPersona int,
	idUsuario int,
    fortografia longtext,
		FOREIGN KEY (idFamiliarACargo) REFERENCES familiarACargo(idFamiliarACargo),
		FOREIGN KEY (idMedico) REFERENCES medico(idMedico),
		FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
		FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
);

CREATE TABLE cuidador(
idCuidador int not null AUTO_INCREMENT primary key,
numeroUnico varchar(25),
fotoINE longtext,
cartaRecomendacion longtext,
cartaAntecedentesPenales longtext,
comprobanteDomicilio longtext,
rfc varchar(40),
telefonoMovil int,
telefonoCasa int,
correo varchar(50),
fortografia longtext,
idPersona int,
idUsuario int,

	FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
	FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
);

CREATE TABLE servicio(
	idPaquete int not null AUTO_INCREMENT primary key,
	nombre varchar(40),
	descripcion varchar(150),
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


