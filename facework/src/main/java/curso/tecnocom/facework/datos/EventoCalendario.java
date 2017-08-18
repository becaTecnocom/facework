package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the evento_calendario database table.
 * 
 */
@Entity
@Table(name="evento_calendario")
@NamedQuery(name="EventoCalendario.findAll", query="SELECT e FROM EventoCalendario e")
public class EventoCalendario implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	private String lugar;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="eventoCalendario")
	private List<Curso> cursos;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="eventoCalendario")
	private List<Evento> eventos;

	//bi-directional many-to-many association to Datospersonale
	@ManyToMany
	@JoinTable(
		name="datospersonales_has_evento_calendario"
		, joinColumns={
			@JoinColumn(name="evento_calendario_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="datospersonales_id")
			}
		)
	private List<Datospersonale> datospersonales;

	//bi-directional many-to-one association to TipoCalendario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_Calendario_idcalendario")
	private TipoCalendario tipoCalendario;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="eventoCalendario")
	private List<Tarea> tareas;

	public EventoCalendario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setEventoCalendario(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setEventoCalendario(null);

		return curso;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setEventoCalendario(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setEventoCalendario(null);

		return evento;
	}

	public List<Datospersonale> getDatospersonales() {
		return this.datospersonales;
	}

	public void setDatospersonales(List<Datospersonale> datospersonales) {
		this.datospersonales = datospersonales;
	}

	public TipoCalendario getTipoCalendario() {
		return this.tipoCalendario;
	}

	public void setTipoCalendario(TipoCalendario tipoCalendario) {
		this.tipoCalendario = tipoCalendario;
	}

	public List<Tarea> getTareas() {
		return this.tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Tarea addTarea(Tarea tarea) {
		getTareas().add(tarea);
		tarea.setEventoCalendario(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getTareas().remove(tarea);
		tarea.setEventoCalendario(null);

		return tarea;
	}

}