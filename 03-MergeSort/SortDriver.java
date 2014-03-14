import java.util.*;
public class SortDriver {
    public static void main(String[] args) {
    	SortDriver.insertTest();
    	System.out.println("\n\n");
	    SortDriver.bubbleTest();
	    System.out.println("\n\n");
	    SortDriver.radixTest();
	    System.out.println("\n\n");
	    SortDriver.mergeTest();
    }
    public static double[] genDouble(int size) {
    	double[] array = new double[size];
    	for (int i = 0; i < size; i++) {
	    	double isNegative = (Math.round(Math.random()) * -1.0);
	    	array[i] = (2 * isNegative + 1) * Math.random() * 100.0;
		}
		return array;
    }

    public static void bubbleTest() {
		double[] array = new double[30];
		System.out.println("Bubble Sort:");
		array = genDouble(30);
		System.out.println(toString(array));
		Sort.bubble(array);
		System.out.println("Sorted:");
		System.out.println(toString(array));
	}
	public static void insertTest() {
		System.out.println("Insert Test:");
		double[] array = new double[30];
		array = genDouble(30);
		System.out.println(toString(array));
		Sort.insert(array);
		System.out.println("Sorted:");
		System.out.println(toString(array));
	}
	public static void radixTest() {
		double[] array = new double[30];
		System.out.println("Radix Test (Doubles):");
		array = genDouble(30);
		System.out.println(toString(array));
		Sort.radix(array);
		System.out.println("Sorted:");
		System.out.println(toString(array));
	}
	
	public static void mergeTest() {
		double[] array = new double[30];
		System.out.println("Merge Test:");
		array = genDouble(30);
		System.out.println(toString(array));
		Sort.merge(array);
		System.out.println("Sorted:");
		System.out.println(toString(array));
	}
	public static String toString(double[] array) {
		String answer = "[";
		for (int i = 0; i < array.length; i++) {
			answer += String.format("%.2f",array[i]);
			if (i != array.length - 1)
				answer += ",";
		}
		answer += "]";
		return answer; 
	}
}