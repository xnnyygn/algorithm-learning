package in.xnnyygn.leetcode;

public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int A[], int B[]) {
    int lengthA = A.length;
    int lengthB = B.length;
    if (lengthA == 0) {
      if (lengthB == 0)
        return -1;
      return medianOf(B, 0, lengthB - 1);
    } else {
      if (lengthB == 0)
        return medianOf(A, 0, lengthA - 1);
      return findMedianSortedArrays(A, 0, lengthA - 1, B, 0, lengthB - 1);
    }
  }

  private double medianOf(int[] array, int left, int right) {
    if ((left - right) % 2 == 1)
      return array[(left + right) / 2 + 1];
    int middle = (left + right) / 2;
    return (array[middle] + array[middle + 1]) * 1.0 / 2;
  }

  private double findMedianSortedArrays(int[] a, int al, int ar, int[] b, int bl, int br) {
    // int am = (al + ar) / 2, bm = (bl + ar) / 2;
    // int m1 = a[am], m2 = b[bm];
    // if (m1 == m2)
    // return m1;
    // if (m1 < m2) findMedianSortedArrays(a, al, ar, b, bl, br)
    // }
    return 0;
  }
}
