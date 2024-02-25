create database consejeriaEdu;

use consejeriaEdu;

create table administrativo(
  nombreUsuario varchar(20) primary key,
  contraseña varchar(20)
);

insert into administrativo values ("Ritik","1234");

drop table estudiante;

insert into estudiante values ("12344","Angel","Perez","Mogan","angel@gmail.com","649011184","DAM","1");

create table estudiante(
  CIAL varchar(15) primary key,
  nombre varchar(20),
  apellidos varchar(40),
  direccion varchar(40),
  email varchar(30),
  tlf varchar(9),
  ciclo varchar(20),
  curso varchar(1)
);

drop table ciclo;

create table ciclo(
  codigo INTEGER auto_increment primary key,
  curso varchar(1),
  nombre varchar(20),
  abreviatura varchar(5)
);

create table modulo(
  codigo INTEGER auto_increment primary key,
  nombre varchar(20),
  abreviatura varchar(5)
);

drop table matricula;

create table matricula(
  CIALEstudiante varchar(15),
  codCiclo INTEGER,
  fecha date,
  primary key(CIALEstudiante,codCiclo),
  foreign key matricula(CIALEstudiante) references estudiante(CIAL),
  foreign key matricula(codCiclo) references modulo(codigo)
);

select * from estudiante;

delete from estudiante where nombre="R";