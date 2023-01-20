package Practice_package;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_Test {
@Test
public void sample_01()
{
	System.out.println("---testscript1---");
	System.out.println("---testscript2---");
	assertEquals("A", "B", "---script is failed----");
	System.out.println("---testscript3---");
	System.out.println("---testscript4---");
}


@Test
public void sample_02()
{
	System.out.println("---testscript1---");
	System.out.println("---testscript2---");
assertNotEquals("A", "B", "script is pass");
	System.out.println("---testscript3---");
	System.out.println("---testscript4---");
}

@Test
public void sample_03()
{
	String a="testyantra";
	String b="qspiders";
	assertFalse(a.equals(b));
	System.out.println("---pass--");
}



@Test
public void sample_04()
{
String a=null;
assertNotNull(a);
	System.out.println("--failed--");
}


@Test
public void sample_05()
{


	SoftAssert sa=new SoftAssert();
	sa.assertNotEquals("X","Y");
	System.out.println("--passesd--");
}

@Test
public void sample_06()
{


	SoftAssert sa=new SoftAssert();
	 
	sa.assertNotEquals("X","Y");
	System.out.println("--passesd--");
	sa.assertAll();
}

}
