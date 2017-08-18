package curso.tecnocom.facework.daos;

import java.util.List;

import curso.tecnocom.facework.datos.Amistade;
import curso.tecnocom.facework.datos.Datospersonale;

public interface AmistadesDaoInterface
{
	public void grabarSolicitud (Datospersonale datospersonaleReceptor) throws Exception;
	public List<Datospersonale> findSolicitudes () throws Exception;
	public void grabarAceptacion (Amistade amistade) throws Exception;
	public List<Datospersonale> findAmigosByDatopersonale (Datospersonale datospersonale) throws Exception;
	
}