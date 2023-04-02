/*Procedimiento Almacenado Para Insertar Un Adulto Mayor*/

DELIMITER $$
CREATE PROCEDURE insertAdultoMayor(    /* Datos Personales */
                                    IN    var_nombre          VARCHAR(64),    --  1
                                    IN    var_primerApellido  VARCHAR(64),    --  2
                                    IN    var_segundoApellido VARCHAR(64),    --  3
                                    IN    var_genero          VARCHAR(64),     --  4
                                    
                                    /* Datos de Usuario */
                                    IN    var_nombreUsuario   VARCHAR(129),   -- 5
                                    IN    var_contrasenia     VARCHAR(129),   -- 6
                                    
                                    /*Datos del Familiar a cargo*/
                                    IN var_nombreFam          VARCHAR(64),
                                    IN var_primerApellidoFam  VARCHAR(64),
                                    IN var_segundoApellidoFam VARCHAR(64),
                                    IN var_generoFam          VARCHAR(64),
                                    IN var_numTelefono        VARCHAR(64),
                                    
                                    /*Datos del Medico Encargado*/
                                    IN var_nombreMedi         VARCHAR(64),
                                    IN var_primerApellidoMed  VARCHAR(64),
                                    IN var_segundoApellidoMed VARCHAR(64),
                                    IN var_generoMed          VARCHAR(64),
                                    IN var_numTelMed          VARCHAR(64),
                                    
                                    /*Datos del Adulto Mayor*/
                                    
                                    IN var_fechaNacimiento   VARCHAR(64),
                                    IN var_fotografia        longtext,
                                    
                                    /* Valores de Retorno */
                                    OUT    var_idPersona       INT,
                                    OUT    var_idPersonaFam    INT,
                                    OUT    var_idPersonaMedi   INT,
                                    OUT    var_idUsuario       INT,            
                                    OUT    var_idFamiliar      INT,
                                    OUT    var_idMedico        INT,
                                    OUT    var_idAdultoMayor   INT,
                                    OUT    var_numeroUnico     VARCHAR(64)    
                )
BEGIN        

        INSERT INTO persona (nombre, primerApellido, segundoApellido, genero)
                    VALUES( var_nombre, var_primerApellido, var_segundoApellido, 
                            var_genero);
        SET var_idPersona = LAST_INSERT_ID();
        
        
        INSERT INTO persona (nombre, primerApellido, segundoApellido, genero)
						VALUES (var_nombreFam, var_primerApellidoFam, var_segundoApellidoFam, 
                            var_generoFam);
		SET var_idPersonaFam = LAST_INSERT_ID();
        

		INSERT INTO persona (nombre, primerApellido, segundoApellido, genero)
						VALUES(var_nombreMedi, var_primerApellidoMed, var_segundoApellidoMed, 
                            var_generoMed);
	   SET var_idPersonaMedi = LAST_INSERT_ID();

                            
        INSERT INTO familiarACargo(idPersona,numTelefono)
								VALUES(var_idPersonaFam,var_numTelefono);
                                
		SET var_idFamiliar=LAST_INSERT_ID();
        INSERT INTO medico(idPersona,numTelefono)
						VALUES(var_idPersonaMedi,var_numTelMed);
                        
		SET var_idMedico=LAST_INSERT_ID();
        
        INSERT INTO usuario (nombreUsuario,contrasenia,rol) 
                    VALUES( var_nombreUsuario, var_contrasenia,"Adulto Mayor");
        -- Obtenemos el ID de Usuario que se generó:
        SET var_idUsuario = LAST_INSERT_ID();

        --  Generamos el numero unico del AdultoMayor.        
        SET var_numeroUnico = '';
        --  Agregamos la primera letra del apellidoPaterno:
        IF  LENGTH(var_primerApellido) >= 1 THEN
            SET var_numeroUnico = SUBSTRING(var_primerApellido, 1, 1);
        ELSE
            SET var_numeroUnico = 'X';
        END IF;
        --  Agregamos la segunda letra del apellidoPaterno:
        IF  LENGTH(var_primerApellido) >= 2 THEN
            SET var_numeroUnico = CONCAT(var_numeroUnico, SUBSTRING(var_primerApellido, 2, 1));
        ELSE
            SET var_numeroUnico = CONCAT(var_numeroUnico, 'X');
        END IF;        
        --  Agregamos el timestamp:
        SET var_numeroUnico = CONCAT(var_numeroUnico, CAST(UNIX_TIMESTAMP() AS CHAR));
        -- Codificamos el numero unico generado:
        SET var_numeroUnico = MD5(var_numeroUnico);

 
		INSERT INTO adultoMayor(numeroUnico,idFamiliarACargo,idMedico,idPersona,idUsuario,fechaNac,fortografia)
							VALUES(var_numeroUnico,var_idFamiliar,var_idMedico,(SELECT var_idPersona FROM persona ORDER BY var_idPersona ASC LIMIT 1),var_idUsuario,str_to_date(var_fechaNacimiento, '%d/%m/%Y'),var_fotografia);
		
        SET var_idAdultoMayor = LAST_INSERT_ID();
    END
    
    
    
    
