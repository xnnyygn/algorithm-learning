package in.xnnyygn.algorithm.leetcode;

import java.util.LinkedList;

public class ValidParentheses {

  public boolean isValid(String s) {
    LinkedList<Character> stack = new LinkedList<Character>();
    for (char c : s.toCharArray()) {
      switch (c) {
        case '(':
        case '[':
        case '{':
          stack.addFirst(c);
          break;
        case ')':
          if (stack.isEmpty() || stack.removeFirst() != '(')
            return false;
          break;
        case ']':
          if (stack.isEmpty() || stack.removeFirst() != '[')
            return false;
          break;
        case '}':
          if (stack.isEmpty() || stack.removeFirst() != '{')
            return false;
          break;
      }
    }
    return stack.isEmpty();
  }
}
