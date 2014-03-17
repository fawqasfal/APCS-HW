import java.util.*;
public class Quick {
	public static void main(String[] args) {
		int size = 10 + (int) (Math.random() * (100 - 10) + 1);
		int[] test = new int[size];
		for (int i = 0; i < size; i++) 
			test[i] = 10 + (int) (Math.random() * (100 - 10) + 1);
		System.out.println(medofmeds(test, 0, test.length - 1));

	}
	public static int partition(int pivot, int[] a, int low, int high) {
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
		//clusters pivot duplicates together ... dont know exactly how much of a potential speed boost this can bring vs the extra code needed?
		int rwall = wall;
		for (int j = wall; j < high; j++) {
			if (a[j] == a[high]) { 
				a[j] = a[rwall];
				a[rwall] = item;
				rwall++;
			}
		}
		int finswap = a[high];
		a[high] = a[wall];
		a[wall] = finswap; 
		//finally, swap wall and pivot value so that everything to the right of pivot will be greater than it, and everything
		//to the left will be less
		return (rwall + wall) / 2; //the pivot index has the pivot-th largest # 
	}

	private static int select(int[] a, int k, int low, int high) {
		if (low >= high)
			return a[low];
		//trying to find the kth biggest element (a.length -1  = biggest; 0 = smallest)
		int pivot = low + (int) (Math.random() * ((high - low) + 1)); //random index - this index will be the correct sorted num  
		pivot = partition(pivot, a, low, high);
		if (pivot == k)
			return a[k];
		else if (pivot > k) //too big!
			return select(a, k, low, pivot - 1);
		else //too small!
			return select(a, k, pivot + 1, high);

	}
	public static int select(int[] a, int k) {
		try {
			return select(a, k, 0, a.length - 1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("only from 0 to a.length - 1; you picked a num out of range; will return -1 arbitrarily");
			return -1;
		}
 	}

 	public static int medofmeds(int[] a, int left, int right) {
 
 		int meds = (int) Math.ceil((right - left) / 5.0);
 		for (int i = 0; i < meds; i++) {
 			int subleft = left + i * 5;
 			int subright = subleft + 4;
 			subright = subright > right ? right : subright;
 			int mednum = select(a, subleft + (subright - subleft) / 2, subleft, subright);
 			a[subleft + (subright - subleft) / 2] = a[left + i];
 			a[left + i] = mednum;
 		}
 		return select(a, meds / 2, left, left + meds - 1);
 	}

 }

 	