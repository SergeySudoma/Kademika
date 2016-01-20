package lesson_7_windows_with_services;


@Service
public class Class_one {
	
	@InitService
	public void initService(){
		System.out.println("initService");
	}

}
