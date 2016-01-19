package lesson_7_Create_Annotation;

import java.lang.annotation.*;

public class Annotation {
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface Service{
		boolean check() default false;
	}
}
