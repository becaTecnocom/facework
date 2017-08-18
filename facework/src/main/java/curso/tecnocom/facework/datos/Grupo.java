package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupos database table.
 * 
 */
@Entity
@Table(name="grupos")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-many association to Datospersonale
	@ManyToMany
	@JoinTable(
		name="datospersonales_has_grupos"
		, joinColumns={
			@JoinColumn(name="grupos_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="datospersonales_usuarios_id")
			}
		)
	private List<Datospersonale> datospersonales;

	//bi-directional many-to-one association to Publicacione
	@OneToMany(mappedBy="grupo")
	private List<Publicacione> publicaciones;

	public Grupo() {
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

	public List<Datospersonale> getDatospersonales() {
		return this.datospersonales;
	}

	public void setDatospersonales(List<Datospersonale> datospersonales) {
		this.datospersonales = datospersonales;
	}

	public List<Publicacione> getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(List<Publicacione> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Publicacione addPublicacione(Publicacione publicacione) {
		getPublicaciones().add(publicacione);
		publicacione.setGrupo(this);

		return publicacione;
	}

	public Publicacione removePublicacione(Publicacione publicacione) {
		getPublicaciones().remove(publicacione);
		publicacione.setGrupo(null);

		return publicacione;
	}

}