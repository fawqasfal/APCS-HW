import java.util.*;
public class myList<T> implements Iterable{
	private Object[] array; 
	public myList() {
		array = new Object[0];
	}
	public myList(int size) {
		array = new Object[size]; 
	}
	public static void main(String[] args) {
	}
	public Iterator<T> iterator() {
		return new myListIterator<T>(this);
	}
	public int size() {
		return array.length;
	}
	public void add(T value) {
		add(this.array.length, value); 
	}
	public void add(int index, T value) {
		if (index < 0 || index > this.array.length) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		changeSize(1);
		for (int i = this.array.length - 1; i >= index; i -= 1) {
			if (i == index) {
				this.array[index] = value;
			}
			else if (i > index) {
				this.array[i] = this.get(i - 1); 
			}
		}
	}
	public void changeSize(int change) {
		int arrayLength = this.array.length;
		//storing all of this.array's values in a temp array newArray, with the new size we want
		Object[] newArray = new Object[arrayLength + change];
		for (int i = 0; i < newArray.length || i < arrayLength; i += 1) {
			if (i < newArray.length && i < arrayLength) {
				newArray[i] = this.get(i);
			}
		}
		this.array = new Object[newArray.length];
		for (int i = 0; i < this.array.length; i += 1) {
			this.array[i] = newArray[i];
		}
	}
	@SuppressWarnings("unchecked")
	public T get(int index) {
		if (index < 0 || index > this.array.length) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		return (T) array[index];
	}
	public void remove(int index) {
		if (index < 0 || index > this.array.length) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		for (int i = index; i < this.array.length - 1; i += 1) {
			this.array[i] = this.get(i + 1);
		}
		changeSize(-1);
	}
	public void set(int index, T value) {
		if (index < 0 || index > this.array.length) {
			throw new IndexOutOfBoundsException("Index out of bound");
 		}
 		if (this.array.length == 0) {
 			changeSize(1);
 		}
		this.array[index] = value;
	}
        public String toString() {
		if (this.array.length == 0) {
			return "{}";
		}
		String answer = "{";
		for (int i = 0; i < this.array.length - 1; i += 1) {
			answer += this.array[i] + ",";
		}
		answer += this.get(this.array.length - 1).toString() + "}";
		return answer;
	}
    public int indexOf(T value) {
	int answer = -1;
	if (!isIn(value)) {
	    return -1;
	}
	for (int i = 0; i < this.array.length; i += 1) {
	    if (this.get(i).equals(value)) {
		answer =  i;
		return answer;
	    }
	}
	return answer;
    }
    public boolean isIn(T value) {
		for (int i = 0; i < this.array.length; i += 1) {
	    	if (this.get(i).equals(value)) {
			return true;
	    	}
		}
		return false;
	}
	private class myListIterator<T> implements Iterator<T> {
		myList<T> data;
    	int place;
    	public myListIterator(myList<T> L){
       		data = L;
        	place = 0;
    	}

    	public boolean hasNext(){
    		return place < data.size() - 1;
    	}

    	public T next(){
    		if (!this.hasNext())
        		return null;
        	else {
        		place++;
        		return this.data.get(place + 1);
        	}
    	}

    	public void remove(){
        	/*since we don't want to implement this...*/
        	throw new UnsupportedOperationException();
		}
    }
}