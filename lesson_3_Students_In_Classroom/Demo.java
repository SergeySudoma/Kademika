package lesson_3_Students_In_Classroom;

public class Demo {

	public static void main(String[] args) {
		
		Classroom room = new Classroom();
		
		room.createDemoList();
		room.getCount();
		room.enter("���", "���������");
		room.printStudentsInfo();
		room.leave("����", "������");
		System.out.println(room.isPresent("����", "��������"));
		

	}

}
