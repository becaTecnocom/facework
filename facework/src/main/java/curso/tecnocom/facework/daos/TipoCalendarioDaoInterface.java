package curso.tecnocom.facework.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import curso.tecnocom.facework.datos.Evento;
import curso.tecnocom.facework.datos.TipoCalendario;

public interface TipoCalendarioDaoInterface
{
	public TipoCalendario findbyId(int id);
	List<TipoCalendario> findAll();
	
	public void insertOrUpdate(Evento tipo);
	public void delete(Evento tipo);

}
