package Practice_package;

import org.testng.annotations.Test;

public class SampleTestNGTest_1 {
	@Test(groups="smoke")
	public void simple1()
	{
		System.out.println("---testscript1---");
	}
	@Test(groups= {"smoke","regression"})
	public void simple2()
	{
		System.out.println("----testSript 2");
	}

}
