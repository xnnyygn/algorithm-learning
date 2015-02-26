package in.xnnyygn.algorithm.dlx;

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