/*Procedimiento Almacenado Para Insertar Un Cuidador*/    
    
    DELIMITER $$
CREATE PROCEDURE insertarCuidador( /*Datos personales*/
                                    IN var_nombre          VARCHAR(64),
                                    IN var_primerApellido  VARCHAR(64),
                                    IN var_segundoApellido VARCHAR(64),
                                    IN var_genero          VARCHAR(64),
                                    
                                    /*Datos de Usuario*/
                                    IN var_nombreUsuario       VARCHAR(64),
                                    IN var_contraseñaUsuario   VARCHAR(64),
                                    
                                    /*Datos del cuidador*/
                                    IN var_fotografia               longtext,
                                    IN var_fotoIne                  longtext,
                                    IN var_cartaRecomendacion       longtext,
                                    IN var_cartaAntecedentesPenales longtext,
                                    IN var_comprobanteDomicilio     longtext,
                                    IN var_rfc                      VARCHAR(64),
                                    IN var_fechaNacimiento          VARCHAR(64),
                                    IN var_telefonoMovil            VARCHAR(64),
                                    IN var_telefonoCasa             VARCHAR(64),
                                    IN var_correoElectronico        VARCHAR(64),
                                    
                                    /*Valores de retorno*/
                                    
                                    OUT var_idPersona        INT,
                                    OUT var_idUsuario        INT,
                                    OUT var_numUnicoCuidador VARCHAR(64),
                                    OUT var_idCuidador       INT 
                                    )
BEGIN 
	
	INSERT INTO persona(nombre, primerApellido, segundoApellido, genero)
				VALUES(var_nombre,var_primerApellido,var_segundoApellido,var_genero);
                
    SET var_idPersona = LAST_INSERT_ID();
    
    INSERT INTO usuario (nombreUsuario,contrasenia,rol) 
				VALUES(var_nombreUsuario,var_contraseñaUsuario,"Cuidador");
                
	 SET var_idUsuario = LAST_INSERT_ID();
     
        SET var_numUnicoCuidador = '';
        --  Agregamos la primera letra del apellidoPaterno:
        IF  LENGTH(var_primerApellido) >= 1 THEN
            SET var_numUnicoCuidador = SUBSTRING(var_primerApellido, 1, 1);
        ELSE
            SET var_numUnicoCuidador = 'X';
        END IF;
        --  Agregamos la segunda letra del apellidoPaterno:
        IF  LENGTH(var_primerApellido) >= 2 THEN
            SET var_numUnicoCuidador = CONCAT(var_numUnicoCuidador, SUBSTRING(var_primerApellido, 2, 1));
        ELSE
            SET var_numUnicoCuidador = CONCAT(var_numUnicoCuidador, 'X');
        END IF;        
        --  Agregamos el timestamp:
        SET var_numUnicoCuidador = CONCAT(var_numUnicoCuidador, CAST(UNIX_TIMESTAMP() AS CHAR));
        -- Codificamos el numero unico generado:
        SET var_numUnicoCuidador = MD5(var_numUnicoCuidador);
        
     INSERT INTO cuidador(numeroUnico,fotoINE,cartaRecomendacion,cartaAntecedentesPenales,comprobanteDomicilio,rfc,
						  fechaNac,telefonoMovil,telefonoCasa,correo,fortografia,idPersona,idUsuario)
                 VALUES(var_numUnicoCuidador,var_fotoIne,var_cartaRecomendacion,var_cartaAntecedentesPenales,
						var_comprobanteDomicilio,var_rfc,str_to_date(var_fechaNacimiento, '%d/%m/%Y'),var_telefonoMovil,var_telefonoCasa,
                        var_correoElectronico,var_fotografia,var_idPersona,var_idUsuario); 
                        
	  SET var_idCuidador = LAST_INSERT_ID();                
END
	
    


    
    
    