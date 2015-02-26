package in.xnnyygn.algorithm.dlx;

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
