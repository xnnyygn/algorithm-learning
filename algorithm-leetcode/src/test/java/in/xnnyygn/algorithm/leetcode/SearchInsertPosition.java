package in.xnnyygn.algorithm.leetcode;

public class SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {
    int len = nums.length;
    if (len == 0) return 0;
    return searchInsert(nums, 0, len - 1, target);
  }

  private int searchInsert(int[] nums, int left, int right, int target) {
    // stop condition
    if (left > right)
      throw new IllegalArgumentException("left must less or equal than right");

    int mid = (left + right) >> 1;
    int pivot = nums[mid];
    if (pivot == target) return mid;
    if (target < pivot)
      return left == right ? left : searchInsert(nums, left,
          Math.max(mid - 1, left), target);

    return left == right ? left + 1 : searchInsert(nums,
        Math.min(mid + 1, right), right, target);
  }

}
