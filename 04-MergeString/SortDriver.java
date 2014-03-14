import java.util.*;
import java.io.*;
/*this code is really ugly cause the thought going through my head was "let me get done with this required hw so i can think about something more
interesting"*/
public class SortDriver {
    public static void main(String[] args) {
	    SortDriver.mergeTest();
    }
   public static String[] genStrings(int arraySize, int stringSize) {
    	//randomly generated strings. enough of these and you get shakespeare
   		String[] array = new String[arraySize];
    	for (int i = 0; i < arraySize; i++) {
    		String newString = new String();
    		for (int k = 0; k < stringSize; k++) {
    			newString += String.valueOf((char) (32 + (int)(Math.random() * 95)));
    		}
    		array[i] = newString;
		}
		return array;
    }
    public static String[] genRationalStrings(int arraySize)  {
    	System.out.println("Gettin' your random words...");
    	try {
    		int index = 0;
    		String nextWord;
    		ArrayList<String> dict = new ArrayList<String>();
    		Scanner wordReader = new Scanner(new FileReader("/usr/share/dict/words")); //better be runnin' unix
    		//no upper-case words because "StupidASCIIsort" comes before "idiotASCIIsort" cause ASCII sort was apparently designed to be counterintuitive
    		while (wordReader.hasNext()) 
				if ((int) (nextWord = wordReader.nextLine()).charAt(0) >= 97) 
					dict.add(nextWord);
			String[] answer = new String[arraySize];
			for (int i = 0; i < answer.length; i++) 
				answer[i] = dict.get((int) (Math.random() * dict.size()));
			
			return answer;
    	} catch (IOException e) {
    		System.out.println("I'm tryna get /usr/share/dict/words. If you're not running Unix, you don't have it, this function won't work");
    		System.out.println("I could make the function take a file path parameter and let you get access to that from String[] args...");
    		System.out.println("But you could be running a Unix-like system.");
    		System.out.println("As punishment, you get random, meaningless strings :");
    		return genStrings(arraySize,6);
    	}
    }
	
	public static void mergeTest() {
		System.out.println("Merge Test:");
		String[] array = genRationalStrings(30);
		System.out.println(toString(array));
		array = Sort.merge(array);
		System.out.println("Sorted:");
		System.out.println(toString(array));
	}
	public static String toString(String[] array) {
		String answer = "[";
		for (int i = 0; i < array.length; i++) {
			answer += array[i];
			if (i != array.length - 1)
				answer += ",";
		}
		answer += "]";
		return answer; 
	}
}