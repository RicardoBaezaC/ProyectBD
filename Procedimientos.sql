use Viaje_Placentero
-- Procedimientos Almacenado 
--1 Dame los nombres de los clientes que han comprado voletos el dia de hoy
create proc CompraDiaria as
declare @dt datetimeoffset = switchoffset (convert(datetimeoffset, getdate()), '-04:00');
select Nombre, Apellido from Pasajero as P join Boleto as B
on P.IdPasajero=B.IdPasajero where FechaEmision = @dt
--Ejecutable
exec CompraDiaria

--2 Dame los datos de los viajes que se realizaron o tienen programados el dia de hoy
create proc ViajesProg as
declare @dat datetimeoffset = switchoffset (convert(datetimeoffset, getdate()), '-04:00');
select * from Pasajero where Fecha = @dat
--Ejecutable
exec ViajesProg

--3 Dame el total de Ganancias de venta de voletos del dia de hoy
create proc GananciasHoy as
declare @dte datetimeoffset = switchoffset (convert(datetimeoffset, getdate()), '-04:00');
select SUM(Costo) as 'Total del Dia' from Boleto where Fecha = @dte
--Ejecutable
exec GananciasHoy

--4 Dame el Los Datos de los empleados que lavoran en la Agencia
create proc EmpActuales as
select * from Empleado
--Ejecutable
exec EmpActuales

--5 Dame los Datos de los autobuses que necesitan mantenimiento
create proc ManteAutobus as
select A.Id_Autobus, A.Marca, A.AsientosDisponibles, A.Capacidad, A.Programable, TA.Clase_Camion 
from Autobus as A join TipoAutobus as TA on A.Id_Tipo=TA.Id_Tipo
where Programable = ´SI´
--Ejecutable
exec ManteAutobus

--6 Dame los nombres, id del pasajero y su id de boleto de los pasajeros que hayan dado un pago adicional por peso extra de pasaje y cuanto pagaron 
create  proc PagoExtra as
select P.Id_Pasajero, P.Nombre, B.Id_Boleto, E.Peso, E.Costo_Adicional 
from Boleto as B join Pasajero as P on B.Id_Pasajero=P.Id_Pasajero join Equipaje as E on P.Id_Equipaje=E.Id_Equipaje
where E.Peso>20
--Ejecutable
exec  PagoExtra

--7 Cuales fueron los viajes realizados el dia de hoy
create proc ViajesDeldDia as
declare @fech datetimeoffset = switchoffset (convert(datetimeoffset, getdate()), '-04:00');
select * from Viaje where Fecha<@fech 
--Ejecutable
exec  ViajesDeldDia


create proc IngresarViaje(@cdOrigen varchar(30),@edoOrigen varchar(30),@cdDestino varchar(30),@edoDestino varchar(30),@fecha date,@hora time)
as begin
insert into Viaje values (@cdOrigen,@edoOrigen,@cdDestino,@edoDestino,@fecha,@hora)
end
go

create proc IngresarAutobus(@marca varchar(30),@asientosDis int,@capacidad int,@programable varchar(2),@tipo int)
as begin
insert into Autobus values (@marca,@asientosDis,@capacidad,@programable,@tipo)
end
go

create proc IngresarEmpleado(@nombre varchar(40),@apellidos varchar(40),@tipoEmp int,@agencia int)
as begin
insert into Empleado values (@nombre,@apellidos,@tipoEmp,@agencia)
end
go

create proc IngresarTripulacion(@Id_Chofer int, @Id_Copiloto int, @Id_Terramoza int)
as begin
insert into Tripulacion values(@Id_Chofer,@Id_Copiloto,@Id_Terramoza)
end 
go

use Viaje_Placentero
create proc IngresarCamion(@marca varchar(25), @capacidad int)
as begin
insert into CamionCarga values(@marca,@capacidad)
end 
go

Select * from Autobus

select * from Tripulacion
use Viaje_Placentero
select V.Id_Viaje,V.EstadoOrigen,V.CiudadOrigen,V.EstadoDestino,V.CiudadDestino,V.Fecha,V.Hora_Partida,TV.Id_Tripulacion,CV.Id_Autobus from Viaje as V join Trip_Viaje as TV on V.Id_Viaje=TV.Id_Viaje join Camion_Viaje as CV on CV.Id_Viaje=V.Id_Viaje;
select * from Viaje
select * from Autobus 
delete from Autobus where Id_Autobus=3


