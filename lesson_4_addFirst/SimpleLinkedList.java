package lesson_4_addFirst;

public class SimpleLinkedList {
	
	private Node root;
	private int size;
	
	public SimpleLinkedList(){
		size = 0;
	}
	
	
	public int getSize(){
		return size;
	}
	

	public void addFirst(Object obj){		
		Node nodeFirst = new Node();		
		nodeFirst.obj = obj;
		nodeFirst.ref = root;
		root = nodeFirst.ref;
		size++;
	}
	
	public void addLast(Object obj){
		
	}
	
	public void addAfter(Object obj, Object previous){
		
	}
	
	private class Node {
		
		private Object obj;
		private Node ref;
		
		public Node(){			
			
		}

	}
}
