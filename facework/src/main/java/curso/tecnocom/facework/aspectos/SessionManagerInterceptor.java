package curso.tecnocom.facework.aspectos;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import curso.tecnocom.facework.daos.GenericDao;



@Component
@Aspect
public class SessionManagerInterceptor 
{
	@Pointcut("execution(@curso.java.tecnocom.anotaciones.SessionManager * *.*(..)  )")
	public void sujetador()
	{
		
		
	}

	@Around("sujetador()")
	public Object ponerSesion(ProceedingJoinPoint joinPoint)
	{
		
		
		try {
			
			GenericDao empresaDAO= (GenericDao) joinPoint.getTarget();
			
			//asi se enchufa la sesion sin preocuparme
			try {
				if(empresaDAO.getSession()==null || !empresaDAO.getSession().isOpen())
					empresaDAO.setSession(empresaDAO.getSessionFactory().openSession());
				else //quitar este else
					empresaDAO.setSession(empresaDAO.getSessionFactory().getCurrentSession());
			} catch (Exception e) {	empresaDAO.setSession(empresaDAO.getSessionFactory().openSession());}
			
			
			
			Object objeto= joinPoint.proceed();
			return objeto;
		} catch (Throwable e) {
				e.printStackTrace();
				return null;
		}
	}
}
