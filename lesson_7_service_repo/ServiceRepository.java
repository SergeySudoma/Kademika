package lesson_7_service_repo;

import java.util.ArrayList;

public class ServiceRepository {
	
	ArrayList<Service> list;
	
	public ServiceRepository(){
		list = new ArrayList<Service>();
	}
	
	public void add(Service obj){
		list.add(obj);
	}
	
	public void remove(Service obj){
		list.remove(obj);
	}
	
	public Service get(int i){
		return list.get(i);
	}

}
