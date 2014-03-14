import java.util.*;

public class Sort {    
    public static void main(String[] args) {   
        SortDriver.main(args);
    }

    public static String[] merge(String[] array) {
    	//break it! 
    	if (array.length == 1) {
    		return array;
    	}
    	String[] left = new String[array.length / 2];
    	String[] right = new String[(int) Math.round(array.length / 2.0)];
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

    private static String[] putItBack(String[] left, String[] right) {
        String[] answer = new String[left.length + right.length];
        int index = 0;
        while (left.length > 0 || right.length > 0) {
            if (left.length > 0 && right.length > 0) {
                if (left[0].compareTo(right[0]) <= 0) {
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
}