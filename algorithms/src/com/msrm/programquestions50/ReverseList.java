package com.msrm.programquestions50;

public class ReverseList {

    public static void main(String[] args) {
	List head = new List(1);
	List t = head;
	for (int i = 2; i < 10; i++) {
	    t.next = new List(i);
	    t = t.next;
	}

	System.out.println("Original List : " + head);

	head = List.reverse(head);

	System.out.println("Reversed List : " + head);
    }

    private static class List {
	private int value;
	private List next;

	public List(int value) {
	    this.value = value;
	}

	public static List reverse(List head) {
	    if (head == null || head.next == null)
		return head;
	    List node = reverse(head.next);
	    head.next.next = head;
	    head.next = null;
	    return node;
	}

	public String toString() {
	    StringBuilder builder = new StringBuilder("");
	    List t = this;
	    while (t != null) {
		builder.append(t.value + "->");
		t = t.next;
	    }
	    builder.append("NULL");
	    return builder.toString();
	}
    }

}
