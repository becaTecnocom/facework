package curso.tecnocom.facework.daos;

import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.Publicacione;

public interface PublicacionDaoInterface
{
	public void crearPublicacion(Publicacione publicacione)throws Exception;
	public void modificarPublicacion(Publicacione publicacione)throws Exception;
	public void borrarPublicacion(Publicacione publicacione)throws Exception;
	public void insertarComentarioPublicacion(Publicacione publicacione, String texto, Datospersonale datospersonale)throws Exception;
	public void insertarLikeComentario(Publicacione publicacione, Datospersonale datospersonale)throws Exception;
}
     