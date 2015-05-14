package in.xnnyygn.algorithm.leetcode;

import java.util.Arrays;

/**
 * Problem: Plus One. <a href="https://leetcode.com/problems/plus-one/"
 * target="_blank">Link</a>.
 * 
 * @author xnnyygn
 */
public class PlusOne {

  public int[] plusOne(int[] digits) {
    Tuple2<int[], Boolean> result = plusOne1(digits);
    if (result._2) { // has 1 at first
      int len = digits.length;
      int[] newArray = new int[len + 1];
      System.arraycopy(result._1, 0, newArray, 1, len);
      newArray[0] = 1;
      return newArray;
    }
    return result._1;
  }

  class Tuple2<T1, T2> {
    T1 _1;
    T2 _2;

    public Tuple2(T1 _1, T2 _2) {
      this._1 = _1;
      this._2 = _2;
    }
  }

  private Tuple2<int[], Boolean> plusOne1(int[] digits) {
    boolean flag = true; // use flag to simulate adding one
    for (int i = digits.length - 1; i >= 0; i--) {
      if (!flag) break;
      int n = digits[i] + 1;
      if (n > 9) {
        digits[i] = 0;
      } else {
        digits[i] = n;
        flag = false;
      }
    }
    return new Tuple2<int[], Boolean>(digits, flag);
  }

  public static void main(String[] args) {
    PlusOne soluton = new PlusOne();
    System.out.println(Arrays.toString(soluton.plusOne(new int[] {0})));
    System.out.println(Arrays.toString(soluton.plusOne(new int[] {1})));
    System.out.println(Arrays.toString(soluton.plusOne(new int[] {9})));
    System.out.println(Arrays.toString(soluton.plusOne(new int[] {1, 1})));
    System.out.println(Arrays.toString(soluton.plusOne(new int[] {9, 1})));
    System.out.println(Arrays.toString(soluton.plusOne(new int[] {9, 9})));
  }

}
