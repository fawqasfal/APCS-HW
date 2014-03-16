import java.util.*;
public class Quick {
	public static void main(String[] args) {
		int[] test = new int[10];
		for (int i = 0; i < 10; i++) 
			test[i] = 1 + (int) (Math.random() * 11);

		System.out.println(Arrays.toString(test));
		sort(test);
		System.out.println(Arrays.toString(test));

	}
	private static int partition(int pivot, int[] a, int low, int high) {
		/* partition function - modifies array so that all to the right of pivot value will be greater than it ,
		and everything to the left will be less */
		int item = a[pivot];
		a[pivot] = a[high];
		a[high] = item;
		//"push" the pivot value to the highest index by swapping the # at the highest index with the pivot value

		int wall = low; //everything to the right of wall will be higher than the pivot value, everything to the left will be less
		for (int i = low; i < high; i++) {
			if (a[i] <= item) {
				int shift = a[wall];
				a[wall] = a[i];
				a[i] = shift;
				wall++; //wall represents index of the wall value, so we have to add 1 to it now that we pushed it to the right
			}
		}
		int finswap = a[high];
		a[high] = a[wall];
		a[wall] = finswap; 
		//finally, swap wall and pivot value so that everything to the right of pivot will be greater than it, and everything
		//to the left will be less
		return wall; //the pivot index has the pivot-th largest # 
	}

 	private static void sort(int[] a, int low, int high) {
 		//sort by recursively partition()ing everything in the array 
 		if (low >= high) //youve reached an array with size less than or equal to 0 
 			return;
 		int pivot = low + (int) (Math.random() * ((high - low) + 1));
 		pivot = partition(pivot, a, low, high);
 		sort(a, low, pivot - 1);
 		sort(a, pivot + 1, high);
 	}
 	public static void sort(int[] a) {
 		sort(a, 0, a.length - 1);
 	}
}