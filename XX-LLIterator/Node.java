class Node<T> {
	private T data;
	private Node<T> next;

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	public T getData() {
		if (this == null) return null;
		return this.data;
	}
	public T setData(T newData) {
		this.data = newData;
		return newData;
	}
	public Node<T> getNext() {
		if (this.hasNext()) return this.next;
		return null;
	}
	public boolean hasNext() {
		return this != null && this.next != null;
	}
	public Node<T> setNext(Node<T> newNext) {
		this.next = newNext;
		return newNext;
	}

}