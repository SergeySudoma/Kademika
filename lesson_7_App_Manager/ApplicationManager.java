package lesson_7_App_Manager;

import java.lang.annotation.Annotation;

public class ApplicationManager {
	

	public void serviceCheck(Class clss){
		Annotation[] allAnnotations = clss.getAnnotations();
		boolean result = false;
		for(Annotation annotation : allAnnotations){
			if(annotation.annotationType().getName().equals(Service.class.getName())){
				System.out.println(clss.getName() + " has @Service annotation");
			}
		}
	}	
}
