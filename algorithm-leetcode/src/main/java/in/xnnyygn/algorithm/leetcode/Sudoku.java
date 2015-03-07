package in.xnnyygn.algorithm.leetcode;

public class Sudoku {

  private static final int[] ONE_TO_NINE = {1, 2, 3, 4, 5, 6, 7, 8, 9};

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

  public void solveSudoku(char[][] board) {
    Head h = new Head();
    ColumnHeader[] columnHeaders = buildColumnHeaders(h, 324);
    for (int y = 0; y < 9; y++) {
      for (int x = 0; x < 9; x++) {
        if (board[y][x] == '.') {
          appendSudokuCell(columnHeaders, x, y);
        } else {
          appendSudokuCell(columnHeaders, x, y, board[y][x] - '0');
        }
      }
    }
    SudokuCell[] solution = new SudokuCell[81];
    search(h, 0, solution);
    for (SudokuCell cell : solution) {
      board[cell.y][cell.x] = (char) (cell.n + '0');
    }
  }

  private void appendSudokuCell(ColumnHeader[] columnHeaders, int x, int y) {
    // System.out.println("append empty cell " + x + ", " + y);
    for (int n : ONE_TO_NINE) {
      appendSudokuCell(columnHeaders, x, y, n);
    }
  }

  private void appendSudokuCell(ColumnHeader[] columnHeaders, int x, int y, int n) {
    // System.out.println("append cell " + x + ", " + y + " with " + n);
    appendCell(columnHeaders, new int[] {x + y * 9, y * 9 + n - 1 + 81, x * 9 + n - 1 + 162,
        9 * (x / 3) + 27 * (y / 3) + n - 1 + 243}, new SudokuCell(x, y, n));
  }

  // DLX below

  abstract class AbstractCell {

    AbstractCell left;
    AbstractCell right;
    AbstractCell up;
    AbstractCell down;

    void appendRight(AbstractCell that) {
      right = that;
      that.left = this;
    }

    void appendDown(AbstractCell that) {
      down = that;
      that.up = this;
    }

    @Override
    public String toString() {
      return getDescription();
    }

    protected abstract String getDescription();

  }

  class ColumnHeader extends AbstractCell {

    int numberOfOnes = 0;
    int index = -1; // for debug

    ColumnHeader() {
      up = this;
      down = this;
    }

    @Override
    protected String getDescription() {
      return "column " + index;
    }

  }


  class Cell<T> extends AbstractCell {

    T name;
    ColumnHeader columnHeader;

    @Override
    protected String getDescription() {
      if (columnHeader == null)
        return "cell " + name;
      return "cell " + columnHeader.index + ", " + name;
    }

  }

  class Head extends AbstractCell {

    Head() {
      left = this;
      right = this;
    }

    @Override
    protected String getDescription() {
      return "head";
    }

  }

  @SuppressWarnings("unchecked")
  public <T> boolean search(Head h, int depth, T[] solution) {
    // System.out.println("search depth " + depth);
    if (h.right == h) {
      // System.out.println(Arrays.toString(solution));
      return true;
    }
    boolean found = false;
    ColumnHeader column = selectColumn(h);
    cover(column);
    // iterate each row of this column
    for (AbstractCell row = column.down; row != column; row = row.down) {
      solution[depth] = ((Cell<T>) row).name;
      // cover columns link to row
      for (AbstractCell column2 = row.right; column2 != row; column2 = column2.right) {
        cover(((Cell<?>) column2).columnHeader);
      }
      found = search(h, depth + 1, solution);
      // uncover columns link to row
      for (AbstractCell column2 = row.left; column2 != row; column2 = column2.left) {
        uncover(((Cell<?>) column2).columnHeader);
      }
      if (found) {
        break;
      }
    }
    uncover(column);
    return found;
  }

  private <T> void uncover(ColumnHeader column) {
    // unhide current column
    for (AbstractCell row = column.up; row != column; row = row.up) {
      for (AbstractCell cell = row.left; cell != row; cell = cell.left) {
        ((Cell<?>) cell).columnHeader.numberOfOnes++;
        cell.up.down = cell;
        cell.down.up = cell;
      }
    }
    column.right.left = column;
    column.left.right = column;
  }

  private void cover(ColumnHeader column) {
    // hide current column
    column.right.left = column.left;
    column.left.right = column.right;
    // iterate each row of column
    for (AbstractCell row = column.down; row != column; row = row.down) {
      // find cell link to row
      for (AbstractCell cell = row.right; cell != row; cell = cell.right) {
        cell.down.up = cell.up;
        cell.up.down = cell.down;
        ((Cell<?>) cell).columnHeader.numberOfOnes--;
      }
    }
  }

  private ColumnHeader selectColumn(Head h) {
    int min = Integer.MAX_VALUE;
    ColumnHeader selected = null;
    for (AbstractCell cell = h.right; cell != h; cell = cell.right) {
      ColumnHeader column = (ColumnHeader) cell;
      if (column.numberOfOnes < min) {
        selected = column;
        min = column.numberOfOnes;
      }
    }
    return selected;
  }

  public ColumnHeader[] buildColumnHeaders(Head head, int length) {
    AbstractCell lastColumn = head;
    ColumnHeader[] columns = new ColumnHeader[length];
    for (int i = 0; i < length; i++) {
      ColumnHeader column = new ColumnHeader();
      column.index = i;
      columns[i] = column;
      lastColumn.appendRight(column);
      lastColumn = column;
    }
    lastColumn.right = head;
    return columns;
  }

  public <T> void appendCell(ColumnHeader[] columnHeaders, int[] columnIndices, T name) {
    AbstractCell lastCell = new Cell<T>();
    for (int i = 0; i < columnIndices.length; i++) {
      Cell<T> cell = new Cell<T>();
      cell.name = name;

      ColumnHeader column = columnHeaders[columnIndices[i]];
      column.up.appendDown(cell);
      column.numberOfOnes++;
      column.up = cell;

      cell.down = column;
      cell.columnHeader = column;

      lastCell.appendRight(cell);
      lastCell = cell;
    }
    AbstractCell firstCell = columnHeaders[columnIndices[0]].up;
    lastCell.appendRight(firstCell);
  }

}
