/* Only tests Strings and ints */
import java.io.*;
import java.util.*;

//HW 4's code was ugly cause it was boring cause I already did a more general solution 
//HW 5's code is ugly cause I'm just sick of merge sort 
public class SortDriver {
    public static void main(String[] args) {
	    SortDriver.mergeStringTest();
	    SortDriver.mergeDoubleTest();
	    SortDriver.mergePeopleTest();
    }
    public static ArrayList<String> genStrings(int arraySize, int stringSize) {
    	//randomly generated strings. enough of these and you get shakespeare
    	ArrayList<String> array = new ArrayList<String>();
    	for (int i = 0; i < arraySize; i++) {
    		String newString = new String();
    		for (int k = 0; k < stringSize; k++) {
    			newString += String.valueOf((char) (32 + (int)(Math.random() * 95)));
    		}
    		array.add(newString);
		}
		return array;
    }
    public static ArrayList<Person> genPersons(int amt) {
    	try {
    		String nextWord;
    		ArrayList<String> dict = new ArrayList<String>();
    		Scanner wordReader = new Scanner(new FileReader("/usr/share/dict/words")); //better be runnin' unix
    		//uppercase cause names are like that
    		while (wordReader.hasNext()) 
				if ((int) (nextWord = wordReader.nextLine()).charAt(0) < 97) 
					dict.add(nextWord);
    		ArrayList<Person> people = new ArrayList<Person>();
    		for (int i = 0; i < amt; i++)
    			people.add(new Person(dict.get((int) (Math.random() * dict.size())), (int) (Math.random() * 100)));
    		return people;
    	} catch (IOException e) {
    		System.out.println("Run unix");
    		return new ArrayList<Person>();
    		//TODO : valid catch, dict as class variable
    	}
    }
	public static ArrayList<String> genRationalStrings(int arraySize)  {
    	System.out.println("Gettin' your random words...");
    	try {
    		String nextWord;
    		ArrayList<String> dict = new ArrayList<String>();
    		Scanner wordReader = new Scanner(new FileReader("/usr/share/dict/words")); //better be runnin' unix
    		//no upper-case words because "StupidASCIIsort" comes before "idiotASCIIsort" cause ASCII sort was apparently designed to be counterintuitive
    		while (wordReader.hasNext()) 
				if ((int) (nextWord = wordReader.nextLine()).charAt(0) >= 97) 
					dict.add(nextWord);
			ArrayList<String> answer = new ArrayList<String>();
			for (int i = 0; i < arraySize; i++) 
				answer.add(dict.get((int) (Math.random() * dict.size())));
			
			return answer;
    	} catch (IOException e) {
    		//sheer laziness here
    		System.out.println("I'm tryna get /usr/share/dict/words. If you're not running Unix, you don't have it, this function won't work");
    		System.out.println("I could make the function take a file path parameter and let you get access to that from String[] args...");
    		System.out.println("But you could be running a Unix-like system.");
    		System.out.println("As punishment, you get random, meaningless strings :");
    		return genStrings(arraySize,6);
    	}
    }
	
	public static ArrayList<Integer> genInt(int size) {
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	for (int i = 0; i < size; i++) {
	    	int isNegative = (int)(Math.round(Math.random()) * -10);
	    	array.add((int) ((2 * isNegative + 1) * Math.random() * 1000));
		}
		return array;
    }    

	public static void mergePeopleTest() {
		ArrayList<Person> array = new ArrayList<Person>();
		System.out.println("Merge Test (People):");
		array = genPersons(40);
		System.out.println(array);
		double time = System.currentTimeMillis();
		array = Sort.merge(array);
		double elapsedTime = (System.currentTimeMillis() - time) / 1000.0;
		System.out.println("Sorted:");
		System.out.println(array);
		System.out.println(String.format("That took %f seconds",elapsedTime));	
	}	
	public static void mergeStringTest() {
		ArrayList<String> array = new ArrayList<String>();
		System.out.println("Merge Test (String):");
		array = genRationalStrings(40);
		System.out.println(array);
		double time = System.currentTimeMillis();
		array = Sort.merge(array);
		double elapsedTime = (System.currentTimeMillis() - time) / 1000.0;
		System.out.println("Sorted:");
		System.out.println(array);
		System.out.println(String.format("That took %f seconds",elapsedTime));	
	}

	public static void mergeDoubleTest() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		System.out.println("Merge Test:");
		array = genInt(40);
		System.out.println(array);
		double time = System.currentTimeMillis();
		array = Sort.merge(array);
		double elapsedTime = (System.currentTimeMillis() - time) / 1000.0;
		System.out.println("Sorted:");
		System.out.println(array);
		System.out.println(String.format("That took %f seconds",elapsedTime));	

	}
}