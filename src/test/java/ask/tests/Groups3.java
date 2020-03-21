package ask.tests;

import org.testng.annotations.Test;

public class Groups3 {
	@Test(groups= {"Groups"})
	public void test1() {
		System.out.println("w1");
	}
	@Test
	public void test2() {
		System.out.println("w2");
	}

	@Test
	public void test3() {
		System.out.println("w3");
	}
}
