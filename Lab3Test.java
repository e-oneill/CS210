import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class Lab3Test {
//  @Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }
  @BeforeMethod
  public void beforeMethod() {
  }


  @DataProvider (name="notPrime")
  public Object[][] dp() {
    return new Object[][] {
      { 1, 6, 5, 7 },
      { 2, 9, 7, 11 },
      { 3, 4, 3, 5},
      { 4, 1000, 997, 1009}
    };
  }
  
  @DataProvider (name="Prime")
  public Object[][] prime() {
    return new Object[][] {
      { 1, 7, 11},
      { 2, 11, 13},
      { 3, 997, 1009},
      { 4, 2, 3}
    };
  }
  
  @DataProvider (name="CalcDiff")
  public Object[][] calcdiff() {
	    return new Object[][] {
	      { 1, 7, 4},
	      { 2, 10, 4},
	      { 3, 2, 1},
	      { 4, 1000, 12}
	    };
	  }
  
  @Test (dataProvider = "CalcDiff")
  public void testDifference(int id, int num, int expected) {
	  assertEquals(Lab3.calculateDifference(num),expected);
  }

  @Test (dataProvider = "notPrime")
  public void testNotPrime(int id, int bound, int expectedPrev, int expectedSubs) {
    boolean[] arr = new boolean[bound+21];
    arr = Lab3.getPrimes(arr);
    assertEquals(Lab3.findPreviousPrime(bound, arr), expectedPrev);
    assertEquals(Lab3.findSubsequentPrime(bound, arr), expectedSubs);
  }

  @Test (dataProvider = "Prime")
  public void testPrime(int id, int bound, int expectedSubs) {
	    boolean[] arr = new boolean[bound+21];
	    arr = Lab3.getPrimes(arr);
	    assertEquals(Lab3.findSubsequentPrime(bound, arr), expectedSubs);
  }
}
