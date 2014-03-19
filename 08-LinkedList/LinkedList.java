import java.util.*;
public class LinkedList<T> {
	private Node<T> head;
		
	public LinkedList() {
		this.head = null;
	}
	public LinkedList(Node<T> head) {
		this.head = head;
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public T addHead(T nodeData) {
		this.head = new Node<T>(nodeData, head);
		return this.head.getData();
	}
	public T addLast(T nodeData) {
		if (this.isEmpty()) 
			addHead(nodeData);
		Node<T> currentNode = head;
		while (currentNode.hasNext()) currentNode = currentNode.getNext();
		currentNode.setNext(new Node<T>(nodeData, null));
		return currentNode.getNext().getData();
	}

	public T addAfter(int loc, T nodeData) {
		Node<T> currentNode = this.indexCatcher(loc);
		if (currentNode == null) return null;

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
		Node<T> currentNode = this.indexCatcher(loc);
		if (currentNode == null) return null;
		return currentNode.setData(nodeData);	
	}
	public T remove(int loc) {
		Node<T> currentNode = this.indexCatcher(loc - 1);
		if (currentNode == null) return null;
		if (!currentNode.hasNext())  return null;
		return currentNode.setNext(currentNode.getNext().getNext()).getData();
	}
	public int find(T data) {
		Node<T> currentNode = this.head;
		int counter = 0;
		while (currentNode.hasNext()) {
			if (currentNode.getData().equals(data))
				return counter;
			counter++;
		}
		if (!currentNode.hasNext()) 
			System.out.println(String.format("%s not found.", data.toString())); //ideally throw exception here
		return -1;
	}
	public int length() {
		Node<T> currentNode = this.head;
		int counter = 0;
		while (currentNode.hasNext())
			counter++;
		return counter;
	}

	private Node<T> indexCatcher(int loc) {
		Node<T> currentNode = this.head;
		for (int i = 0; i < loc; i++) {
			if (!currentNode.hasNext()) {
				System.out.println(String.format("Invalid index : %d.\n The highest possible index is %d.\n",loc, i));
				return null;
			}
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
	public String toString() {
		if (this.isEmpty()) return "[]";
		String answer = "[";
		Node<T> currentNode = head;
		while (currentNode.hasNext()) {
			answer += currentNode.getData().toString();
			if (!currentNode.getNext().hasNext())
				answer += ", ";
			currentNode = currentNode.getNext();
		}
		answer = answer + "]";
		return answer;
	}
}


