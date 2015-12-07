package lesson_4_Array_Based_List;

public class SimpleArrayList {

	private Object[] arr;

	int length = 0;

	public SimpleArrayList() {
		arr = new Object[length];
	}
	
	public boolean contains(Object obj){
		for(Object object : arr){
			if(object == obj){
				return true;
			}
		}
		return false;
	}

	public void remove(Object obj) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(obj)) {
				Object[] temp = new Object[arr.length - 1];
				if(i > 0){
					System.arraycopy(arr, 0, temp, 0, i - 1);
					System.arraycopy(arr, i + 1, temp, i, arr.length - 1 - i);
					arr = temp;
				}
				else if(i == 0){
					System.arraycopy(arr, i + 1, temp, i, arr.length - 1 - i);
					arr = temp;
				}
			}
		}
	}

	public Object getByIndex(int i) {
		
		Object result = null;
		
		if(i > arr.length - 1){
			throw new ArrayIndexOutOfBoundsException();
		}	
		
		for (int j = 0; j < arr.length; j++) {
			if (j == i) {
				result = arr[j];
			}
		}
		return result;
	}

	public int size() {
		return arr.length;
	}

	public void add(Object obj) {
		Object[] temp = new Object[arr.length + 1];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		arr = temp;
		for (int i = 0; i < arr.length; i++) {
			if (!(arr[i] instanceof Object)) {
				arr[i] = obj;
			}
		}
	}
}
