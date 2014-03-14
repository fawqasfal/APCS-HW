import java.util.*;
//why in god's name doesn't Java have type inference instead of this disgusting whale feces
public class Sort {    
    public static void main(String[] args) {   
        SortDriver.main(args);
    }

    public static <T extends Comparable<? super T>> ArrayList<T> merge(ArrayList<T> array) { 
        /*break the array in merge(), and put it back, sorted, in putItBack()*/
    	if (array.size() == 1) 
    		return array; //cant split no more
        ArrayList<T> left = new ArrayList<T>();
        ArrayList<T> right = new ArrayList<T>();
    	int middle = array.size()/ 2;
    	for (int i = 0; i < middle; i++)
    		left.add(array.get(i));
    	for (int k = middle; k < array.size(); k++)
    		right.add(array.get(k));
        //recursively split the arrays until you get to array size 1
    	left = merge(left); 
    	right = merge(right); 
        //the real meat - taking any 2 subarrays and sorting them by quick interleaving
        array = putItBack(left,right);
        //give back the sorted subarray; this returns sorted subarrays of size 1,2,4,etc. until everything is sorted
        return array;
    }
   
    private static <T extends Comparable<? super T>> ArrayList<T> putItBack(ArrayList<T> left, ArrayList<T> right) {
        //interleave 2 already sorted subarrays
        ArrayList<T> answer = new ArrayList<T>();
        int index = 0;
        while (left.size() > 0 || right.size() > 0) { //while we haven't "moved" everything from the left/right arrays to sorted arrays
            if (left.size() > 0 && right.size() > 0) { //if we still have items in both arrays to move
                if (left.get(0).compareTo(right.get(0)) <= 0) { 
                    /*if the first element in left is less than the first element in right, you can be sure that its the smallest element
                    /this is because both left and right are already themselves sorted from the previous putItBack() call in merge */
                    answer.add(left.get(0));
                    left.remove(0); 
                    index++;
                }
                else {
                    //same logic as before, just replace "left" with "right"
                    answer.add(right.get(0));
                    right.remove(0);
                    index++;
                } 
            }
            else if (left.size() > 0) {
                //if we got rid of rights, nothin but left to add
                answer.add(left.get(0));
                index++;
                left.remove(0);
            }
            else if (right.size() > 0) {
                //if we got right of lefts, nothing but right to add
                answer.add(right.get(0));
                index++;
                right.remove(0);
            }
        }
        return answer; 
    }   
}