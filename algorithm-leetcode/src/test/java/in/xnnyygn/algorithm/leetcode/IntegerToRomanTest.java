package in.xnnyygn.algorithm.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerToRomanTest {

  private IntegerToRoman r = new IntegerToRoman();

  @Test
  public void test() {
    assertEquals("I", r.intToRoman(1));
    assertEquals("II", r.intToRoman(2));
    assertEquals("III", r.intToRoman(3));
    assertEquals("IV", r.intToRoman(4));
    assertEquals("V", r.intToRoman(5));
    assertEquals("VI", r.intToRoman(6));
    assertEquals("VII", r.intToRoman(7));
    assertEquals("VIII", r.intToRoman(8));
    assertEquals("IX", r.intToRoman(9));
    assertEquals("X", r.intToRoman(10));
    assertEquals("MMXV", r.intToRoman(2015));
    assertEquals("MCMLIV", r.intToRoman(1954));
    assertEquals("MCMXC", r.intToRoman(1990));
  }

}
