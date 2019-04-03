package kalc;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class kalcTest {

	@Test
	public void ValidTest() {
		int a = (int)Math.round(kalc.calcSumProc(10, 10, (double)10.0/100));
		int b =(int) Math.round(11);
		
		Assert.assertEquals(a,b);
	}
	

}
