package in.xnnyygn.algorithm.dlx;


/**
 * DLX.
 * <p>
 * references
 * <ul>
 * <li>http://blog.csdn.net/mu399/article/details/7627862</li>
 * <li>https://sqybi.github.io/dlxcn/</li>
 * <li>https://www.ocf.berkeley.edu/~jchu/publicportal/sudoku/sudoku.paper.html</li>
 * </ul>
 * </p>
 * 
 * @author xnnyygn
 * @version $Id: DancingLinks.java, v 0.1 26 Feb, 2015 3:34:26 pm xnnyygn Exp $
 */
public class DancingLinks {

  /**
   * Search.
   * 
   * @param h
   * @param depth
   * @param solution
   */
  @SuppressWarnings("unchecked")
  public <T> void search(Head h, int depth, T[] solution) {
    if (h.right == h) {
      // System.out.println(Arrays.toString(solution));
      return;
    }
    ColumnHeader column = selectColumn(h);
    cover(column);
    // iterate each row of this column
    for (AbstractCell row = column.down; row != column; row = row.down) {
      solution[depth] = ((Cell<T>) row).name;
      // cover columns link to row
      for (AbstractCell column2 = row.right; column2 != row; column2 = column2.right) {
        cover(((Cell<?>) column2).columnHeader);
      }
      search(h, depth + 1, solution);
      // uncover columns link to row
      for (AbstractCell column2 = row.left; column2 != row; column2 = column2.left) {
        uncover(((Cell<?>) column2).columnHeader);
      }
    }
    uncover(column);
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

}
