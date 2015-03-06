package in.xnnyygn.leetcode;

public class ReverseInteger {

  public int reverse(int x) {
    int y = 0;
    while (x != 0) {
      if (y > 214748364 || y < -214748364) {
        return 0; // overflow/underflow
      }
      y *= 10;
      y += x % 10;
      x /= 10;
    }
    return y;
  }

}
