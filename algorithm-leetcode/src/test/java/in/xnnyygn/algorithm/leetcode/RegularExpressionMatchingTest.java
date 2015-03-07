package in.xnnyygn.algorithm.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegularExpressionMatchingTest {

  private RegularExpressionMatching r = new RegularExpressionMatching();

  @Test
  public void test() {
    assertFalse(r.isMatch("aa","a"));
    assertTrue(r.isMatch("","*"));
    assertTrue(r.isMatch("aa","aa"));
    assertFalse(r.isMatch("aaa","aa"));
    assertTrue(r.isMatch("aa", "a*"));
    assertTrue(r.isMatch("aa", ".*"));
    assertTrue(r.isMatch("ab", ".*"));
    assertTrue(r.isMatch("cab", "c*a*b"));
  }
}
