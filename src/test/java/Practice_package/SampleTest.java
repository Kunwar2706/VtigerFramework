package Practice_package;

import org.testng.annotations.Test;

public class SampleTest {
	
@Test(priority=-1,invocationCount = 3)
public void create() {
	int a[]= {1,2,3};
	
	System.out.println(a[5]);
}

@Test(dependsOnMethods = "create")
public void update() {
	System.out.println("update");
}

@Test
public void delete() {
	System.out.println("deleted");
}
}
