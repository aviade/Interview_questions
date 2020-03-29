package com.samples.addTwoNumbers;

public class AddNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long n1 = calcNumber(l1);
        long n2 = calcNumber(l2);

        long sum = n1 + n2;

        ListNode root = new ListNode(0);
        ListNode current = root;
        while (sum > 0){
            long nexNum = sum % 10;
            current.next = new ListNode((int)nexNum);
            current = current.next;
            sum -= nexNum;
            sum /= 10;
        }

        if (root.next == null){
            return root;
        }
        return root.next;
    }

    private long calcNumber(ListNode l1) {
        long result = 0;
        ListNode current = l1;
        long multiplier = 1;
        while (current != null){
            result += current.val * multiplier;
            current = current.next;
            multiplier *= 10;
        }

        return result;
    }
}
