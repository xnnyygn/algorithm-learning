package in.xnnyygn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    int max = 0;
    int start = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (map.containsKey(c)) {
        max = Math.max(max, i - start);
        int previous = map.get(c) + 1;
        if (start < previous) {
          start = previous;
        }
      }
      map.put(c, i);
    }
    return Math.max(max, s.length() - start);
  }

}
