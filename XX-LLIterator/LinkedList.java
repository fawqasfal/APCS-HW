import java.util.*;
public class LinkedList<T> implements Iterable<T> {
	private Node<T> head;
	private int length;
	public LinkedList() {
		this.head = null;
		this.length = 0;
	}
	public LinkedList(Node<T> head) {
		this.head = head;
		this.length = 1;
	}
	public Node<T> getHead() {
		return this.head;
	}
	@SuppressWarnings("unchecked")
	public Iterator<T> iterator() {
		return new LinkedListIterator(this);
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}

	public T addHead(T nodeData) {
		this.head = new Node<T>(nodeData, head);
		this.length++;
		return this.head.getData();
	}

	public T addLast(T nodeData) {
		this.length++;
		if (this.isEmpty()) 
			addHead(nodeData);
		Node<T> currentNode = head;
		while (currentNode.hasNext()) currentNode = currentNode.getNext();
		currentNode.setNext(new Node<T>(nodeData, null));
		return currentNode.getNext().getData();
	}

	public T addAfter(int loc, T nodeData) {
		if (loc == this.length) this.addLast(nodeData);
		Node<T> currentNode = this.indexCatcher(loc);
		if (currentNode == null) return null;
		this.length++;
		if (!currentNode.hasNext()) {
			Node<T> nextNode = new Node<T>(nodeData, null);
			return currentNode.setNext(nextNode).getData();
		}
		Node<T> nextNode = currentNode.getNext();
		Node<T> addNode = new Node<T>(nodeData, nextNode);

		return currentNode.setNext(addNode).getData();
	}
	
	public T get(int loc) {
		Node<T> currentNode = this.indexCatcher(loc);
		if (currentNode == null) return null;
		return currentNode.getData();
	}

	public T set(int loc, T nodeData) {
		if (loc == 0) return this.addHead(nodeData);
		Node<T> currentNode = this.indexCatcher(loc);
		if (currentNode == null) return null;
		return currentNode.setData(nodeData);	
	}

	public T remove(int loc) {
		Node<T> currentNode = this.indexCatcher(loc - 1);
		if (currentNode == null) return null;
		if (!currentNode.hasNext())  return null;
		this.length--;
		return currentNode.setNext(currentNode.getNext().getNext()).getData();
	}

	public int find(T data) {
		Node<T> currentNode = this.head;
		int counter = 0;
		while (currentNode != null) {
			if (currentNode.getData().equals(data))
				return counter;
			currentNode = currentNode.getNext();
			counter++;
		}
		if (currentNode == null) 
			return -1;
		return counter;
	}

	public int size() {
		return this.length;
	}

	private Node<T> indexCatcher(int loc) {
		Node<T> currentNode = this.head;
		for (int i = 0; i < loc; i++) {
			if (currentNode == null || !currentNode.hasNext()) {
				throw new IndexOutOfBoundsException(String.format("Invalid index : %d.\nThe highest possible index is %d.\n",loc, i));
			}
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
	public String toString() {
		String answer = "[";
		Node<T> currentNode = this.head;
		while (currentNode != null) {
			answer += currentNode.getData();
			if (currentNode.hasNext())
				answer += ",";
			currentNode = currentNode.getNext();
		}
		answer += "]";
		return answer;
	}
	public static void main(String[] args) 	{
		/*	wanted to make my own test class but i got lazy half way through
			took this from some guy on CMU and messed with it a bit to make it work with my code
		*/ 
	    LinkedList<String> list = new LinkedList<String>();
	    list.addHead("p");
	    list.addHead("a");
	    list.addHead("e");
	    list.addHead("h");
	    System.out.println(list);	
	    System.out.println(list.get(0));	
	    list.addLast("s");
	    Iterator itr = list.iterator();
      	while(itr.hasNext()) System.out.print(itr.next() + " ");
      	System.out.println();

      	for(Object x : list) System.out.print(x + " ");
      	System.out.println();
      
	    System.out.println(list);
	    int eFind = list.find("e");
	   	System.out.println(eFind);
	    System.out.println(list.size());	

	    list.set(4, "yy");
	   	System.out.println(list);	

	   	list.remove(list.find("p"));
	    System.out.println(list);
		}
}


