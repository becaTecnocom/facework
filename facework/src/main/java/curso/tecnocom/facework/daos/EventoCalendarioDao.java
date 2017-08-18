package curso.tecnocom.facework.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.EventoCalendario;
import curso.tecnocom.facework.excepciones.NoIDException;

public class EventoCalendarioDao extends GenericDao implements EventoCalendarioDaoInterface
{

	// Configuration configuration = new Configuration();
	// SessionFactory factoria =
	// configuration.configure().buildSessionFactory();
	// Session session = factoria.openSession();
	Session session = null;

	@Override
	@Transactional
	public void insert(EventoCalendario eventoCalendario)
	{
		session.saveOrUpdate(eventoCalendario);
	}

	@Override
	public void delete(EventoCalendario eventoCalendario)
	{
		session.delete(eventoCalendario);
	}

	@Override
	@Transactional
	public void edit(EventoCalendario eventoCalendario)
	{
		session.saveOrUpdate(eventoCalendario);
	}

	@Override
	public List<EventoCalendario> showlAll()
	{
		List<EventoCalendario> lista = new ArrayList<EventoCalendario>();
		int i = 1;
		while (session.get(EventoCalendario.class, i) != null)
			lista.add(session.get(EventoCalendario.class, i));
		i++;
		return lista;
	}

	@Override
	public EventoCalendario findEventoCalendarioByID(int ID) throws NoIDException
	{
		try
		{
			Criteria criteriaEventoCalendario = session.createCriteria(EventoCalendario.class);
			criteriaEventoCalendario.add(Restrictions.eq("id", ID));
			return (EventoCalendario) criteriaEventoCalendario;
		} catch (HibernateException e)
		{
			throw new NoIDException("No existe ese calendario");
		}

	}

	@Override
	public List<Datospersonale> findParticipantesByEventoCalendario(EventoCalendario eventoCalendario)
	{

		List<Datospersonale> participantes = eventoCalendario.getDatospersonales();

		return participantes;
	}

}
