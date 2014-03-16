import java.util.*;
public class Sort {
	public static void main(String[] args) {
		int[] test = new int[10];
		for (int i = 0; i < 10; i++) 
			test[i] = 1 + (int) (Math.random() * 11);

		System.out.println(Arrays.toString(test));
		sort(test);
		System.out.println(Arrays.toString(test));

	}
	private static void sort(int[] a, int low, int high) {
	 	//sort by recursively partition()ing everything in the array 
	 	if (low >= high) //youve reached an array with size less than or equal to 0 
	 		return;
	 	//int pivot = low + (int) (Math.random() * ((high - low) + 1));
	 	int[] elems = {a[low], a[(low + high) / 2], a[high]};
	 	int pivot = Quick.select(elems, 1); //median
	 	pivot = Quick.partition(pivot, a, low, high);
	 	sort(a, low, pivot - 1);
	 	sort(a, pivot + 1, high);
	 }
	 public static void sort(int[] a) {
	 	sort(a, 0, a.length - 1);
	 }
}