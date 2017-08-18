package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_calendario database table.
 * 
 */
@Entity
@Table(name="tipo_calendario")
@NamedQuery(name="TipoCalendario.findAll", query="SELECT t FROM TipoCalendario t")
public class TipoCalendario implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcalendario;

	private String descripcion;

	@Column(name="role_id")
	private int roleId;

	//bi-directional many-to-one association to EventoCalendario
	@OneToMany(mappedBy="tipoCalendario")
	private List<EventoCalendario> eventoCalendarios;

	public TipoCalendario() {
	}

	public int getIdcalendario() {
		return this.idcalendario;
	}

	public void setIdcalendario(int idcalendario) {
		this.idcalendario = idcalendario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public List<EventoCalendario> getEventoCalendarios() {
		return this.eventoCalendarios;
	}

	public void setEventoCalendarios(List<EventoCalendario> eventoCalendarios) {
		this.eventoCalendarios = eventoCalendarios;
	}

	public EventoCalendario addEventoCalendario(EventoCalendario eventoCalendario) {
		getEventoCalendarios().add(eventoCalendario);
		eventoCalendario.setTipoCalendario(this);

		return eventoCalendario;
	}

	public EventoCalendario removeEventoCalendario(EventoCalendario eventoCalendario) {
		getEventoCalendarios().remove(eventoCalendario);
		eventoCalendario.setTipoCalendario(null);

		return eventoCalendario;
	}

}