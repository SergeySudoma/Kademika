package lesson_7_Create_Objects_With_Constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ObjectIniter<T>{

	public T initClass(Class<T> c, List<Object> args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int argsQuantity = args.size();
		Object[] arrayOfArgs = args.toArray();
		Constructor[] allConstructors = c.getConstructors();
		Constructor necassaryConstructor = null;
		
		for(Constructor constructor : allConstructors){
			Class[] constructorArgs = constructor.getParameterTypes();
			int constructorArgsQuantity = constructorArgs.length;
			if (constructorArgsQuantity == argsQuantity){
				necassaryConstructor = constructor;
			}
		}
		T obj = (T) necassaryConstructor.newInstance(arrayOfArgs);
		return obj;
	}
}



