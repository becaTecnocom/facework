package curso.tecnocom.facework.daos;

import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.Grupo;

public interface GrupoDaoInterface
{
	public void crearGrupos(Grupo grupo)throws Exception;
	public void borrarGrupo(Grupo grupo)throws Exception;
	public void anadirUsuarioGrupo(Grupo grupo, Datospersonale datospersonale)throws Exception;
	public void borrarUsuarioGrupo(Grupo grupo, Datospersonale datospersonale)throws Exception;
  
}
     