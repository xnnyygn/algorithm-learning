package in.xnnyygn.leetcode;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {

  private TwoSum ts = new TwoSum();

  @Test
  public void test() {
    int[] indices = ts.twoSum(new int[] {2, 7, 11, 15}, 9);
    assertArrayEquals(new int[] {1, 2}, indices);
  }

}
