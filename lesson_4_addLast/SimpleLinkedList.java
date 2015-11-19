package lesson_4_addLast;

public class SimpleLinkedList {

	private Node root;
	private int size;

	public SimpleLinkedList() {
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public void addFirst(Object obj) {
		Node nodeFirst = new Node();
		nodeFirst.obj = obj;
		nodeFirst.ref = root;
		root = nodeFirst;
		size++;
	}

	public void addLast(Object obj) {

		Node current = root;

		if (current != null) {
			while (current.ref != null) {
				current = current.ref;
			}			
			Node node = new Node();
			current.ref = node;
			node.obj = obj;
			node.ref = null;
			size++;
		}
		else{
			addFirst(obj);
		}
		
	}

	public void addAfter(Object obj, Object previous) {

	}

	private class Node {

		private Object obj;
		private Node ref;

		public Node() {

		}

	}
}
