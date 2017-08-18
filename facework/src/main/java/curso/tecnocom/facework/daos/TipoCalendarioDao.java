package curso.tecnocom.facework.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import curso.tecnocom.facework.datos.Evento;
import curso.tecnocom.facework.datos.TipoCalendario;

public class TipoCalendarioDao extends GenericDao implements TipoCalendarioDaoInterface
{

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	public static void main(String[] args)
	{
					
					Configuration configuration = new Configuration();
					SessionFactory factoria = configuration.configure().buildSessionFactory();
					Session session = factoria.openSession();
					
					Criteria criteriaTipo = session.createCriteria(TipoCalendarioDaoInterface.class);
					
					
	}

	@Override
	@Transactional
	public TipoCalendario findbyId(int id)
	{
		Criteria criteria = getSession().createCriteria(TipoCalendario.class).add(Restrictions.eq("idcalendario",id));
		
		return (TipoCalendario) criteria.uniqueResult();
	}


	@Override
	@Transactional
	public List<TipoCalendario> findAll()
	{
		Criteria criteria = getSession().createCriteria(TipoCalendario.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public void insertOrUpdate(Evento tipo)
	{
		getSession().saveOrUpdate(tipo);
		
	}

	@Override
	@Transactional
	public void delete(Evento tipo)
	{
		
		getSession().delete(tipo);
	}




	

}
