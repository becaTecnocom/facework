package curso.tecnocom.facework.daos;

import java.util.List;

import curso.tecnocom.facework.datos.Comentario;
import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.Publicacione;

public interface ComentarioDaoInterface
{

	public void escribirComentarioEnPublicacion(Publicacione publicacion, Datospersonale usuario,String mensaje) throws Exception;
	public List<Object> verComentarioEnPublicacion(Publicacione publicacion) throws Exception;
	public void editarComentario(Publicacione publicacion,Datospersonale usuario,Comentario idComentario,String mensaje) throws Exception;
	public void borrarComentario(Publicacione publicacion,Datospersonale usuario,Comentario idComentario) throws Exception;
	
}    
    