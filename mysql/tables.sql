create table usuarios
  (
        id integer not null auto_increment,
        login VARCHAR(20) not null,
        nombre VARCHAR(40) not null,
	pass CHAR(65) not null,

        primary key(id)

  ) ENGINE=InnoDB;


create table carpetas
  (
	id integer not null auto_increment,
	carpeta VARCHAR(255),
	
	primary key(id)

  ) ENGINE=InnoDB;

create table tipos
  (
	id integer not null auto_increment,
	descripcion VARCHAR(20),

	primary key(id)

  ) ENGINE=InnoDB;


create table usuario_carpeta
  (
	id_usuario integer not null,
	id_carpeta integer not null,
	id_tipo integer not null,
	carpeta_local VARCHAR(255)
  ) ENGINE=InnoDB;


GRANT ALL PRIVILEGES ON JBox.* TO 'jbox'@'localhost' IDENTIFIED BY 'jbox' WITH GRANT OPTION;
