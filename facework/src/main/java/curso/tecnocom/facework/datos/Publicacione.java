package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the publicaciones database table.
 * 
 */
@Entity
@Table(name="publicaciones")
@NamedQuery(name="Publicacione.findAll", query="SELECT p FROM Publicacione p")
public class Publicacione implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String contenido;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String titulo;

	private String url;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="publicacione")
	private List<Comentario> comentarios;

	//bi-directional many-to-many association to Datospersonale
	@ManyToMany
	@JoinTable(
		name="likes"
		, joinColumns={
			@JoinColumn(name="publicaciones_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="datospersonales_usuarios_id")
			}
		)
	private List<Datospersonale> datospersonales;

	//bi-directional many-to-one association to Datospersonale
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="datospersonales_usuarios_id")
	private Datospersonale datospersonale;

	//bi-directional many-to-one association to Equipo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="equipos_id")
	private Equipo equipo;

	//bi-directional many-to-one association to Grupo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="grupos_id")
	private Grupo grupo;

	public Publicacione() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setPublicacione(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setPublicacione(null);

		return comentario;
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

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}