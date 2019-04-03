package kalc;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class kalcTest4 {

	@Test
	public void ValidTest() {
		int a = (int)Math.round(kalc.calcSumProc(30, 30, (double)30.0/100));
		int b =(int) Math.round(53);
		
		Assert.assertEquals(a,b);
	
	}
}
