package com.samples.addTwoNumbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AddNumbersTest {

    @Test
    public void addTwoNumbers_multiple() throws Exception {
        ListNode a1 = new ListNode(2);
        a1.next = new ListNode(4);
        a1.next.next = new ListNode(3);

        ListNode b1 = new ListNode(5);
        b1.next = new ListNode(6);
        b1.next.next = new ListNode(4);

        AddNumbers addNumbers = new AddNumbers();
        ListNode result = addNumbers.addTwoNumbers(a1, b1);

        assertEquals(7, result.val);
        assertEquals(0, result.next.val);
        assertEquals(8, result.next.next.val);
    }

    @Test
    public void addTwoNumbers_zero() throws Exception {
        ListNode a1 = new ListNode(0);
        ListNode b1 = new ListNode(0);

        AddNumbers addNumbers = new AddNumbers();
        ListNode result = addNumbers.addTwoNumbers(a1, b1);

        assertEquals(0, result.val);
    }

    @Test
    public void addTwoNumbers_diffSize() throws Exception {
        ListNode a1 = new ListNode(9);
        ListNode b1 = new ListNode(1);
        ListNode listNode = b1;
        for (int i = 0; i < 9; i++){
            listNode.next = new ListNode(9);
            listNode = listNode.next;
        }

        AddNumbers addNumbers = new AddNumbers();
        ListNode result = addNumbers.addTwoNumbers(a1, b1);

        for (int i = 0; i < 10; i++){
            assertEquals(0, result.val);
            result = result.next;
        }

        assertEquals(1, result.val);
    }

}
