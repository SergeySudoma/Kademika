package lesson_7_Set_Privates;

import java.lang.reflect.*;
import java.util.Map;
import java.util.Map.Entry;

public class PrivateSetter{

	public void setPrivates(Object obj, Map<String, Object> map) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		for(Entry<String, Object> entry : map.entrySet()){
			Field field = obj.getClass().getDeclaredField(entry.getKey());
			field.setAccessible(true);
			field.set(obj, entry.getValue());
			}
		}
}



