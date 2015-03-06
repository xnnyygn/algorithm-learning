package in.xnnyygn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] num) {
    if (num.length == 0)
      return Collections.emptyList();

    Map<Integer, Integer> negative = new HashMap<Integer, Integer>();
    int zeroCount = 0;
    Map<Integer, Integer> positive = new HashMap<Integer, Integer>();
    for (int i = 0; i < num.length; i++) {
      int n = num[i];
      if (n < 0) {
        if (negative.containsKey(n)) {
          negative.put(n, negative.get(n) + 1);
        } else {
          negative.put(n, 1);
        }
      } else if (n == 0) {
        zeroCount++;
      } else {
        if (positive.containsKey(n)) {
          positive.put(n, positive.get(n) + 1);
        } else {
          positive.put(n, 1);
        }
      }
    }

    List<List<Integer>> triplets = new ArrayList<List<Integer>>();
    if (zeroCount >= 3) {
      triplets.add(Arrays.asList(0, 0, 0));
    }
    if (!negative.isEmpty() && !positive.isEmpty()) {
      for (int a : negative.keySet()) {
        for (int c : positive.keySet()) {
          int b = -a - c;
          if (b < 0 && negative.containsKey(b)) {
            if (b == a && negative.get(a) > 1) {
              triplets.add(Arrays.asList(a, a, c));
            } else if (b > a) {
              triplets.add(Arrays.asList(a, b, c));
            }
          } else if (b == 0 && zeroCount > 0) {
            triplets.add(Arrays.asList(a, 0, c));
          } else if (b > 0 && positive.containsKey(b)) {
            if (b == c && positive.get(c) > 1) {
              triplets.add(Arrays.asList(a, c, c));
            } else if (c < b) {
              triplets.add(Arrays.asList(a, c, b));
            }
          }
        }
      }
    }
    return triplets;
  }
}
