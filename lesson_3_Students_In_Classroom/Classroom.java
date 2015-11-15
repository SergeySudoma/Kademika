package lesson_3_Students_In_Classroom;

import java.util.ArrayList;

public class Classroom {
	
	ArrayList<Student> list;
	Student student;
	
	public Classroom(){
		
		list = new ArrayList<Student>();
		
	}
	
	public void enter(String name, String secondName){
		list.add(new Student(name, secondName));
	}
	
	public void leave(String name, String secondName){
		for(Student student : list){
			if(student.getName().equals(name) && student.getName().equals(secondName)){
				list.remove(student);
			}
		}
	}
	
	public void getCount(){
		System.out.println("Total quantity of studs: " + list.size());
	}
	
	public boolean isPresent(String name, String secondName){
		
		for(Student student : list){
			if(student.getName().equals(name) && student.getName().equals(secondName)){
				return true;
			}
		}		
		return false;
	}
	
	public void printStudentsInfo(){
		for(Student student : list){
			System.out.println(student.getName() + " " + student.getSecondName());
		}
	}
	
	public void createDemoList(){
		list.add(new Student("Вася", "Пупкин"));
		list.add(new Student("Петя", "Шварцнеггер"));
		list.add(new Student("Оля", "Жабкина"));
		list.add(new Student("Ксю", "Блондинка"));
		list.add(new Student("Саша", "Кизяк"));
		list.add(new Student("Валера", "Обама"));
		list.add(new Student("Маша", "Бубкина"));
		list.add(new Student("Олег", "Чубака"));
		list.add(new Student("Юра", "Лобз"));
		list.add(new Student("Даша", "Радостьнаша"));
	}
}
