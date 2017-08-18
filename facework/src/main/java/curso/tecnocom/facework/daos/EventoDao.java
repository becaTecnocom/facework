package curso.tecnocom.facework.daos;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import curso.tecnocom.facework.datos.Evento;


public class EventoDao extends GenericDao implements EventoDaoInterface
{
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	@Override
	@Transactional
	public Evento findById(int id)
	{
		Criteria criteria = getSession().createCriteria(Evento.class)
				.add(Restrictions.eq("id",id));
		
		return (Evento) criteria.uniqueResult();
	}

	@Override
	@Transactional
	public List<Evento> findByFechaCreacion(Date date)
	{
		Criteria criteria = getSession().createCriteria(Evento.class);
		criteria.add(Restrictions.eq("fecha_creacion",date));
		return criteria.list();
	}

	@Override
	@Transactional
	public List<Evento> findByCreador(String creador)
	{
		Criteria criteria = getSession().createCriteria(Evento.class);
		criteria.add(Restrictions.eq("creador",creador));
		return criteria.list();
	}

	@Override
	@Transactional
	public List<Evento> findAll()
	{
		Criteria criteria = getSession().createCriteria(Evento.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public void insertOrUpdate(Evento evento)
	{
		getSession().saveOrUpdate(evento);
		
	}

	@Override
	@Transactional
	public void delete(Evento evento)
	{
		getSession().delete(evento);
		
	}


	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public Session getSession()
	{
		return session;
	}

	public void setSession(Session session)
	{
		this.session = session;
	}

}
