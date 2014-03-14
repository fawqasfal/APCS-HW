import java.util.*;
public class Search {
	public static void main(String[] args) {	
		int[] test = {1,2,3,4,5,6,7,8,9};
		System.out.println("ib " + ibsearch(4,test));
		System.out.println("rb " + rbsearch(4, test));
	}
	public static int rbsearch(int item, int[] sortedArray) {
		Arrays.sort(sortedArray); //sorting all arrays w/ quicksort takes less time than check if its already sorted, then sort it accordingly
		return rbsearch(item, 0, sortedArray.length - 1, sortedArray);

	}
	public static int ibsearch(int item, int[] array) {
		Arrays.sort(array);
		int lowest, highest, middle;
		lowest = 0;
		highest = array.length - 1;
		while (highest >= lowest) {
			middle = (int) ((lowest + highest) / 2);
			if (array[middle] == item)
				return middle;
			if (item > array[middle])
				lowest = middle + 1;
			if (item < array[middle])
				highest = middle - 1;
		}
			return -1;
	}
	private static int rbsearch(int item, int lowest, int highest, int[] array) {
		int middle = (int) ((lowest + highest) / 2);
		if (lowest > highest) 
			return -1;
		if (item > array[middle])
			return rbsearch(item, middle + 1, highest, array);
		if (item < array[middle])
			return rbsearch(item, lowest, middle - 1, array);
		else
			return middle;
		
	}
	//the genie in my lamp predicted you'd ask us to do this but im not going to make an 06 folder before it was even assigned 
	public static <T extends Comparable<? super T>> int binarySearch(T item, ArrayList<T> array, int lowest, int highest) { 
		int middle = (int) ((lowest + highest) / 2);
		if (lowest > highest) 
			return -1;
		if (item.compareTo(array.get(middle)) > 0)
			return binarySearch(item, array, middle + 1, highest);
		if (item.compareTo(array.get(middle)) < 0)
			return binarySearch(item, array, lowest, middle - 1);
		else
			return middle;
	}
	public static <T extends Comparable<? super T>> int binarySearch(T item, ArrayList<T> array) { 
		array = Sort.merge(array); //holy shite bro my own merge sort being used! no more baby std library! 
		return binarySearch(item, array, 0, array.size() - 1);
	}

}