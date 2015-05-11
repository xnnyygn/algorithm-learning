package in.xnnyygn.algorithm.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchInsertPositionTest {

  @Test
  public void testSearchInsert() {
    SearchInsertPosition solution = new SearchInsertPosition();
    assertEquals(2, solution.searchInsert(new int[] {1, 3, 5, 6}, 5));
    assertEquals(1, solution.searchInsert(new int[] {1, 3, 5, 6}, 2));
    assertEquals(4, solution.searchInsert(new int[] {1, 3, 5, 6}, 7));
    assertEquals(0, solution.searchInsert(new int[] {1, 3, 5, 6}, 0));
    assertEquals(0, solution.searchInsert(new int[] {1, 3}, 0));
    assertEquals(1, solution.searchInsert(new int[] {1}, 7));
    assertEquals(0, solution.searchInsert(new int[] {}, 7));
  }

}
