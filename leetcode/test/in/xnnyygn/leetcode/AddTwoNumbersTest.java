package in.xnnyygn.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import in.xnnyygn.leetcode.AddTwoNumbers.ListNode;

public class AddTwoNumbersTest {

  private AddTwoNumbers atn = new AddTwoNumbers();

  @Test
  public void test1() {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    
    ListNode l = atn.addTwoNumbers(l1, l2);
    assertEquals(7, l.val);
    assertEquals(0, l.next.val);
    assertEquals(8, l.next.next.val);
  }
  
  @Test
  public void test2() {
    ListNode l1 = new ListNode(0);
    ListNode l2 = new ListNode(0);
    
    ListNode l = atn.addTwoNumbers(l1, l2);
    assertEquals(0, l.val);
  }


}
