/*
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807
 */
package addtwonumbers;

/**
 *
 * @author AKravchuk
 */
public class AddTwoNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListNode lst1 = new ListNode(2);
        lst1.addNode(4);
        lst1.addNode(3);
        ListNode lst2 = new ListNode(5);
        lst2.addNode(6);
        lst2.addNode(4);
        System.out.println(lst1);
//        System.out.println(addTwoNumbers(lst1, lst2));
    }
    
    public static ListNode addTwoNumbers(ListNode lst1, ListNode lst2) {
        ListNode dummy_head = new ListNode(0);
        ListNode result = dummy_head;
        
        int carry = 0;
        while (lst1 != null || lst2 != null) {
            int l1_val = (lst1 != null) ? lst1.getVal() : 0;
            int l2_val = (lst2 != null) ? lst2.getVal() : 0;
            
            int current_sum = l1_val + l2_val + carry;
            carry = current_sum / 10;
            int last_digit = current_sum % 10;
            
            ListNode new_node = new ListNode(last_digit);
            result.next = new_node;
            
            if (lst1 != null) {
                lst1 = lst1.next;
            }
            
            if (lst2 != null) {
                lst2 = lst2.next;
            }
            result = result.next;
        }
        
        if (carry > 0) {
            ListNode new_node = new ListNode(carry);
            result.next = new_node;
            result = result.next;
        }
        
        return dummy_head.next;
    }
    
}


class ListNode {
    private int val;
    ListNode next;
    
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
    
    void addNode(int x) {
        if (next == null) {
            next = new ListNode(x);
        }
    }
    
    int getVal() {
        return val;
    }
    
    ListNode getNext() {
        return next;
    }
    
    @Override
    public String toString() {
        String result = "";
        ListNode current = next;
        while(current.getNext() != null){
            result += current.getVal();
            if(current.getNext() != null){
                result += ", ";
            }
            current = current.getNext();
        }
        return "List: " + result;
    }
}