package in.xnnyygn.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanToIntegerTest {

  private RomanToInteger r = new RomanToInteger();

  @Test
  public void test() {
    assertEquals(1, r.romanToInt("I"));
    assertEquals(2, r.romanToInt("II"));
    assertEquals(3, r.romanToInt("III"));
    assertEquals(4, r.romanToInt("IV"));
    assertEquals(5, r.romanToInt("V"));
    assertEquals(6, r.romanToInt("VI"));
    assertEquals(7, r.romanToInt("VII"));
    assertEquals(8, r.romanToInt("VIII"));
    assertEquals(9, r.romanToInt("IX"));
    assertEquals(10, r.romanToInt("X"));

    assertEquals(2015, r.romanToInt("MMXV"));
    assertEquals(1954, r.romanToInt("MCMLIV"));
    assertEquals(1990, r.romanToInt("MCMXC"));
  }

}
