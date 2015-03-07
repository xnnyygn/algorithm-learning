package in.xnnyygn.algorithm.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseIntegerTest {

  private ReverseInteger r = new ReverseInteger();

  @Test
  public void testPositive() {
    assertEquals(321, r.reverse(123));
  }

  @Test
  public void testNegative() {
    assertEquals(-321, r.reverse(-123));
  }

  @Test
  public void testLastDigitIsZero() {
    assertEquals(1, r.reverse(100));
  }

  @Test
  public void testOverflow() {
    assertEquals(0, r.reverse(1000000003));
  }

  @Test
  public void testMinValue() {
    assertEquals(0, r.reverse(Integer.MIN_VALUE));
  }

  @Test
  public void testMaxValue() {
    assertEquals(0, r.reverse(Integer.MAX_VALUE));
  }

  @Test
  public void test1() {
    assertEquals(0, r.reverse(1534236469));
  }

}
