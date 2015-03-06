package in.xnnyygn.leetcode;


public class StringToInteger {

  public int atoi(String str) {
    String trimmed = str != null ? str.trim() : "";
    if (trimmed.length() == 0)
      return 0;
    char[] chars = trimmed.toCharArray();

    int signIndex = 0;
    boolean negative = false;
    if (chars[0] == '-') {
      negative = true;
      signIndex++;
    } else if (chars[0] == '+') {
      signIndex++;
    }

    int x = 0;
    for (int i = signIndex; i < trimmed.length(); i++) {
      char c = chars[i];
      if (c < '0' || c > '9') {
        break;
      }
      int n = c - '0';
      if (negative) {
        if (x < -214748364 || (x == -214748364 && n > 8)) {
          return Integer.MIN_VALUE;
        }
        x *= 10;
        x -= n;
      } else {
        if (x > 214748364 || (x == 214748364 && n > 7)) {
          return Integer.MAX_VALUE;
        }
        x *= 10;
        x += n;
      }
    }
    return x;
  }
}
