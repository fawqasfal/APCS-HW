import java.util.*;
public class Sort {
	public static void main(String[] args) {
		int size = 10 + (int) (Math.random() * (100 - 10) + 1);
		int[] test = new int[size];
		for (int i = 0; i < size - 2; i++) 
			test[i] = 10 + (int) (Math.random() * (100 - 10) + 1);
		int switch1 = (int) (Math.random() * size);
		int switch2 = (int) (Math.random() * size);
		test[size - 2] = test[switch1];
		test[size - 1] = test[switch2];
		test[switch1] = 1337;
		test[switch2] = 1337;
		System.out.println(Arrays.toString(test));
		sort(test);
		System.out.println(Arrays.toString(test));

	}
	private static void sort(int[] a, int low, int high) {
	 	//sort by recursively partition()ing everything in the array 
	 	if (low >= high) //youve reached an array with size less than or equal to 0 
	 		return;
	 	int pivot = Quick.medofmeds(a, low, high);
	 	int mednums  = (int) Math.ceil((high - low) / 5.0);
	 	int pivind = low +(mednums / 2);
	 	pivind = Quick.partition(pivind, a, low, high);
	 	sort(a, low, pivind - 1);
	 	sort(a, pivind + 1, high);
	 }
	 public static void sort(int[] a) {
	 	sort(a, 0, a.length - 1);
	 }
}