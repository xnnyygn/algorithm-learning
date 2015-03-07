package in.xnnyygn.algorithm.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonPrefixTest {

  private LongestCommonPrefix p = new LongestCommonPrefix();

  @Test
  public void test() {
    assertEquals("", p.longestCommonPrefix(new String[0]));
    assertEquals("", p.longestCommonPrefix(new String[] {"a", "bc"}));
    assertEquals("ab", p.longestCommonPrefix(new String[] {"abde", "abc"}));
  }
}
