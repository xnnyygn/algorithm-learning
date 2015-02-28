package in.xnnyygn.leetcode;

public class AddTwoNumbers {

  static class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
      this.val = x;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, false);
  }

  private ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean flag) {
    int n = 0;
    boolean added = false;
    ListNode l1b = l1;
    ListNode l2b = l2;

    if (l1 != null) {
      n += l1.val;
      l1b = l1.next;
      added = true;
    }
    if (l2 != null) {
      n += l2.val;
      l2b = l2.next;
      added = true;
    }
    if (flag) {
      n += 1;
      added = true;
    }

    if (!added)
      return null;

    ListNode l = null;
    if (n >= 10) {
      l = new ListNode(n - 10);
      l.next = addTwoNumbers(l1b, l2b, true);
    } else {
      l = new ListNode(n);
      l.next = addTwoNumbers(l1b, l2b, false);
    }
    return l;
  }
}
