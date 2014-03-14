import java.util.*;
//primitives are not objects fuck you java

//if i were to redo this now i'd just use comparables ... but im too lazy to touch this hideous monster
public class Sort {    
    public static void main(String[] args) {   
        SortDriver.main(args);
    }

    public static void insert(double[] array) {
    	for (int i = 1; i < array.length; i++) {
    		double thisNum = array[i];
    		int index = i; //the array is already sorted up to i already 
    		while (index > 0 && thisNum < array[index - 1]) 
    			array[index] = array[--index]; // "push" the indices back until you find the right spot for the current index
    		array[index] = thisNum;
    	}
    }
    public static void insert(long[] array) {
    	for (int i = 1; i < array.length; i++) {
    		long thisNum = array[i];
    		int index = i; //the array is already sorted up to i already 
    		while (index > 0 && thisNum < array[index - 1]) 
    			array[index] = array[--index]; // "push" the indices back until you find the right spot for the current index
    		array[index] = thisNum;
    	}
    }
    public static void insert(int[] array) {
    	for (int i = 1; i < array.length; i++) {
    		int thisNum = array[i];
    		int index = i; //the array is already sorted up to i already 
    		while (index > 0 && thisNum < array[index - 1]) 
    			array[index] = array[--index]; // "push" the indices back until you find the right spot for the current index
    		array[index] = thisNum;
    	}
    }
    public static int[] merge(int[] array) {
    	//break it! 
    	if (array.length == 1) {
    		return array;
    	}
    	int[] left = new int[array.length / 2];
    	int[] right = new int[(int) Math.round(array.length / 2.0)];
    	int middle = array.length / 2;
    	for (int i = 0; i < middle; i++)
    		left[i] = array[i];
    	for (int k = middle; k < array.length; k++)
    		right[k - middle] = array[k];
    	left = merge(left);
    	right = merge(right);
    	//merge it!
    	return putItBack(left,right);
    }
    public static double[] merge(double[] array) {
        //break it! 
        if (array.length == 1) {
            return array;
        }
        double[] left = new double[array.length / 2];
        double[] right = new double[(int) Math.round(array.length / 2.0)];
        int middle = array.length / 2;
        for (int i = 0; i < middle; i++)
            left[i] = array[i];
        for (int k = middle; k < array.length; k++)
            right[k - middle] = array[k];
        left = merge(left);
        right = merge(right);
        //merge it!
        return putItBack(left,right);
    }
    private static int[] putItBack(int[] left, int[] right) {
        int[] answer = new int[left.length + right.length];
        int index = 0;
        while (left.length > 0 || right.length > 0) {
            if (left.length > 0 && right.length > 0) {
                if (left[0] <= right[0]) {
                    answer[index] = left[0];
                    left = Arrays.copyOfRange(left, 1, left.length);
                    index++;
                }
                else {
                    answer[index] = right[0];
                    right = Arrays.copyOfRange(right, 1, right.length);
                    index++;
                } 
            }
            else if (left.length > 0) {
                answer[index] = left[0];
                index++;
                left = Arrays.copyOfRange(left, 1, left.length);
            }
            else if (right.length > 0) {
                answer[index] = right[0];
                index++;
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        return answer; 
    }
    private static double[] putItBack(double[] left, double[] right) {
        double[] answer = new double[left.length + right.length];
        int index = 0;
        while (left.length > 0 || right.length > 0) {
            if (left.length > 0 && right.length > 0) {
                if (left[0] <= right[0]) {
                    answer[index] = left[0];
                    left = Arrays.copyOfRange(left, 1, left.length);
                    index++;
                }
                else {
                    answer[index] = right[0];
                    right = Arrays.copyOfRange(right, 1, right.length);
                    index++;
                } 
            }
            else if (left.length > 0) {
                answer[index] = left[0];
                index++;
                left = Arrays.copyOfRange(left, 1, left.length);
            }
            else if (right.length > 0) {
                answer[index] = right[0];
                index++;
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        return answer; 
    }
    public static void bubble(long[] array) {
		while (!isSorted(array)) {
	    	for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
		    		long temp = array[i + 1];
		    		array[i + 1] = array[i];
		    		array[i] = temp;}}}
    }
    public static void bubble(int[] array) {
		while (!isSorted(array)) {
	    	for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
		    		int temp = array[i + 1];
		    		array[i + 1] = array[i];
		    		array[i] = temp;}}}
    }
    public static void bubble(double[] array) {
		while (!isSorted(array)) {
	    	for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
		    		double temp = array[i + 1];
		    		array[i + 1] = array[i];
		    		array[i] = temp;}}}
    }

    public static void radix(int[] array) {
    	long[] copy = new long[array.length];
    	for (int i = 0; i < array.length; i++)
    		copy[i] = array[i];
    	radix(copy);
    	for (int x = 0; x < array.length; x++)
    		array[x] = (int) copy[x];
    }
    public static void radix(double[] array) {
    	long[] copy = new long[array.length];
    	for (int a = 0; a < array.length; a++)
    		copy[a] = (long) Math.round(array[a] * Math.pow(10,5));
    	radix(copy);
    	for (int i = 0; i < array.length; i++)
    		array[i] = copy[i] / Math.pow(10,5);
    }
    public static void radix(long[] array) {
		ArrayList<Long> negs = new ArrayList<Long>();
		ArrayList<Long> pos = new ArrayList<Long>();
		for (int q = 0; q < array.length; q++)
			if (array[q] < 0) 
				negs.add(array[q]);
			else 
				pos.add(array[q]);
		Long[] negprim = new Long[negs.size()];
		Long[] posprim = new Long[pos.size()];
		negs.toArray(negprim);
		pos.toArray(posprim);
			for (int i = 1; i <= (int) Math.log(Math.abs(getMax(array))) + 1; i++) {
				copyToBuckets(negprim,i);
				copyToBuckets(posprim,i);
			}
		reversePortion(negprim,0,negprim.length - 1);
		for (int g = 0; g < array.length; g++)
			if (g <= negprim.length - 1)
				array[g] = negprim[g];
			else
				array[g] = posprim[g - negprim.length];
	}	
    private static void copyToBuckets(Long[] array, int place) {
    	String zeroes = ""; 
		ArrayList<ArrayList<Long>> twodee = new ArrayList<ArrayList<Long>>();
		for (int i = 0; i <= 9; i++)
	    	twodee.add(new ArrayList<Long>());	
		for (int g = 0; g < place - 1; g++)
			zeroes += "0"; //this will be put before the String representation of array[k], effectively making leading zeroes to prevent issues when computing a numeric place too high
		String neg = "";
		for (int k = 0; k < array.length; k++) {
			if (array[k] < 0)
				neg = "-";
			int index;
		    String kString = neg + zeroes + Long.toString(array[k]);
		    if (kString.charAt(kString.length() - place) == '-')
		    	index = 0;
		    else
		    	index = Integer.parseInt(Character.toString(kString.charAt(kString.length() - place)));
		    twodee.get(index).add(array[k]);
		    neg = "";
	    }
		int ind = 0;
		for (int r = 0; r < twodee.size(); r++)
			for (int w = 0; w < twodee.get(r).size(); w++) {
				array[ind] = twodee.get(r).get(w);
				ind++;
			}
    }
 
    private static boolean isSorted(double[] array) {
		for (int i = 1; i < array.length; i++) {
	    	if (!(array[i] >= array[i - 1])) {
				return false;
	    	}
		}
		return true;
    }
    private static boolean isSorted(long[] array) {
    	for (int i = 1; i < array.length; i++) {
	    	if (!(array[i] >= array[i - 1])) {
				return false;
	    	}
		}
		return true;
    }
    private static boolean isSorted(int[] array) {
    	for (int i = 1; i < array.length; i++) {
	    	if (!(array[i] >= array[i - 1])) {
				return false;
	    	}
		}
		return true;
    }

    private static void copy(double[] array, double[] newArray) {
		if (array.length != newArray.length)
	    	throw new IndexOutOfBoundsException();
		for (int i = 0; i < newArray.length; i++)
	    	newArray[i] = array[i];
    }
    private static void copy(Long[] array, Long[] newArray) {
    	if (array.length != newArray.length)
        	throw new IndexOutOfBoundsException();
    	for (int i = 0; i < newArray.length; i++)
        	newArray[i] = array[i];
    }

    private static void reversePortion(Long[] array, int start, int end) {
		Long[] copy = new Long[array.length];
		copy(array,copy);
		for (int i = start; i <= end; i++)
	    	array[i] = copy[end - i];
    }

    private static double getMax(double[] array) {
		if (array.length == 0)
	    	return 0;
		double maxVal = array[0];
		for (int i = 0; i < array.length; i++) {
	    	if (array[i] > maxVal)
				maxVal = array[i];
		}
		return maxVal;
    }
    private static long getMax(long[] array) {
    	if (array.length == 0)
	    	return 0;
		long maxVal = array[0];
		for (int i = 0; i < array.length; i++) {
	    	if (array[i] > maxVal)
				maxVal = array[i];
		}
		return maxVal;
    }
}