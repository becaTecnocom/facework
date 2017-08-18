package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mensajes database table.
 * 
 */
@Entity
@Table(name="mensajes")
@NamedQuery(name="Mensaje.findAll", query="SELECT m FROM Mensaje m")
public class Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private byte leido;

	private String mensaje;

	//bi-directional many-to-many association to Datospersonale
	@ManyToMany
	@JoinTable(
		name="datospersonales_has_mensajes"
		, joinColumns={
			@JoinColumn(name="mensajes_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="datospersonales_id")
			}
		)
	private List<Datospersonale> datospersonales;

	//bi-directional many-to-one association to Datospersonale
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="datospersonales_id")
	private Datospersonale datospersonale;

	public Mensaje() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public byte getLeido() {
		return this.leido;
	}

	public void setLeido(byte leido) {
		this.leido = leido;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Datospersonale> getDatospersonales() {
		return this.datospersonales;
	}

	public void setDatospersonales(List<Datospersonale> datospersonales) {
		this.datospersonales = datospersonales;
	}

	public Datospersonale getDatospersonale() {
		return this.datospersonale;
	}

	public void setDatospersonale(Datospersonale datospersonale) {
		this.datospersonale = datospersonale;
	}

}