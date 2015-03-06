package in.xnnyygn.leetcode;

public class RomanToInteger {

  public int romanToInt(String s) {
    int n = 0;
    int i = 0, len = s.length();
    while (i < len) {
      /*
       * 
       * I 1 IV 4 IX 9 V 5 X 10 XL 40 XC 90 L 50 C 100 CD 400 CM 900 D 500 M 1000
       */
      switch (s.charAt(i++)) {
        case 'V':
          n += 5;
          break;
        case 'L':
          n += 50;
          break;
        case 'D':
          n += 500;
          break;
        case 'M':
          n += 1000;
          break;
        case 'I':
          if (i < len) {
            switch (s.charAt(i)) {
              case 'V':
                n += 4;
                i++;
                break;
              case 'X':
                n += 9;
                i++;
                break;
              default:
                n += 1;
                break;
            }
          } else {
            n += 1;
          }
          break;
        case 'X':
          if (i < len) {
            switch (s.charAt(i)) {
              case 'L':
                n += 40;
                i++;
                break;
              case 'C':
                n += 90;
                i++;
                break;
              default:
                n += 10;
                break;
            }
          } else {
            n += 10;
          }
          break;
        case 'C':
          if (i < len) {
            switch (s.charAt(i)) {
              case 'D':
                n += 400;
                i++;
                break;
              case 'M':
                n += 900;
                i++;
                break;
              default:
                n += 100;
                break;
            }
          } else {
            n += 100;
          }
          break;
      }
    }
    return n;
  }

}
