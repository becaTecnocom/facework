package curso.tecnocom.facework.daos;

import java.util.List;

import curso.tecnocom.facework.datos.Datospersonale;
import curso.tecnocom.facework.datos.Mensaje;

public interface MensajeDaoInterface
{
	public void grabarMensaje(String texto, List<Datospersonale> datospersonale) throws Exception ;
	public List<Mensaje> findMensajesByDatosPersonaleOrderByDate (Datospersonale datospersonale) throws Exception;//Buscar mensajes intercambiados con una persona
	public void grabarLeido(Mensaje mensaje) throws Exception;
}
