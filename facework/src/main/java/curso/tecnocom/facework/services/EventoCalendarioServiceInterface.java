package curso.tecnocom.facework.services;

import java.util.List;

import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.EventoCalendario;
import curso.tecnocom.facework.excepciones.NoIDException;

public interface EventoCalendarioServiceInterface
{
	public void insert(EventoCalendario eventoCalendario);

	public void delete(EventoCalendario eventoCalendario);

	public void edit(EventoCalendario eventoCalendario);

	public List<EventoCalendario> showlAll();

	public EventoCalendario findEventoCalendarioByID(int ID) throws NoIDException;

	public List<Datospersonale> findParticipantesByEventoCalendario(EventoCalendario eventoCalendario);

}
