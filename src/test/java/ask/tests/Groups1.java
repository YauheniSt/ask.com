package ask.tests;

import org.testng.annotations.Test;

public class Groups1 {
@Test(groups= {"Groups"})
public void test1() {
	System.out.println("1");
}
@Test
public void test2() {
	System.out.println("2");
}

@Test
public void test3() {
	System.out.println("3");
}






}
