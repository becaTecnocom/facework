package curso.tecnocom.facework.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import curso.tecnocom.facework.datos.Curso;
import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.EventoCalendario;
import curso.tecnocom.facework.datos.Tarea;


@Repository
public class CursoDao extends GenericDao implements CursoDaoInterface
{

	@Override
	public void insert(Curso curso)
	{
		getSession().saveOrUpdate(curso);

	}

	@Override
	public void delete(Curso curso)
	{
		getSession().delete(curso);

	}

	@Override
	public List<Curso> findAll()
	{
		Criteria criteria = getSession().createCriteria(Curso.class);
		return criteria.list();
	}

	@Override
	public Curso findCursoByID(int id)
	{
		Criteria criteria = getSession().createCriteria(Curso.class)
				.add(Restrictions.eq("id",id));
		
		return (Curso) criteria.uniqueResult();
	}

	@Override
	public Datospersonale findProfesor(Curso curso)
	{
		Criteria criteria = getSession().createCriteria(Curso.class)
				.add(Restrictions.eq("profesor_id",id));
		
		return (Datopersonale) criteria.uniqueResult();
	}

	@Override
	public List<Curso> findCursosbyProfesor(Datospersonale profesor)
	{
		Criteria criteria = getSession().createCriteria(Curso.class)
				.add(Restrictions.eq("id",id));
		
		return (Curso) criteria.uniqueResult();
	}

	@Override
	public EventoCalendario findDate(Curso curso)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
