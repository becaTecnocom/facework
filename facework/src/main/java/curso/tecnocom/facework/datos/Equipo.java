package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipos database table.
 * 
 */
@Entity
@Table(name="equipos")
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-many association to Datospersonale
	@ManyToMany
	@JoinTable(
		name="datospersonales_has_equipos"
		, joinColumns={
			@JoinColumn(name="equipos_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="datospersonales_usuarios_id")
			}
		)
	private List<Datospersonale> datospersonales1;

	//bi-directional many-to-many association to Datospersonale
	@ManyToMany
	@JoinTable(
		name="equipos_has_datospersonales"
		, joinColumns={
			@JoinColumn(name="equipos_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="datospersonales_id")
			}
		)
	private List<Datospersonale> datospersonales2;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="proyectos_id")
	private Proyecto proyecto;

	//bi-directional many-to-one association to Publicacione
	@OneToMany(mappedBy="equipo")
	private List<Publicacione> publicaciones;

	public Equipo() {
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

	public List<Datospersonale> getDatospersonales1() {
		return this.datospersonales1;
	}

	public void setDatospersonales1(List<Datospersonale> datospersonales1) {
		this.datospersonales1 = datospersonales1;
	}

	public List<Datospersonale> getDatospersonales2() {
		return this.datospersonales2;
	}

	public void setDatospersonales2(List<Datospersonale> datospersonales2) {
		this.datospersonales2 = datospersonales2;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<Publicacione> getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(List<Publicacione> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Publicacione addPublicacione(Publicacione publicacione) {
		getPublicaciones().add(publicacione);
		publicacione.setEquipo(this);

		return publicacione;
	}

	public Publicacione removePublicacione(Publicacione publicacione) {
		getPublicaciones().remove(publicacione);
		publicacione.setEquipo(null);

		return publicacione;
	}

}