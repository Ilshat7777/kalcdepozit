package kalc;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class kalcTest3 {

	@Test
	public void ValidTest() {
		int a = (int)Math.round(kalc.calcSumProc(20, 20, (double)20.0/100));
		int b =(int) Math.round(27);
		
		Assert.assertEquals(a,b);
	}

}
