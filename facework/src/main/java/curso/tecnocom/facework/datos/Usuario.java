package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String clave;

	private byte[] enabled;

	private String usuario;

	//bi-directional many-to-one association to Datospersonale
	@OneToMany(mappedBy="usuario")
	private List<Datospersonale> datospersonales;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="usuarios_has_roles"
		, joinColumns={
			@JoinColumn(name="usuarios_datospersonales_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="roles_id")
			}
		)
	private List<Role> roles;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public byte[] getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte[] enabled) {
		this.enabled = enabled;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Datospersonale> getDatospersonales() {
		return this.datospersonales;
	}

	public void setDatospersonales(List<Datospersonale> datospersonales) {
		this.datospersonales = datospersonales;
	}

	public Datospersonale addDatospersonale(Datospersonale datospersonale) {
		getDatospersonales().add(datospersonale);
		datospersonale.setUsuario(this);

		return datospersonale;
	}

	public Datospersonale removeDatospersonale(Datospersonale datospersonale) {
		getDatospersonales().remove(datospersonale);
		datospersonale.setUsuario(null);

		return datospersonale;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}