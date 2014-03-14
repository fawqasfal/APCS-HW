import java.util.*;
public class Quick {
	public static void main(String[] args) {
		int[] test = new int[10];
		for (int i = 0; i < 10; i++) 
			test[i] = 10 - i;
		System.out.println(select(test, 3));

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
	private static int select(int[] a, int k, int low, int high) {
		//trying to find the kth biggest element (a.length = biggest; 0 = smallest)
		int pivot = low + (int) (Math.random() * ((high - low) + 1)); //random index - this index will be the correct sorted num  
		pivot = partition(pivot, a, low, high);

		if (pivot > k) //too big!
			return select(a, k, low, pivot - 1);
		if (pivot < k) //too small!
			return select(a, k, pivot + 1, high);
		else
			return a[k];
	}
	public static int select(int[] a, int k) {
		return select(a, k, 0, a.length - 1);
	}
}