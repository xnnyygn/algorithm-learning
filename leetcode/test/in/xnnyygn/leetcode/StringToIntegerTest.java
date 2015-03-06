package in.xnnyygn.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringToIntegerTest {

  private StringToInteger s = new StringToInteger();

  @Test
  public void test() {
    assertEquals(1, s.atoi("1")); // simple
    assertEquals(1, s.atoi("+1")); // positive
    assertEquals(-12, s.atoi("-12")); // negative
    assertEquals(-12, s.atoi("-12.4")); // float
    assertEquals(0, s.atoi(null)); // null
    assertEquals(0, s.atoi("")); // empty string
    assertEquals(0, s.atoi("abc")); // no number
    assertEquals(Integer.MAX_VALUE, s.atoi("2147483648")); // overflow
    assertEquals(-2147483648, s.atoi("-2147483648")); // overflow
    assertEquals(Integer.MIN_VALUE, s.atoi("-2147483649")); // underflow
    assertEquals(12, s.atoi(" 12 ")); // space
  }
}
