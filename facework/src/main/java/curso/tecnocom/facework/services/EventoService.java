package curso.tecnocom.facework.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import curso.tecnocom.facework.daos.EventoDaoInterface;
import curso.tecnocom.facework.datos.Evento;

public class EventoService implements EventoServiceInterface
{
	@Autowired
	private EventoDaoInterface eventoDao;
	
	@Override
	public Evento getEvento(int id)
	{
		return getEventoDao().findById(id);
	}

	@Override
	public List<Evento> getEventos(Date date)
	{
		return getEventoDao().findByFechaCreacion(date);
	}

	@Override
	public List<Evento> getEventos(String creador)
	{
		return getEventoDao().findByCreador(creador);
	}

	@Override
	public List<Evento> getEventos()
	{
		return getEventoDao().findAll();
	}

	@Override
	public void insertarOrGuardarEvento(Evento evento)
	{
		getEventoDao().insertOrUpdate(evento);	
	}

	@Override
	public void borrarEvento(Evento evento)
	{
		getEventoDao().delete(evento);
		
	}

	public EventoDaoInterface getEventoDao()
	{
		return eventoDao;
	}

	public void setEventoDao(EventoDaoInterface eventoDao)
	{
		this.eventoDao = eventoDao;
	}

}
