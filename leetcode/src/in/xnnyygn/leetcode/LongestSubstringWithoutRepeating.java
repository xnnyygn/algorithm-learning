package in.xnnyygn.leetcode;

import java.util.Set;
import java.util.HashSet;

public class LongestSubstringWithoutRepeating {

  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<Character>();
    int max = 0;
    for (char c : s.toCharArray()) {
      if (set.contains(c)) {
        if (set.size() > max) {
          max = set.size();
        }
        set.clear();
      }
      set.add(c);
    }
    return Math.max(max, set.size());
  }

}
