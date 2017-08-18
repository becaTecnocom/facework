package curso.tecnocom.facework.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import curso.tecnocom.facework.configuracion.Configuracion;
import curso.tecnocom.facework.daos.EventoCalendarioDaoInterface;
import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.EventoCalendario;
import curso.tecnocom.facework.excepciones.NoIDException;

public class EventoCalendarioService implements EventoCalendarioServiceInterface
{
	private EventoCalendarioDaoInterface eventoCalendarioDao;

	@Override
	public void insert(EventoCalendario eventoCalendario)
	{
		
		eventoCalendarioDao.insert(eventoCalendario);
		
	}

	@Override
	public void delete(EventoCalendario eventoCalendario)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(EventoCalendario eventoCalendario)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EventoCalendario> showlAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventoCalendario findEventoCalendarioByID(int ID) throws NoIDException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Datospersonale> findParticipantesByEventoCalendario(EventoCalendario eventoCalendario)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}