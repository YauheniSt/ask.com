package ask.tests;

import org.testng.annotations.Test;

public class Groups2 {
	@Test(groups= {"Groups"})
	public void test1() {
		System.out.println("g1");
	}
	@Test
	public void test2() {
		System.out.println("g2");
	}

	@Test
	public void test3() {
		System.out.println("g3");
	}

}
