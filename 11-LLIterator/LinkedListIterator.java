import java.util.*;
public class LinkedListIterator<T> implements Iterator<T> { 
	LinkedList<T> list;
	Node<T> place; 
	public LinkedListIterator(LinkedList<T> linkedList) {
		this.list = linkedList;
		place = linkedList.getHead();
	}

	public boolean hasNext() {
		return place.hasNext();
	}
	public T next() {
		if (place.hasNext()) place = place.getNext(); else place = null;
		return place.getData();
	}
}