package lesson_3_Students_In_Classroom;

public class Student {
	
	private String name;
	private String secondName;
	
	public Student(){
		
	}
	
	public Student(String name, String secondName){
		this.setName(name);
		this.setSecondName(secondName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	
	

}
