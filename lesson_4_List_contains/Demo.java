package lesson_4_List_contains;

public class Demo {

	public static void main(String[] args) {
		
		Classroom room = new Classroom();
		
		room.createDemoList();
		room.getCount();
		room.enter("Ира", "Аллегрова");
		room.printStudentsInfo();
		room.leave("Вася", "Пупкин");
		
		//checking overrided equals
		System.out.println(room.list.get(0).equals(room.list.get(0)));
		System.out.println(room.list.get(0).equals(room.list.get(1)));
		System.out.println(room.list.get(0).equals(room.list.get(2)));

	}

}
