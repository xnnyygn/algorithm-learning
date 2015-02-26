package in.xnnyygn.algorithm.dlx;

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
