package Practice_package;

import org.testng.annotations.Test;

public class SampleTestNGTest_4 {
	@Test(groups= "regression")
	public void simple7()
	{
		System.out.println("---testscript7---");
	}
	@Test(groups="smoke")
	public void simple8()
	{
		System.out.println("----testSript 8");

	}
}
