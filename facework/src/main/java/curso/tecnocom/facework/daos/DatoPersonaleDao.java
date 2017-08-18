package curso.tecnocom.facework.daos;

import org.hibernate.Criteria;
import org.hibernate.NonUniqueResultException;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.Usuario;

@Repository
public class DatoPersonaleDao extends GenericDao implements DatoPersonaleDaoInterface
{
	@Override
	@Transactional
	public void altaUsuario(Datospersonale datospersonale) throws Exception
	{
		try
		{
			getSession().saveOrUpdate(datospersonale.getUsuario());
			actualizaDatosPersonales(datospersonale);
		} catch (Exception e)
		{
			System.out.println(e);		
		}
	}

	@Override
	@Transactional
	public void actualizaDatosPersonales(Datospersonale datospersonale) throws Exception
	{
		getSession().saveOrUpdate(datospersonale);
	}

	@Override
	public Datospersonale getDatoPersonalByDNI(String dni) throws Exception
	{
		//Datospersonale
	}

	@Override
	public void bajaUsuario(Usuario usuario) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void cambiarPassword(Usuario usuario, String password) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void activaDesactivaUsuario(Usuario usuario, boolean activar) throws Exception
	{
		// TODO Auto-generated method stub

	}

}
