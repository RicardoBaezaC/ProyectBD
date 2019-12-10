use master;
go
DROP DATABASE IF exists Viaje_Placentero
create database Viaje_Placentero;
go
use Viaje_Placentero;
go

create table TipoEmpleado(
  Id_Tipo int identity(1,1) primary key not null,
  Nom_Tipo varchar(20) not null
  constraint CHK_TipoEmpleado 
    check(Nom_Tipo in ('Chofer','Copiloto','Terramoza','Vendedor'))
);


create table Agencia(
  Id_Agencia int identity(1,1) primary key not null,
  Nombre_Agencia varchar(30) not null,
  Calle varchar(30) not null,
  Colonia varchar(30) not null,
  Codigo_postal varchar(15) not null,
  Ciudad varchar(30) not null,
  Estado varchar(30) not null,
  Numero varchar(15) not null
); --Dirección


create table Empleado(
  Id_Empleado int identity(1,1) primary key not null,
  Nombre varchar(40) not null,
  Apellidos varchar(40) not null,
  Tipo_Empleado int not null references TipoEmpleado(Id_Tipo),-- aqui obviamente referencio los tipos de empleado que seran (chofer, terramoza, copiloto,vendedor y cartero)
  Id_Agencia int not null references Agencia(Id_Agencia)
);-- aqui esta la fk de agencia bue


create table Tripulacion(
Id_Tripulacion int identity(1,1) primary key not null,
Id_Chofer int not null  references Empleado(Id_Empleado),--referncia a empleado
Id_Copiloto int not null  references Empleado(Id_Empleado),--referncia a empleado
Id_Terramoza int not null  references Empleado(Id_Empleado));--referncia a empleado


create table Viaje(
Id_Viaje int identity(1,1) primary key not null,
CiudadOrigen varchar(30) not null,
EstadoOrigen varchar(30) not null,
CiudadDestino varchar(30) not null,
EstadoDestino varchar(30) not null,
Fecha date not null,
Hora_Partida time not null);


create table TipoAutobus(
Id_Tipo int identity(1,1) primary key not null,
Clase_Camion varchar(20) not null constraint CHK_Clase check(Clase_Camion in ('Primera clase','Ejecutivo','Presidencial')));

create table Autobus(
Id_Autobus int identity(1,1) primary key not null,
Marca varchar(30),
AsientosDisponibles int not null,
Capacidad int not null,
Programable varchar(2) not null constraint CHK_Programable CHECK(Programable IN ('SI','NO')),--para entenderle a esto, haste esta pregunta. �Necesita mantenimiento?
Tipo_Autobus int not null  references TipoAutobus(Id_Tipo));-- aqui obviamente referencio la clase de camion que sera(presidencial,ejecutivo, primera clase)


-- lo de aqui abajo es la tabla que surge de la relacion N-N  de tripulacion y viaje
create table Trip_Viaje(
Id_TripViaje int identity(1,1) primary key not null,
Id_Viaje int not null  references Viaje(Id_Viaje),
Id_Tripulacion int not null  references Tripulacion(Id_Tripulacion));


-- lo de aqui abajo es la tabla que surge de la relacion N-N  de autobus  y viaje
create table Camion_Viaje(
Id_CamionViaje int identity(1,1) primary key not null,
Id_Autobus int not null references Autobus(Id_Autobus),
Id_Viaje int not null  references Viaje(Id_Viaje));


create table Equipaje(
Id_Equipaje int identity(1,1) primary key not null,
Peso float  not null,
CostoXKgAdicional money);


create table Pasajero(
  Id_Pasajero int identity(1,1) primary key not null,
  Nombre varchar(40) not null ,
  Apellidos varchar(40) not null,
  FechaNacimiento date not null,
  Calle varchar(30) not null,
  Colonia varchar(30) not null,
  Codigo_Postal varchar(15) not null,
  Ciudad varchar(30) not null,
  Estado varchar(30) not null,
  Numero varchar(15)not null, --Direccion
  Telefono varchar(10),
  DNI varchar(18) not null,
  RFC_Comprador varchar (13) not null,
  Id_Equipaje int references Equipaje(Id_Equipaje)
);


--boleto es la agregacion
create table Boleto(
Id_Boleto int identity(1,1) primary key not null,
Fecha_Emision date not null,
Costo money not null,
No_Asiento int not null,
Reserva varchar(2) constraint CHK_Reserva CHECK(reserva IN ('SI','NO')),
Id_Empleado int not null references Empleado(Id_Empleado),
Id_Viaje int not null references Viaje(Id_Viaje),
Id_Pasajero int not null references Pasajero(Id_Pasajero));


create table Remitente (
Id_Remitente int identity(1,1) primary key not null,
Nombre varchar(40) not null,
Apellidos varchar(40) not null,
Razon_Social varchar(40),
Direccion varchar(50) not null,
Ciudad varchar(25)not null);


create table Destinatario(
Id_Destinatario int identity(1,1) primary key not null,
Nombre varchar(40) not null,
Apellidos varchar(40) not null,
Direccion varchar(50) not null,
Ciudad varchar(25) not null);


create table Comprobante(
Id_Comprobante int identity(1,1) primary key not null,
FK_Remitente int references Remitente(Id_Remitente) not null,
FK_Destinatario int references Destinatario(Id_Destinatario) not null);


create table Factura(
Id_Factura int identity(1,1) primary key not null,
UsoCFDI varchar(30) not null,
FK_Comprobante int references Comprobante(Id_Comprobante) constraint UNI_FKComprobante unique(FK_Comprobante),
FK_Boleto int references Boleto(Id_Boleto) constraint UNI_FKBoleto unique(FK_Boleto));


create table CamionCarga(
Id_Camion int identity(1,1) primary key not null,
Marca varchar(25) not null,
Capacidad int not null);


create table Paquete(
Id_Paquete int identity(1,1) primary key not null,
Peso float not null,
Tipo_Servicio varchar(10) not null constraint CHK_TipoPaqueteria check(Tipo_Servicio in ('Regular','Express')),
FK_TransporteCarga int references CamionCarga(Id_Camion),
FK_Autobus int references Autobus(Id_Autobus),
FK_Comprobante int references Comprobante(Id_Comprobante));


create table Sobre(
Id_Sobre int identity(1,1) primary key not null,
Tipo_Servicio int not null constraint CHK_TipoCorrespondencia check(Tipo_Servicio in ('Regular','Express')),
FK_TransporteCarga int references CamionCarga(Id_Camion),
FK_Comprobante int references Comprobante(Id_Comprobante));

insert into TipoAutobus values
('Primera clase'),
('Ejecutivo'),
('Presidencial');

insert into TipoEmpleado values
('Chofer'),
('Copiloto'),
('Terramoza'),
('Vendedor');

insert into Agencia values
('Viaje Placentero Colima','San Isidro','Cruz de Comala',28979,'Villa de Álvarez','Colima',418);

select * from Empleado
