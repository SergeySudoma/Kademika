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
		list.add(new Student("����", "������"));
		list.add(new Student("����", "�����������"));
		list.add(new Student("���", "�������"));
		list.add(new Student("���", "���������"));
		list.add(new Student("����", "�����"));
		list.add(new Student("������", "�����"));
		list.add(new Student("����", "�������"));
		list.add(new Student("����", "������"));
		list.add(new Student("���", "����"));
		list.add(new Student("����", "�����������"));
	}
}
