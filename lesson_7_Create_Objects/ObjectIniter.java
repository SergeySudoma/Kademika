package lesson_7_Create_Objects;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

public class ObjectIniter<T>{

	public T initClass(Class<T> c, Map<String, Object> args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		T obj = c.newInstance();
		Method[] methods = c.getMethods();
		
		for(Entry<String, Object> e : args.entrySet()){
			for(Method method : methods){
				String methodName = method.getName();
				if(methodName.contains("set" + e.getKey())){
					method.invoke(obj, e.getValue());
				}
			}
		}
		return obj;
	}
}



