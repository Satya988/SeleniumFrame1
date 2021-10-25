package listeners;

import static org.junit.Assert.assertTrue;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import net.bytebuddy.implementation.bytecode.Throw;

@Listeners(listeners.TestNGlisteners.class)
public class ListenersDemo {

	@Test
	public static void test1() {
		// TODO Auto-generated method stub
		System.out.println("inside test1");
	}
	
	@Test
	public static void test2() {
		// TODO Auto-generated method stub
		System.out.println("inside test2");
		throw new SkipException("Skipped");
		
	}
	
	@Test
	public static void test3() {
		// TODO Auto-generated method stub
		System.out.println("inside test3");
		assertTrue(false);
	}

}
