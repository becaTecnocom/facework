package curso.tecnocom.facework.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the datospersonales database table.
 * 
 */
@Entity
@Table(name="datospersonales")
@NamedQuery(name="Datospersonale.findAll", query="SELECT d FROM Datospersonale d")
public class Datospersonale implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apellido1;

	private String apellido2;

	private String direccion;

	private String dni;

	private String email;

	private String fechanacimiento;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Amistade
	@OneToMany(mappedBy="datospersonale1")
	private List<Amistade> amistades1;

	//bi-directional many-to-one association to Amistade
	@OneToMany(mappedBy="datospersonale2")
	private List<Amistade> amistades2;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="datospersonale")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="datospersonale")
	private List<Curso> cursos;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne(fetch=FetchType.LAZY)
	private Proyecto proyecto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuarios_id")
	private Usuario usuario;

	//bi-directional many-to-many association to Equipo
	@ManyToMany(mappedBy="datospersonales1")
	private List<Equipo> equipos1;

	//bi-directional many-to-many association to Equipo
	@ManyToMany(mappedBy="datospersonales2")
	private List<Equipo> equipos2;

	//bi-directional many-to-many association to EventoCalendario
	@ManyToMany(mappedBy="datospersonales")
	private List<EventoCalendario> eventoCalendarios;

	//bi-directional many-to-many association to Grupo
	@ManyToMany(mappedBy="datospersonales")
	private List<Grupo> grupos;

	//bi-directional many-to-many association to Mensaje
	@ManyToMany(mappedBy="datospersonales")
	private List<Mensaje> mensajes1;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="datospersonale")
	private List<Mensaje> mensajes2;

	//bi-directional many-to-many association to Publicacione
	@ManyToMany(mappedBy="datospersonales")
	private List<Publicacione> publicaciones1;

	//bi-directional many-to-one association to Publicacione
	@OneToMany(mappedBy="datospersonale")
	private List<Publicacione> publicaciones2;

	public Datospersonale() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Amistade> getAmistades1() {
		return this.amistades1;
	}

	public void setAmistades1(List<Amistade> amistades1) {
		this.amistades1 = amistades1;
	}

	public Amistade addAmistades1(Amistade amistades1) {
		getAmistades1().add(amistades1);
		amistades1.setDatospersonale1(this);

		return amistades1;
	}

	public Amistade removeAmistades1(Amistade amistades1) {
		getAmistades1().remove(amistades1);
		amistades1.setDatospersonale1(null);

		return amistades1;
	}

	public List<Amistade> getAmistades2() {
		return this.amistades2;
	}

	public void setAmistades2(List<Amistade> amistades2) {
		this.amistades2 = amistades2;
	}

	public Amistade addAmistades2(Amistade amistades2) {
		getAmistades2().add(amistades2);
		amistades2.setDatospersonale2(this);

		return amistades2;
	}

	public Amistade removeAmistades2(Amistade amistades2) {
		getAmistades2().remove(amistades2);
		amistades2.setDatospersonale2(null);

		return amistades2;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setDatospersonale(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setDatospersonale(null);

		return comentario;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setDatospersonale(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setDatospersonale(null);

		return curso;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Equipo> getEquipos1() {
		return this.equipos1;
	}

	public void setEquipos1(List<Equipo> equipos1) {
		this.equipos1 = equipos1;
	}

	public List<Equipo> getEquipos2() {
		return this.equipos2;
	}

	public void setEquipos2(List<Equipo> equipos2) {
		this.equipos2 = equipos2;
	}

	public List<EventoCalendario> getEventoCalendarios() {
		return this.eventoCalendarios;
	}

	public void setEventoCalendarios(List<EventoCalendario> eventoCalendarios) {
		this.eventoCalendarios = eventoCalendarios;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Mensaje> getMensajes1() {
		return this.mensajes1;
	}

	public void setMensajes1(List<Mensaje> mensajes1) {
		this.mensajes1 = mensajes1;
	}

	public List<Mensaje> getMensajes2() {
		return this.mensajes2;
	}

	public void setMensajes2(List<Mensaje> mensajes2) {
		this.mensajes2 = mensajes2;
	}

	public Mensaje addMensajes2(Mensaje mensajes2) {
		getMensajes2().add(mensajes2);
		mensajes2.setDatospersonale(this);

		return mensajes2;
	}

	public Mensaje removeMensajes2(Mensaje mensajes2) {
		getMensajes2().remove(mensajes2);
		mensajes2.setDatospersonale(null);

		return mensajes2;
	}

	public List<Publicacione> getPublicaciones1() {
		return this.publicaciones1;
	}

	public void setPublicaciones1(List<Publicacione> publicaciones1) {
		this.publicaciones1 = publicaciones1;
	}

	public List<Publicacione> getPublicaciones2() {
		return this.publicaciones2;
	}

	public void setPublicaciones2(List<Publicacione> publicaciones2) {
		this.publicaciones2 = publicaciones2;
	}

	public Publicacione addPublicaciones2(Publicacione publicaciones2) {
		getPublicaciones2().add(publicaciones2);
		publicaciones2.setDatospersonale(this);

		return publicaciones2;
	}

	public Publicacione removePublicaciones2(Publicacione publicaciones2) {
		getPublicaciones2().remove(publicaciones2);
		publicaciones2.setDatospersonale(null);

		return publicaciones2;
	}

}