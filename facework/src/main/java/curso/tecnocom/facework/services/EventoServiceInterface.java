package curso.tecnocom.facework.services;

import java.sql.Date;
import java.util.List;

import curso.tecnocom.facework.datos.Evento;

public interface EventoServiceInterface
{
	public Evento getEvento(int id);
	public List<Evento> getEventos(Date date);
	public List<Evento> getEventos(String creador);
	public List<Evento> getEventos();
	
	public void insertarOrGuardarEvento(Evento evento);
	public void borrarEvento(Evento evento);
}
