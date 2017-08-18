package curso.tecnocom.facework.daos;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import curso.tecnocom.facework.anotaciones.SessionManager;
import curso.tecnocom.facework.datos.Amistade;
import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.Mensaje;

public class MensajeDao extends GenericDao implements MensajeDaoInterface
{

	@Override
	@SessionManager
	public void grabarMensaje(String texto, List<Datospersonale> datospersonale) throws Exception
	{
		//Fecha
		GregorianCalendar fecha = new GregorianCalendar();
		Date fechaDate = fecha.getTime();
		
		getSession().beginTransaction();
		Datospersonale datospersonaleEmisor = getSession().load(Datospersonale.class, 1/*Poner ID nuestro (emisor) cuando tengamos sesiones*/);
		
		Mensaje mensaje = new Mensaje();
		mensaje.setDatospersonale(datospersonaleEmisor);
		mensaje.setDatospersonales(datospersonale);
		mensaje.setLeido((byte)0);
		mensaje.setFecha(fechaDate);
		
		getSession().getTransaction().commit();	
	}

	@Override
	@SessionManager
	public List<Mensaje> findMensajesByDatosPersonaleOrderByDate(Datospersonale datospersonale) throws Exception
	{
		String query = "SELECT mensaje, leido, fecha FROM mensajes WHERE ";
		Datospersonale datospersonalePropios = getSession().load(Datospersonale.class, 1/*Poner ID nuestro (emisor) cuando tengamos sesiones*/);
		
		
		
		return null;
	}

	@Override
	public void grabarLeido(Mensaje mensaje) throws Exception
	{
		
		

	}

}
