package in.xnnyygn.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    Arrays.sort(strs, new Comparator<String>() {

      public int compare(String string0, String string1) {
        return string0.length() - string1.length();
      }


    });
    for (int i = 0; i < strs[0].length(); i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (strs[j].charAt(i) != c) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }
}
