package curso.tecnocom.facework.daos;

import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.Usuario;

public interface DatoPersonaleDaoInterface
{
	

	public void altaUsuario(Datospersonale datospersonale) throws Exception;	
	
	public void actualizaDatosPersonales(Datospersonale datospersonale) throws Exception;
	
	public Datospersonale getDatoPersonalByDNI(String dni)throws Exception;

	
	
	public void bajaUsuario(Usuario usuario) throws Exception;
	
	public void cambiarPassword(Usuario usuario, String password) throws Exception;
	
	public void activaDesactivaUsuario(Usuario usuario,boolean activar) throws Exception;
	
	
	
	
	  

}
    