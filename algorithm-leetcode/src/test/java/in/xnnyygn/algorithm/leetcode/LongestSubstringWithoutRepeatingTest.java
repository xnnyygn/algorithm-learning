package in.xnnyygn.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingTest {

  private LongestSubstringWithoutRepeating r = new LongestSubstringWithoutRepeating();
  
  @Test
  public void test1() {
    assertEquals(3, r.lengthOfLongestSubstring("abcabcbb"));
  }
  
  @Test
  public void test2() {
    assertEquals(1, r.lengthOfLongestSubstring("bbbbb"));
  }
  
  @Test
  public void test3() {
    assertEquals(1, r.lengthOfLongestSubstring("c"));
  }
  
  @Test
  public void test4() {
    assertEquals(2, r.lengthOfLongestSubstring("aab"));
  }
  
  @Test
  public void test5() {
    assertEquals(3, r.lengthOfLongestSubstring("dvdf"));
  }

  @Test
  public void test6() {
    assertEquals(2, r.lengthOfLongestSubstring("abba"));
  }
}
