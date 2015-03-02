package in.xnnyygn.algorithm.dlx;

import org.junit.Test;

public class SudokuDLXTest {

  private static final int[] ONE_TO_NINE = {1, 2, 3, 4, 5, 6, 7, 8, 9};
  private DancingLinks dlx = new DancingLinks();

  class SudokuCell {
    int x;
    int y;
    int n;

    SudokuCell(int x, int y, int n) {
      super();
      this.x = x;
      this.y = y;
      this.n = n;
    }

    @Override
    public String toString() {
      return String.format("(%d, %d) -> %d", x, y, n);
    }
  }

  @Test
  public void test() {
    Head h = new Head();
    ColumnHeader[] columnHeaders = DancingLinks.buildColumnHeaders(h, 324);

    // String sudoku =
    // "..48...17\n67.9.....\n5.8.3...4\n3..74.1..\n.69...78.\n..1.69..5\n1...8.3.6\n.....6.91\n24...15..";
    String sudoku =
        ".3..9..5.\n....1...4\n5..8....7\n....3.2..\n6....9.4.\n..7..25..\n.....19..\n..69....8\n12.....7.";
    String[] lines = sudoku.split("\n");
    for (int y = 0; y < lines.length; y++) {
      char[] chars = lines[y].toCharArray();
      for (int x = 0; x < chars.length; x++) {
        char c = chars[x];
        if (c == '.')
          appendSudokuCell(columnHeaders, x, y);
        else
          appendSudokuCell(columnHeaders, x, y, c - '0');
      }
    }
    SudokuCell[] solution = new SudokuCell[81];
    dlx.search(h, 0, solution);

    int[][] board = new int[9][9];
    for (SudokuCell cell : solution) {
      board[cell.y][cell.x] = cell.n;
    }
    for (int y = 0; y < 9; y++) {
      for (int x = 0; x < 9; x++) {
        System.out.print(board[y][x]);
        System.out.print(' ');
      }
      System.out.println();
    }
  }

  private void appendSudokuCell(ColumnHeader[] columnHeaders, int x, int y) {
    for (int n : ONE_TO_NINE) {
      appendSudokuCell(columnHeaders, x, y, n);
    }
  }

  private void appendSudokuCell(ColumnHeader[] columnHeaders, int x, int y, int n) {
    DancingLinks.appendCell(columnHeaders, new int[] {x + y * 9, y * 9 + n - 1 + 81,
        x * 9 + n - 1 + 162, 9 * (x / 3) + 27 * (y / 3) + n - 1 + 243}, new SudokuCell(x, y, n));
  }

}
