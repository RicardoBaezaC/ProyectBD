use Viaje_Placentero
create proc CrearViaje(
	@cdOrigen varchar(30),
	@edoOrigen varchar(30),
	@cdDestino varchar(30),
	@edoDestino varchar(30),
	@fecha date,
	@hora time,
	@tripulacion int,
	@autobus int
)
as
begin try
	begin transaction
	declare @idviaje int
	insert into Viaje values (@cdOrigen,@edoOrigen,@cdDestino,@edoDestino,@fecha,@hora);
	select @idviaje=IDENT_CURRENT('Viaje');
	insert into Trip_Viaje values (@idviaje,@tripulacion);
	insert into Camion_Viaje values(@autobus,@idviaje);
	commit transaction
end try
begin catch
	rollback transaction
end catch

create proc ModificarViaje(
	@idviaje int,
	@cdOrigen varchar(30),
	@edoOrigen varchar(30),
	@cdDestino varchar(30),
	@edoDestino varchar(30),
	@fecha date,
	@hora time,
	@tripulacion int,
	@autobus int
)
as
begin try
	begin transaction
	update Viaje set CiudadOrigen=@cdOrigen,EstadoOrigen=@edoOrigen,CiudadDestino=@cdDestino,EstadoDestino=@edoDestino,
	Fecha=@fecha, Hora_Partida=@hora where Id_Viaje=@idviaje;
	update Trip_Viaje set Id_Tripulacion=@tripulacion where Id_Viaje=@idviaje;
	update Camion_Viaje set Id_Autobus=@autobus where Id_Viaje=@idviaje;
	commit transaction
end try
begin catch
	rollback transaction
end catch
