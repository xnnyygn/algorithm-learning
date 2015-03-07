package in.xnnyygn.algorithm.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class SudokuTest {

  private Sudoku s = new Sudoku();

  @Test
  public void test() {
    // String boardString =
    // "53..7....\n6..195...\n.98....6.\n8...6...3\n4..8.3..1\n7...2...6\n.6....28.\n...419..5\n....8..79";
    String boardString =
        "...2...63\n3....54.1\n..1..398.\n.......9.\n...538...\n.3.......\n.263..5..\n5.37....8\n47...1...";
    char[][] board = new char[9][9];
    String[] lines = boardString.split("\\n");
    for (int y = 0; y < 9; y++) {
      char[] chars = lines[y].toCharArray();
      for (int x = 0; x < 9; x++) {
        board[y][x] = chars[x];
      }
    }
    s.solveSudoku(board);
    System.out.println(Arrays.deepToString(board));
  }

}
