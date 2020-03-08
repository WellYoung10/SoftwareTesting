/**
 * 
 */
package cn.tjuscs.st;

/**
 * @author m^_^m
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestMoney {
	private int input;
	private boolean expected;
	private Money mon = null;
	
	public TestMoney(int input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	@Before
	public void setUp(){
		mon = new Money();
	}
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][] {
			{0,true},
			{1,true},
			{4,false},
			{48,false},
			{100,false}
		});
	}
	
	@Test
	public void testIsEnough(){
		assertEquals(this.expected, mon.TakeOut(input));
	}

}

