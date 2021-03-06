package ask.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ask.base.Base;

public class Listener extends Base implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case "+result.getName().toString()+"passed");
		
	}

	public void onTestFailure(ITestResult result) {
		try {
			Util.getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("!!!!!!!!!!!!!!!!!!Test case: "+result.getName().toString()+" failed");
				System.out.println("                                                         ");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
