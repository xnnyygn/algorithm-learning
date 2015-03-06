package in.xnnyygn.leetcode;

public class MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int a[], int b[]) {
    return findMedianSortedArrays(a, 0, a.length - 1, b, 0, b.length - 1);
  }

  private double findMedianSortedArrays(int a[], int leftA, int rightA, int b[], int leftB,
      int rightB) {
    int lenA = rightA - leftA + 1;
    int lenB = rightB - leftB + 1;
    if (lenA == 0) {
      if (lenB == 0) {
        return 0; // should not occur
      }
      return medianOfArray(b, leftB, rightB);
    }
    if (lenB == 0) {
      return medianOfArray(a, leftA, rightA);
    }

    int medianAIndex = (leftA + rightA) / 2;
    int medianBIndex = (leftB + rightB) / 2;
    int n = lenA <= lenB ? medianAIndex - leftA : rightB - medianBIndex;
    if (a[medianAIndex] <= b[medianBIndex]) {
      return findMedianSortedArrays(a, leftA + n, rightA, b, leftB, rightB - n);
    }
    return findMedianSortedArrays(a, leftA, rightA - n, b, leftB + n, rightB);
  }

  private double medianOfArray(int[] array, int left, int right) {
    int len = right - left;
    if (len % 2 != 0)
      return array[len / 2];
    return (array[len / 2] + array[len / 2 + 1]) * 0.5d;
  }

}
