create table spring_data.user(
	id SERIAL primary key,
	nome varchar(80) not null,
	login varchar(45) not null,
	senha varchar(30) not null
);

CREATE TABLE spring_data.telefone(
	id SERIAL primary key,
	id_usuario int,
	tipo VARCHAR(40),
	numero VARCHAR(20),

	CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario)
	references spring_data.user(id)
	ON DELETE CASCADE
	ON UPDATE CASCADE
)