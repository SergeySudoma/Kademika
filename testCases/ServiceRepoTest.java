package testCases;

import static org.junit.Assert.*;
import lesson_7_service_repo.Service;
import lesson_7_service_repo.ServiceRepository;

import org.junit.Before;
import org.junit.Test;

public class ServiceRepoTest {
	
	ServiceRepository sr;
	
	@Before
	public void init(){
		sr = new ServiceRepository();
	}

	@Test
	public void listLengthtest() {
		assertEquals(0, sr.getList().size());
	}
}
