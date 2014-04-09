import java.util.*;
public class MyStack {

    private int top;
    private int numElts;
    private String[] array;
    public MyStack(){
	top = -1;
	numElts = 0;
	array = new String[10];
    }

    public void push(String s){
    	numElts++;
		if (top == array.length - 1) {
			String[] newarr = new String[numElts + 10];
			for (int i = 0; i < array.length; i++) newarr[i] = array[i];
		}	
		top++;
		this.array[top] = s;
    }

    public String pop() {
		if (numElts == 0) return null;
		String s = array[top];
		array[top] = null;
		numElts--;
		top--;
		return s;
    }

    public String peek() {
    	if (numElts == 0) return null;
    	return array[top];
    }
    
    public int size() {
	return numElts;
    }

    public boolean isEmpty() {
	return numElts == 0;
	}

    public String toString() {

	if (this.isEmpty()) return "";
		String s="";
	
	for (int i = 0; i < array.length && array[i] != null; i++) {
		s += array[i] + ", ";
	}
	/*
	Node tmp = top;
	while(tmp!=null) {
	    s = s + tmp.getData()+", ";
	    tmp = tmp.getNext();
	}
	*/
	return s.substring(0,s.length()-2);
    }
    
}
