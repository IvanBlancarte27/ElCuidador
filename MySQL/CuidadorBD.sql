create database cuidador;
use cuidador;
 
 
CREATE TABLE persona(
	idPersona int not null AUTO_INCREMENT primary key,
	nombre varchar(50) not null,
	apellidoPaterno varchar(40) not null,
	apellidoMaterno varchar(40),
	genero varchar(20),
	edad int,
	rfc varchar(40),
	calle varchar(30),
	colonia varchar(30),
	numeroCasa varchar(30),
	ciudad varchar(30),
	pais varchar(30),
	telefonoMovil int,
	telefonoCasa int,
	correo varchar(50),
	fotoPersonal varchar(25)
);
 
CREATE TABLE usuario(
	idUsuario int not null AUTO_INCREMENT primary key,
	nombreUsuario varchar(20),
	contrasenia varchar(20),
	rol varchar(25)
); 

CREATE TABLE familiarACargo(
	idFamiliarACargo int not null AUTO_INCREMENT primary key,
	nombre varchar(50),
	apellidoPaterno varchar(40),
	apellidoMaterno varchar(40),
	telefono int,
	correo varchar(60)
);

CREATE TABLE medico(
	idMedico int not null AUTO_INCREMENT primary key,
	nombre varchar(50),
	apellidoPaterno varchar(40),
	apellidoMaterno varchar(40),
	telefono varchar(30)
);

CREATE TABLE adultoMayor(
	idAdultoMayor int not null AUTO_INCREMENT primary key,
	telefonoEmergencia varchar(30),
	numeroUnico varchar(25),
	idFamiliarACargo int,
	idMedico int,
	idPersona int,
	idUsuario int,
		FOREIGN KEY (idFamiliarACargo) REFERENCES familiarACargo(idFamiliarACargo),
		FOREIGN KEY (idMedico) REFERENCES medico(idMedico),
		FOREIGN KEY (idPersona) REFERENCES persona(idPersona),
		FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
);

CREATE TABLE cuidador(
idCuidador int not null AUTO_INCREMENT primary key,
telefonoEmergencia varchar(30),
numeroUnico varchar(25),
fotoINE varchar(20),
cartaRecomendacion varchar(25),
cartaAntecedentesPenales varchar(25),
comprobanteDomicilio varchar(25),
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


