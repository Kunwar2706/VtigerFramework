package Practice_package;

import org.testng.annotations.Test;

public class tetng3 {
	@Test(priority= 2,invocationCount = 2)
	public void create() {

		System.out.println("created");
	}

	@Test
	public void update() {
		System.out.println("update");
	}

	@Test
	
	public void delete() {
		System.out.println("deleted");//this is alphabeticalorder and takes first default priority
		
	}
}
