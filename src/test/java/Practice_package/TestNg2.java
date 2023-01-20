package Practice_package;

import org.testng.annotations.Test;

public class TestNg2 {
	public class SampleTest {//it will take alphabetical order
		
		
		@Test()
		public void create() {
		
			
			System.out.println("created");
		}

		@Test(dependsOnMethods = "create")
		public void update() {
			System.out.println("update");
		}

		@Test(dependsOnMethods = "create")
		public void delete() {
			System.out.println("deleted");
		}
}
}
