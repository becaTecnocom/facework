package curso.tecnocom.facework.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import curso.tecnocom.facework.anotaciones.SessionManager;
import curso.tecnocom.facework.datos.Amistade;
import curso.tecnocom.facework.datos.Datospersonale;

public class AmistadesDao extends GenericDao implements AmistadesDaoInterface
{

	@Override
	@SessionManager
	public void grabarSolicitud(Datospersonale datospersonaleReceptor) throws Exception
	{
		getSession().beginTransaction();
		Datospersonale datospersonaleEmisor = getSession().load(Datospersonale.class, 1/*Poner ID nuestro (emisor) cuando tengamos sesiones*/);
		Amistade amistade=new Amistade();
		amistade.setDatospersonale1(datospersonaleEmisor);
		amistade.setDatospersonale2(datospersonaleReceptor);
		amistade.setAceptado((byte) 0);
		getSession().saveOrUpdate(amistade);
		getSession().getTransaction().commit();	
	}

	@Override
	@SessionManager
	public List<Datospersonale> findSolicitudes() throws Exception
	{
		//String query = "select datospersonales_id from amistades where datospersonales_id1 = 'nuestro_ID' and aceptado=false";
		Criteria criteriaAmistade = getSession().createCriteria(Amistade.class);
		criteriaAmistade.add(Restrictions.and(Restrictions.eq("datospersonale2", "nuestro_ID"), Restrictions.eq("aceptado", (byte)0)));
		
		List<Datospersonale> solicitudesRecibidas = criteriaAmistade.list();
		return solicitudesRecibidas;
	}

	@Override
	@SessionManager
	public void grabarAceptacion(Amistade amistade) throws Exception
	{
		getSession().beginTransaction();
		amistade.setAceptado((byte) 1);
		getSession().saveOrUpdate(amistade);
		getSession().getTransaction().commit();	

	}

	@Override
	@SessionManager
	public List<Datospersonale> findAmigosByDatopersonale(Datospersonale datospersonale) throws Exception
	{
		//String query = "select datospersonales_id, datospersonales_id1 from amistades where (datospersonales_id1 = 'id_pasado' or datospersonales_id ='id_pasado') and aceptado=true";
		Criteria criteriaAmigos = getSession().createCriteria(Amistade.class);
		criteriaAmigos.add(Restrictions.and(Restrictions.or(Restrictions.eq("datospersonale1", datospersonale.getId()), Restrictions.eq("datospersonale2", datospersonale.getId())), Restrictions.eq("aceptado", (byte)1)));
		
		List<Datospersonale> amigosByDatopersonale = criteriaAmigos.list();
		return amigosByDatopersonale;
	}

}
