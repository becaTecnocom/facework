package curso.tecnocom.facework.daos;

import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.Proyecto;


public interface ProyectoDaoInterface
{
	public void crearProyecto(Proyecto proyecto)throws Exception;
	public void borrarProyecto(Proyecto proyecto)throws Exception;
	public void anadirUsuarioProyecto(Proyecto proyecto, Datospersonale datospersonale)throws Exception;
	public void borrarUsuarioProyecto(Proyecto proyecto, Datospersonale datospersonale)throws Exception;
}
     