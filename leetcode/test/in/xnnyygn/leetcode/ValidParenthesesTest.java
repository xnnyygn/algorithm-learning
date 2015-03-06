package in.xnnyygn.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidParenthesesTest {

  private ValidParentheses v = new ValidParentheses();

  @Test
  public void test() {
    assertTrue(v.isValid("()"));
    assertTrue(v.isValid("()[]{}"));
    assertFalse(v.isValid("(]"));
    assertFalse(v.isValid("([)]"));
    assertFalse(v.isValid("]"));
  }

}
