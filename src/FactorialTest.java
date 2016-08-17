import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FactorialTest {
	
	private Expression fBody, sixMinusOne, fFive, letVal, letFun, nestedLets;
	private Environment env0, env1, env2, env3;
	
	@Before
	public void setup(){
        fBody = getBody(); // messy details are in getBody()
        sixMinusOne =
            new Application(new Application(new Variable("-"),
                                            new Constant(6)),
                            new Constant(1));
        fFive = new Application(new Variable("f"),
                                           new Variable("five"));
        letVal = new LetVal("five", sixMinusOne, fFive);
        letFun = new LetFun("f", "n", fBody, fFive);
        nestedLets = new LetFun("f", "n", fBody,
        		new LetVal("five", sixMinusOne, fFive));
        env0 = InitialEnvironment.getEnvironment();
        env1 = new ActivationRecord("f", "n", fBody, env0);
        env2 = new ActivationRecord("five",
        		sixMinusOne.eval(env1),
        		env1);
        env3 = new ActivationRecord("five",
        		sixMinusOne.eval(env0),
        		env0);
	}
	
    /**
     * When this test is run, it does the equivalent of the
     * following ML program, which calculates 120:<pre>
     * fun f n = if n = 0 then 1 else f(n-1)*n;
     * val five = 6-1;
     * f five;
     * </pre> */
	@Test
	public void fFiveInEnv2() {
		assertEquals(Integer.valueOf(120), fFive.eval(env2).as(Integer.class));
	}
	
	/**
	 * Will fail until Extension 1 is completed.
	 */
	@Test
	public void fFiveToString() {
		assertEquals("(f five)", fFive.toString());
	}
		
	/**
	 * Will fail until Extension 1 is completed.
	 */
	@Test
	public void sixMinusOneToString() {
		assertEquals("((- 6) 1)", sixMinusOne.toString());
	}
		
	/**
	 * Will fail until Extension 1 is completed.
	 */
	@Test
	public void fBodyToString() {
		assertEquals("(if ((= n) 0) then 1 else ((* (f ((- n) 1))) n))",
				fBody.toString());
	}
	
	/**
	 * Will fail until Extension 2 is completed.
	 */
	@Test
	public void letValInEnv1(){
		assertEquals(Integer.valueOf(120), letVal.eval(env1).as(Integer.class));
	}
	
	
	/**
	 * Will fail until Extensions 1 and 2 are both completed.
	 */
	@Test
	public void letValToString(){
		assertEquals("let val five = ((- 6) 1) in (f five) end", letVal.toString());
	}
		
	/**
	 * Will fail until Extension 3 is completed.
	 */
	@Test
	public void letFunInEnv3(){
		assertEquals(Integer.valueOf(120), letFun.eval(env3).as(Integer.class));
	}
		
	/**
	 * Will fail until Extensions 1 and 3 are both completed.
	 */
	@Test
	public void letFunToString(){
		assertEquals(
				"let fun f n = (if ((= n) 0) then 1 else ((* (f ((- n) 1))) n)) in (f five) end",
				letFun.toString()
				);
	}
		
	/**
	 * Will fail until Extensions 2 and 3 are both completed.
	 */
	@Test
	public void nestedLetsInEnv0(){
		assertEquals(Integer.valueOf(120), nestedLets.eval(env0).as(Integer.class));
	}
	
	/**
	 * Will fail until Extensions 1, 2, and 3 are all completed.
	 */
	@Test
	public void nestedLetsToString(){
		assertEquals(
				"let fun f n = (if ((= n) 0) then 1 else ((* (f ((- n) 1))) n)) in let val five = ((- 6) 1) in (f five) end end",
				nestedLets.toString()
				);
	}

		
    private Expression getBody(){
        // This produces the body of the function f,
        //    if n = 0 then 1 else f(n-1)*n;
        // this expression is complex enough that it seems worth
        // building up one step at a time.
        Expression n = new Variable("n");
        Expression one = new Constant(1);
        Expression zero = new Constant(0);
        Expression times = new Variable("*");
        Expression minus = new Variable("-");
        Expression equals = new Variable("=");
        Expression f = new Variable("f");
        Expression nMinusOne =
            new Application(new Application(minus, n),
                            one);
        Expression fNMinusOne = new Application(f, nMinusOne);
        Expression product =
            new Application(new Application(times, fNMinusOne),
                            n);
        Expression nEqualsZero =
            new Application(new Application(equals, n),
                            zero);
        return new Conditional(nEqualsZero, one, product);
    }

}
