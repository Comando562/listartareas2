create table tarea
(

    id          bigint       not null auto_increment,
    titulo      varchar(100) not null,
    descripcion varchar(100) not null,
    fecha       DATE         not null,
    completado  TINYINT(1),

    primary key (id)

);