package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proyectos database table.
 * 
 */
@Entity
@Table(name="proyectos")
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nombreProyectos;

	//bi-directional many-to-one association to Datospersonale
	@OneToMany(mappedBy="proyecto")
	private List<Datospersonale> datospersonales;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="proyecto")
	private List<Equipo> equipos;

	public Proyecto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProyectos() {
		return this.nombreProyectos;
	}

	public void setNombreProyectos(String nombreProyectos) {
		this.nombreProyectos = nombreProyectos;
	}

	public List<Datospersonale> getDatospersonales() {
		return this.datospersonales;
	}

	public void setDatospersonales(List<Datospersonale> datospersonales) {
		this.datospersonales = datospersonales;
	}

	public Datospersonale addDatospersonale(Datospersonale datospersonale) {
		getDatospersonales().add(datospersonale);
		datospersonale.setProyecto(this);

		return datospersonale;
	}

	public Datospersonale removeDatospersonale(Datospersonale datospersonale) {
		getDatospersonales().remove(datospersonale);
		datospersonale.setProyecto(null);

		return datospersonale;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setProyecto(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setProyecto(null);

		return equipo;
	}

}