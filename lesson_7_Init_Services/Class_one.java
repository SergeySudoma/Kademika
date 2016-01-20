package lesson_7_Init_Services;


@Service
public class Class_one {
	
	@InitService
	public void initService(){
		System.out.println("initService");
	}

}
