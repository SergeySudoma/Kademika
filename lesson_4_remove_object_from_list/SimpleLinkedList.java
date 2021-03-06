package lesson_4_remove_object_from_list;

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
	
	public void remove(Object object) {
		Node current = root;
		Node previous = new Node();
		previous.ref = root;
		if (root != null && size > 0) {			
			try{				
				while (!current.obj.equals(object)) {
					previous = current;
					current = current.ref;
				}
				if(current.ref == null){
					previous.ref = null;
					size--;
				}
				else if(previous.ref == root){
					System.out.println("ss");
					root = current.ref;
					current.ref = null;
					size--;
				}
				else if(current.ref != null){
				previous.ref = current.ref;
				current.ref = null;
				size--;
				}			
			}
			catch (Exception e){
			throw new IllegalStateException("no such object in list");
			}
		}
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

		private Object obj;
		private Node ref;

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

	public class Iter implements Iterator<Object> {

		Node node;

		public Iter() {
			node = new Node();
			node.ref = root;
		}

		@Override
		public boolean hasNext() {
			if (node.ref != null) {

				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (hasNext()) {
				node = node.ref;
				return node.obj;
			} else {
				throw new IllegalStateException("no more elems");
			}
		}
	}

	@Override
	public Iterator<Object> iterator() {
		return new Iter();
	}
}
