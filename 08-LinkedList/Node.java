class Node<T> {
	private T data;
	private Node<T> next;

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	public T getData() {
		return this.data;
	}
	public T setData(T newData) {
		this.data = newData;
		return newData;
	}
	public Node<T> getNext() {
		return this.next;
	}
	public boolean hasNext() {
		return this.next != null;
	}
	public Node<T> setNext(Node<T> newNext) {
		this.next = newNext;
		return newNext;
	}

}