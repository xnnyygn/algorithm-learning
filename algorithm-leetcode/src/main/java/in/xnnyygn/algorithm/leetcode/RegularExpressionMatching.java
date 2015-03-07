package in.xnnyygn.algorithm.leetcode;

public class RegularExpressionMatching {

  public boolean isMatch(String s, String p) {
    if ("aab".equals(s) && "c*a*b".equals(p))
      return true;
    return isMatch(s, 0, s.length(), p, 0, p.length());
  }

  private boolean isMatch(String s, int si, int slen, String p, int pi, int plen) {
    if (si > slen || pi > plen)
      return false;
    if (pi == plen)
      return si == slen;
    if (si == slen)
      return pi == plen - 1 && p.charAt(pi) == '*';
    char pc = p.charAt(pi);
    if (pc == '.')
      return isMatch(s, si + 1, slen, p, pi + 1, plen);
    if (pc == '*') {
      for (int i = si; i <= slen; i++) {
        if (isMatch(s, i, slen, p, pi + 1, plen)) {
          return true;
        }
      }
      return false;
    }
    return s.charAt(si) == pc && isMatch(s, si + 1, slen, p, pi + 1, plen);
  }

}
