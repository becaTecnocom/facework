package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tareas database table.
 * 
 */
@Entity
@Table(name="tareas")
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to EventoCalendario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="evento_calendario_id")
	private EventoCalendario eventoCalendario;

	public Tarea() {
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

	public EventoCalendario getEventoCalendario() {
		return this.eventoCalendario;
	}

	public void setEventoCalendario(EventoCalendario eventoCalendario) {
		this.eventoCalendario = eventoCalendario;
	}

}