package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comentarios database table.
 * 
 */
@Entity
@Table(name="comentarios")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String comentario;

	//bi-directional many-to-one association to Datospersonale
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="datospersonales_usuarios_id")
	private Datospersonale datospersonale;

	//bi-directional many-to-one association to Publicacione
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="publicacion_id")
	private Publicacione publicacione;

	public Comentario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Datospersonale getDatospersonale() {
		return this.datospersonale;
	}

	public void setDatospersonale(Datospersonale datospersonale) {
		this.datospersonale = datospersonale;
	}

	public Publicacione getPublicacione() {
		return this.publicacione;
	}

	public void setPublicacione(Publicacione publicacione) {
		this.publicacione = publicacione;
	}

}