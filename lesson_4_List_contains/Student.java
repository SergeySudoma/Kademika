package lesson_4_List_contains;

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
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(this.getClass() != obj.getClass()){
			return false;
		}
		Student student = (Student)obj;
		if(this.getName().equals(student.getName()) && this.getSecondName().equals(student.getSecondName())){
			return true;
		}
		return false;		
	}
}
