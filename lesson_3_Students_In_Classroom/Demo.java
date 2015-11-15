package lesson_3_Students_In_Classroom;

public class Demo {

	public static void main(String[] args) {
		
		Classroom room = new Classroom();
		
		room.createDemoList();
		room.getCount();
		room.enter("Ира", "Аллегрова");
		room.printStudentsInfo();
		room.leave("Вася", "Пупкин");
		System.out.println(room.isPresent("Олег", "Газманов"));
		

	}

}
