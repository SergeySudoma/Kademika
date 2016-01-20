package lesson_7_windows_with_services;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ApplicationManager {

	public <T> void serviceCheck(Class<T> clss) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Annotation[] allAnnotations = clss.getAnnotations();
		for (Annotation annotation : allAnnotations) {
			if (annotation.annotationType().getName().equals(Service.class.getName())) {
				System.out.println(clss.getName() + " has @Service annotation");
				initService(clss);
			}
		}
	}


	private <T> void initService(Class<T> clss) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		T object = clss.newInstance();
		for (Method method : clss.getMethods()) {
			if (method.getAnnotation(InitService.class) != null) {
				method.invoke(object);
			}
		}		
	}
	
	public <T> T getService(Class<T> clss) throws InstantiationException, IllegalAccessException{
		return clss.newInstance();
		
	}
}
