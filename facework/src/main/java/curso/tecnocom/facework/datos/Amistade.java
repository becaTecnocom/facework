package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the amistades database table.
 * 
 */
@Entity
@Table(name="amistades")
@NamedQuery(name="Amistade.findAll", query="SELECT a FROM Amistade a")
public class Amistade implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte aceptado;

	//bi-directional many-to-one association to Datospersonale
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="datospersonales_id")
	private Datospersonale datospersonale1;

	//bi-directional many-to-one association to Datospersonale
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="datospersonales_id1")
	private Datospersonale datospersonale2;

	public Amistade() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAceptado() {
		return this.aceptado;
	}

	public void setAceptado(byte aceptado) {
		this.aceptado = aceptado;
	}

	public Datospersonale getDatospersonale1() {
		return this.datospersonale1;
	}

	public void setDatospersonale1(Datospersonale datospersonale1) {
		this.datospersonale1 = datospersonale1;
	}

	public Datospersonale getDatospersonale2() {
		return this.datospersonale2;
	}

	public void setDatospersonale2(Datospersonale datospersonale2) {
		this.datospersonale2 = datospersonale2;
	}

}