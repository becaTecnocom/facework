package curso.tecnocom.facework.configuracion;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		// TODO Auto-generated method stub
		return new Class<?>[]{Configuracion.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings()
	{
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
