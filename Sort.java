import java.util.Arrays;
public class Sort  {

//============================================================================================================================
    public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length -1; i++){
			int index = i;
			for(int j = i+1; j < arr.length;j++){
				if(arr[j] < arr[index]){
					index = j; //searching for lowest index
				}
			}
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
            System.out.println(arr[i] + " swapped with " + arr[index]);
            System.out.println(Arrays.toString(arr));
            System.out.println("\n");
		}
    }

//============================================================================================================================
    public static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            System.out.println("k = " + key);
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                System.out.println(arr[j] + " > " + key + "? YES, SWAP");
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
            System.out.println("\n");
        }
    }

    //============================================================================================================================

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r)
	{
		if (l < r) {
			// Find the middle point
			int m =l+ (r-l)/2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}
	int binarySearch(int arr[], int l, int r, int x)
{
    if (r >= l) {
        int mid = l + (r - l) / 2;
  
        // If the element is present at the middle
        // itself
        if (arr[mid] == x)
            return mid;
  
        // If element is smaller than mid, then
        // it can only be present in left subarray
        if (arr[mid] > x)
            return binarySearch(arr, l, mid - 1, x);
  
        // Else the element can only be present
        // in right subarray
        return binarySearch(arr, mid + 1, r, x);
    }
  
    // We reach here when element is not
    // present in array
    return -1;
}

public static void d(double x){
	System.out.println(x);
}

//============================================================================================================================

    public static void main(String a[]){

		d(5);

        /*
        [5] [1] [12] [-5] [16] [2] [12] [14]  -> original unsorted array

        [-5] [1] [12] [5] [16] [2] [12] [14]  -> swaps -5 with 5
        ^              ^
        [5] [1] [12] [-5] [16] [2] [12] [14]  -> 1 stays there
             ^
        [-5] [1] [2] [5] [16] [12] [12] [14]  -> swaps 12 with 2
                  ^            ^    
        [-5] [1] [2] [5] [16] [12] [12] [14]  -> 5 stays there
                      ^
        [-5] [1] [2] [5] [12] [16] [12] [14]  -> swaps 16 with 12
                          ^     ^
        [-5] [1] [2] [5] [12] [12] [16] [14]  ->swaps 16 with 12
                               ^     ^
        [-5] [1] [2] [5] [12] [12] [14] [16]  -> swaps 16 with 14
		        	                ^    ^
        [-5] [1] [2] [5] [12] [12] [14] [16]  -> Final sorted array
		*/

        System.out.println("SELECTION SORT\n");
	    //int arr1[] = {5,1,12,-5,16,2,12,14};
		int arr1[] = {5,7,1,8,2,4,3};
        selectionSort(arr1);
        System.out.println("\n");

		/*
    	0  1  2  3  4  5
		[5][8][1][3][9][6] k = 5 already sorted (sorted: all items to the left are smaller)
	 	 ^	
		[5][8][1][3][9][6] k = 8 -> k < 5? -> no, so 8 stays there
		    ^
		[5][8][1][3][9][6] k = 1 -> k < 8? -> yes, swap 1 and 8 :: k < 5? yes, swap 1 and 5
	    	   ^
		[1][5][8][3][9][6] k = 3 -> k < 8? -> yes, swap 3 and 8 :: k < 5? yes, swap 3 and 5 :: k < 5? no, so 3 stays there.
			   ^
		[1][3][5][8][9][6] k = 9 -> k < 8? -> no, 9 stays there.
		       ^
		[1][3][5][8][9][6] k = 6 -> k < 9? -> yes, swap 6 and 9 :: k < 8? yes, swap 6 and 8 :: k < 5? no, so 6 stays there.
				^
		[1][3][5][6][8][9] array is sorted.
    	*/
        System.out.println("INSERTION SORT\n");
        int arr2[] = {5,7,1,8,2,4,3} ;
        insertionSort(arr2);
        System.out.println("\n");
    }
}