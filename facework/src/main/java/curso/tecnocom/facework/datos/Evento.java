package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String creador;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	//bi-directional many-to-one association to EventoCalendario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="evento_calendario_id")
	private EventoCalendario eventoCalendario;

	public Evento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreador() {
		return this.creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public EventoCalendario getEventoCalendario() {
		return this.eventoCalendario;
	}

	public void setEventoCalendario(EventoCalendario eventoCalendario) {
		this.eventoCalendario = eventoCalendario;
	}

}