package curso.tecnocom.facework.daos;


import java.util.List;

import curso.tecnocom.facework.datos.Curso;
import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.EventoCalendario;

public interface CursoDaoInterface
{
	public void insert(Curso curso);
	public void delete(Curso curso);
	public List<Curso> findAll();
	public Curso findCursoByID(int id);
	public Datospersonale findProfesor(Curso curso);
	public List<Curso> findCursosbyProfesor(Datospersonale profesor);
	public EventoCalendario findDate(Curso curso);
	
}
