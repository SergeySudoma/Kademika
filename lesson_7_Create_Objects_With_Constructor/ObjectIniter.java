package lesson_7_Create_Objects_With_Constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import java.util.List;

public class ObjectIniter<T>{

	public T initClass(Class<T> c, List<Object> params) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		T obj;
		
        Class[] classes = new Class[params.size()];

        for(int i=0; i < classes.length; i++) {
            classes[i] = params.get(i).getClass();
        }
       Constructor con = c.getConstructor(classes);
       obj = (T) con.newInstance(params.toArray());

       return obj;
		
		
		//		int argsQuantity = args.size();
//		Object[] arrayOfArgs = args.toArray();
//		Constructor[] allConstructors = c.getConstructors();
//		Constructor necassaryConstructor = null;
//		
//		
//		for(Constructor constructor : allConstructors){
//			Class[] constructorArgs = constructor.getParameterTypes();
//			int constructorArgsQuantity = constructorArgs.length;
//			if (constructorArgsQuantity == argsQuantity){
//				necassaryConstructor = constructor;
//			}
//		}
//		T obj = (T) necassaryConstructor.newInstance(arrayOfArgs);
//		return obj;
	}
}



