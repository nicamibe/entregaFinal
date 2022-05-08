create table clientes (
      id number not null auto_increment,
      nombre varchar(255) not null,
      apellido varchar(255) not null,
      dni number not null,
      direccion varchar(255) not null,
      primary key (id)
);

create table empresas (
      id number not null auto_increment,
      nombre varchar(255) not null,
      rubro varchar(255) not null,
      primary key (id)
);

create table productos (
      id number not null auto_increment,
      nombre varchar(255) not null,
      descripcion varchar(255) not null,
      nro_producto number not null,
      precio decimal not null,
      cantidad_disponible number not null,
      primary key (id)
);
