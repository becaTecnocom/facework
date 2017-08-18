package curso.tecnocom.facework.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import curso.tecnocom.facework.datos.EventoCalendario;
import curso.tecnocom.facework.datos.Tarea;

public class TareaDao extends GenericDao implements TareaDaoInterface
{

	
	@Override
	public void insertOrUpdate(Tarea tarea)
	{
		getSession().saveOrUpdate(tarea);

	}

	@Override
	public void delete(Tarea tarea)
	{
		getSession().delete(tarea);

	}

	@Override
	public List<Tarea> findAll()
	{
		Criteria criteria = getSession().createCriteria(Tarea.class);
		return criteria.list();
	}

	@Override
	public Tarea findTareaById(int id)
	{
		Criteria criteria = getSession().createCriteria(Tarea.class)
				.add(Restrictions.eq("id",id));
		
		return (Tarea) criteria.uniqueResult();
	}

	@Override
	public List<Tarea> tareasTipos(EventoCalendario eventoCalendario)
	{
		Criteria criteria = getSession().createCriteria(Tarea.class).add(Restrictions.eqOrIsNull("evento_calendario_id", eventoCalendario.getId()));
		return criteria.list();
	}
//	@Override
//	public Tarea getTarea()
//	{
//		Criteria criteria = getSession().createCriteria(Tarea.class)
//				.add(Restrictions.eq("descripcion",nombre));
//		
//		return (Tarea) criteria.uniqueResult();
//	}

//	@Override
//	public void setTarea(Tarea tarea)
//	{
//		// TODO Auto-generated method stub
//		
//	}

}
