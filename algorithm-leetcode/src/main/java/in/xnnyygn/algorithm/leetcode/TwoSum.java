package in.xnnyygn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
      int n = numbers[i];
      int m = target - n;
      if (map.containsKey(m)) {
        return new int[] {map.get(m) + 1, i + 1};
      } else {
        map.put(n, i);
      }
    }
    return new int[0];
  }
}
