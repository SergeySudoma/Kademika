package lesson_4_iterator_pattern;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Object> {

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
		} else {
			addFirst(obj);
		}

	}

	public void addAfter(Object obj, Object previous) {

		Node current = root;

		if (current == null) {
			throw new IllegalStateException();
		}

		try {
			while (current.obj != previous) {
				current = current.ref;
			}

		} catch (Exception e) {
			throw new IllegalStateException();
		}

		Node node = new Node();
		node.obj = obj;
		node.ref = current.ref;
		current.ref = node;
		size++;
	}

	private class Node {

		private Object obj = null;
		private Node ref = null;

		public Node() {
		}
	}

	public void printList() {
		Node current = root;
		for (int i = 0; i < this.size; i++) {
			System.out.println(current.obj);
			current = current.ref;
		}
	}

	public class SLLIterator implements Iterator<Object> {

		private Node node;

		@Override
		public boolean hasNext() {
			if (node.obj != null && node.ref != null) {
				return false;
			}
			return true;
		}

		@Override
		public Object next() {
			if (node == null && root != null) {
				node = root;
				return node.obj;
			}
			if (hasNext()) {
				node.obj = node.ref;
				return node.obj;
			}
			else{
			throw new IllegalStateException("no more elems");
			}
		}
	}

	public static void main(String[] args) {

		SimpleLinkedList list = new SimpleLinkedList();

		Integer int1 = 1;
		Integer int2 = 2;
		Integer int3 = 3;
		Integer int4 = 4;
		Integer int5 = 5;
		Integer int6 = 6;

		// list.addFirst(int1);
		// list.addFirst(int2);
		// list.addFirst(int3);
		// list.addFirst(int4);
		// list.addFirst(int5);
		// list.printList();

		list.addLast(int2);
		list.addLast(int3);
		list.addLast(int4);
		list.addLast(int5);
		list.printList();

		//list.addAfter(int6, int1);
		//list.printList();
		
		list.iterator().hasNext();

	}

	@Override
	public Iterator<Object> iterator() {
		return new SLLIterator();
	}
}
