package curso.tecnocom.facework.daos;

import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.Equipo;
import curso.tecnocom.facework.datos.Proyecto;

public interface EquipoDaoInterface
{
	public void crearEquipo(Proyecto proyecto,Equipo equipo)throws Exception;
	public void borrarEquipo()throws Exception;
	public void insertarUsuarioEquipo(Datospersonale datospersonale,Equipo equipo)throws Exception;
	public void borrarUsuarioEquipo(Datospersonale datospersonale,Equipo equipo)throws Exception;

}  
    