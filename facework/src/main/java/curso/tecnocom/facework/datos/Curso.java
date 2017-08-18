package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cursos database table.
 * 
 */
@Entity
@Table(name="cursos")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Datospersonale
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="profesor_id")
	private Datospersonale datospersonale;

	//bi-directional many-to-one association to EventoCalendario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="evento_calendario_id")
	private EventoCalendario eventoCalendario;

	public Curso() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Datospersonale getDatospersonale() {
		return this.datospersonale;
	}

	public void setDatospersonale(Datospersonale datospersonale) {
		this.datospersonale = datospersonale;
	}

	public EventoCalendario getEventoCalendario() {
		return this.eventoCalendario;
	}

	public void setEventoCalendario(EventoCalendario eventoCalendario) {
		this.eventoCalendario = eventoCalendario;
	}

}