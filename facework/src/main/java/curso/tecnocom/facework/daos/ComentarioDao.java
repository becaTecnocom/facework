package curso.tecnocom.facework.daos;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.tuple.entity.EntityMetamodel.GenerationStrategyPair;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import curso.tecnocom.facework.datos.Comentario;
import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.Mensaje;
import curso.tecnocom.facework.datos.Publicacione;

@Repository
public class ComentarioDao extends GenericDao implements ComentarioDaoInterface
{
	
	@Override
	@Transactional
	public void escribirComentarioEnPublicacion(Publicacione publicacion,Datospersonale usuario,String mensaje)
	{
		Comentario comentario = new Comentario();
				
		comentario.setDatospersonale(usuario);		
		
		comentario.setComentario(mensaje);
	
		publicacion.getComentarios().add(comentario);
		getSession().flush();
	
	}

	@Override
	public List<Object> verComentarioEnPublicacion(Publicacione publicacion)
	{
		
		List<Object> listaMensaje = new ArrayList<Object>();
		
		listaMensaje.addAll(publicacion.getComentarios());
		
		return listaMensaje;
	}

	@Override
	@Transactional
	public void editarComentario(Publicacione publicacion, Datospersonale usuario, Comentario idComentario,
			String mensaje) throws Exception
	{
		Comentario comentarioNuevo= getSession().load(Comentario.class, idComentario.getId());
		Datospersonale usuariocomentario= comentarioNuevo.getDatospersonale();
		
		if(usuariocomentario.equals(usuario)) {
			comentarioNuevo.setComentario(mensaje);
			publicacion.getComentarios().add(comentarioNuevo);
			getSession().flush();
		}else {
			throw new Exception();
		}
		
	}

	@Override
	@Transactional
	public void borrarComentario(Publicacione publicacion, Datospersonale usuario, Comentario idComentario)
	{
		Comentario comentarioNuevo= getSession().load(Comentario.class, idComentario.getId());
		Datospersonale usuariocomentario= comentarioNuevo.getDatospersonale();
		
		if(usuariocomentario.equals("albertito")) {
			
		}
		
	}

}
