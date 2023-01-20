package Practice_package;

import org.testng.annotations.Test;

public class SampleTestNGTest_2 {

		@Test(groups="regression")
		public void simple3()
		{
			System.out.println("---testscript3---");
		}
		@Test(groups= {"smoke","regression"})
		public void simple4()
		{
			System.out.println("----testSript 4");
	
		}
		
}
