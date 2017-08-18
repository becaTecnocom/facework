package curso.tecnocom.facework.daos;

import java.util.List;

import curso.tecnocom.facework.datos.EventoCalendario;
import curso.tecnocom.facework.datos.Tarea;

public interface TareaDaoInterface
{

	public void insertOrUpdate(Tarea tarea);
	public void delete(Tarea tarea);
	public List<Tarea> findAll();
	public Tarea findTareaById(int id);
	public List<Tarea> tareasTipos(EventoCalendario eventoCalendario);
//	public Tarea getTarea();
//	public void setTarea(Tarea tarea);
}
