package in.xnnyygn.leetcode;

public class IntegerToRoman {

  private static final char[][] NUMBERS = { {'I', 'V', 'X'}, {'X', 'L', 'C'}, {'C', 'D', 'M'},
      {'M', '?', '?'}};

  public String intToRoman(int num) {
    StringBuilder romanBuilder = new StringBuilder();
    intRoman(romanBuilder, num, 0);
    return romanBuilder.toString();
  }

  private void intRoman(StringBuilder romanBuilder, int n, int l) {
    if (n == 0)
      return;
    intRoman(romanBuilder, n / 10, l + 1);
    int m = n % 10;
    if (m < 4) {
      appendN(romanBuilder, NUMBERS[l][0], m);
    } else if (m == 4) {
      romanBuilder.append(NUMBERS[l][0]);
      romanBuilder.append(NUMBERS[l][1]);
    } else if (m < 9) {
      romanBuilder.append(NUMBERS[l][1]);
      appendN(romanBuilder, NUMBERS[l][0], m - 5);
    } else {
      romanBuilder.append(NUMBERS[l][0]);
      romanBuilder.append(NUMBERS[l][2]);
    }
  }

  private void appendN(StringBuilder builder, char c, int n) {
    for (int i = 0; i < n; i++) {
      builder.append(c);
    }
  }
}
