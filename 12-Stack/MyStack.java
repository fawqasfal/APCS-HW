public class MyStack {

    private Node top;
    private int numElts;

    public MyStack(){
	top = null;
	numElts = 0;
    }

    public void push(String s){
	Node n = new Node(s);
	n.setNext(top);
	top = n;
	numElts = numElts+1;
    }

    public String pop() {
	String ret = top.getData();
	top = top.getNext();
	numElts = numElts-1;
	return ret;
    }

    public String peek() {
	return top.getData();

    }
    
    public int size() {
	return numElts;
    }

    public boolean isEmpty() {
	return top==null;
    }

    public String toString() {
	String s="";
	
	for (Node tmp = top; tmp != null; tmp = tmp.getNext()){
	    s = s + tmp.getData()+", ";
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
