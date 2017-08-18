package curso.tecnocom.facework.daos;

import java.sql.Date;
import java.util.List;

import curso.tecnocom.facework.datos.Evento;

//@Repository
public interface EventoDaoInterface
{
	public Evento findById(int id);

	public List<Evento> findByFechaCreacion(Date date);

	public List<Evento> findByCreador(String creador);

	public List<Evento> findAll();

	public void insertOrUpdate(Evento evento);// add

	public void delete(Evento evento);
}
