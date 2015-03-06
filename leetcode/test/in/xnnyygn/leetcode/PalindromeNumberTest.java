package in.xnnyygn.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeNumberTest {

  private PalindromeNumber p = new PalindromeNumber();

  @Test
  public void test() {
    assertTrue(p.isPalindrome(0));
    assertTrue(p.isPalindrome(121));
    assertFalse(p.isPalindrome(1231));
    assertFalse(p.isPalindrome(-2147447412));
  }

}
