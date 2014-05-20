#include <stdio.h>
#include <math.h> 
#include <stdlib.h>
#include <time.h>

void int_to_float(int arr[], float result[]) {
	while( (*(result++) = (float) *(arr++)) );
} 

void float_to_int(float arr[], int result[]) {
	while( (*(result++) = (int) *(arr++)) );
} 

void swap(float *a, float *b) {
	float c = *a;
	*a = *b; 
	*b = c;
}

void sift_down(float arr[], int siftpt, int finalpt) {
	/* given a certain node siftpt in unordered heap arr, ensure siftpt and all of it's children down to finalpt are ordered. */
	int root = siftpt;
	while (2 * root + 1 <= finalpt) {
		int child = 2 * root + 1;
		int sift = root; 
		if (arr[child] > arr[sift]) sift = child;
		//if a second child exists and is greater than the first OR greater than root, then just swap child with first/root. 
		if (child + 1 <= finalpt && arr[child + 1] > arr[sift]) sift = child + 1;  
		if (sift != root) {
			//if swap is not the root, it's the child the root is supposed to be swapping with. 
			swap(&arr[root],&arr[sift]);
			root = sift; //swap is the  new swapped child's index. continue sifting down the child to make sure the list is OK.  
		}
		else return;
	}
}

void make_heap(float arr[], int arrsize) {
	/* given an unordered array, rearrange it so that it's in the form of a complete binary max-heap, using sift-down.
		root at index 0, index i : left child = 2i + 1; right child = 2i + 2; parent = floor((i - 1) / 2) */
	int siftpt = (int) floor((arrsize - 1) / 2); //first siftpt is the last possible parent node's index. 
	while (siftpt >= 0) {
		sift_down(arr, siftpt--, arrsize - 1); //starting at siftpt and ending at the last possible index
	}
}

void heapsort_f(float arr[], int arrsize) {
	//sorts array in O(nlogn) time; in-place. 
	make_heap(arr, arrsize); //now arr is a max-heap
	int last = arrsize - 1;
	while (last > 0) { 
		/* swap largest node in heap with last node in heap, then "delete" it from heap because its at its corrected
			sorted position in the array and we dont have to consider it anymore. fix the now broken heap. */  
		swap(&arr[0], &arr[last]); //heapsize - 1 is the last index of the heap; also we just deleted an element from the heap. 
		sift_down(arr, 0, --last);
	} //heap is now 1 element, which is just the smallest element. 
}

void heapsort_i(int arr[], int arrsize) {
	float float_cpy[arrsize]; 
	int_to_float(arr,float_cpy);
	heapsort_f(float_cpy, arrsize);
	float_to_int(float_cpy, arr);
}

void gen_array(int result[], int size) {
	for (int i = 0; i < size; i++) result[i] = rand() % 100;
}

int main() {
	int size = 10;
	int test[10] = {};
	gen_array(test, size);
	for (int i = 0; i < size; i++) {
		printf("%d, ", test[i]);
	}
	printf("\n");
	heapsort_i(test, size);
	for (int i = 0; i < size; i++) {
		printf("%d, ", test[i]);
	}
	printf("\n");
	return 0;
}

