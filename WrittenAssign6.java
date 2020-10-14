public class WrittenAssign6{
	public static void main(String [] args){
		// test cases
		char[] a = {'A', 'E', 'G', 'K', 'M', 'O', 'R', 'S', 'Z'}; 
		char[] b = {'C', 'Q', 'S', 'A', 'X', 'B', 'T'}; 
		for(int i = 0; i < b.length; i ++){
			System.out.print(b[i]); 
		}
		System.out.println();

		// tests as followed
		System.out.print("Binary search results: "); 
		System.out.println(binarySearch(a, 'S')); 

		selectionSort(b); 
		System.out.print("Selection sort results: "); 
		for(int i = 0; i < b.length; i ++){
			System.out.print(b[i]); 
		}
		System.out.println();

		insertionSort(b); 
		System.out.print("Insertion sort results: "); 
		for(int i = 0; i < b.length; i ++){
			System.out.print(b[i]); 
		}
		System.out.println();

		mergesort(b,0,6); 
		System.out.print("Merge sort results: "); 
		for(int i = 0; i < b.length; i ++){
			System.out.print(b[i]); 
		}
		System.out.println();

	}

	public static int binarySearch (char[] a, char target) {
		int left = 0;
		int right = a.length - 1;
		while ( left <= right ) {
			int middle = ( left + right ) / 2;
			// System.out.println("Left:" + left + " Right:" + right + " Middle:" + middle);
			if ( a[middle] == target ) { // basic operation
				return middle;
			} else if ( target < a[middle] ) {
 				right = middle - 1;
 			} else {
 				left = middle + 1;
 			}
 		}
 		return -1; // target not found
 	}

 	public static void selectionSort (char[] a) {
 		for ( int i = a.length - 1 ; i > 0; i-- ) {
 			// i marks the last item of the unsorted region

 			// find the largest item in the unsorted region
 			int maxLoc = 0; // assume the first item is the largest

 			//int rep = 0; 

 			for ( int j = 1; j <= i; j++ ) {
 				if ( a[maxLoc] < a[j] ) { // basic operation
 					maxLoc = j;
 				}
 				//rep ++; 
 				//System.out.print(rep);
 			}

 			// swap largest item with last item of the unsorted region
 			char temp = a[maxLoc];
 			a[maxLoc] = a[i];
 			a[i] = temp;

 			/* for(int x = 0; x < a.length; x ++){
				System.out.print(a[x]); 
			}
			System.out.println(); */
 		}
	}

	public static void insertionSort (char[] a) {
 		for ( int i = 1; i < a.length; i++ ) {
 			// i marks the beginning of the unsorted region
 			char itemToInsert = a[i]; // first item of the unsorted region
 			int loc = i - 1; // loc marks the end of the sorted region

 			int rep = 0; 

 			while ( loc >= 0 ) {
 				if ( a[loc] > itemToInsert ) { // basic operation
 					a[loc+1] = a[loc];
 					loc -= 1;

 					rep ++; 

 				} else {

 					rep ++; 

 					break;
 				}
 			}
 			a[loc+1] = itemToInsert;

 			/*System.out.print(rep);

 			for(int x = 0; x < a.length; x ++){
				System.out.print(a[x]); 
			}
			System.out.println(); */

 		}
 	}

 	public static void mergesort (char[] a, int l, int r){
		if (l >= r) {
			return;
		}

		int middle = (l+r)/2;
		mergesort(a, l, middle);
		mergesort(a, middle+1, r);
		merge(a, l, middle, r);

		/*for(int x = 0; x < a.length; x ++){
				System.out.print(a[x]); 
			}
			System.out.println(); */ //delete
	}

	public static void merge (char[] a, int l, int m, int r){
		int rep = 0;

		//copy lower half of the array into b
		char[] b = new char[m-l+1];
		for ( int i = 0; i <= m-l; i++ ) {
			b[i] = a[l+i];
		}
		int i = 0, j = m+1, k = l;
		while ( i <= m-l && j <= r ) {
			if (a[j] < b[i]) {
				a[k] = a[j];
				k += 1;
				j += 1;

				rep ++;

			} else {
				a[k] = b[i];
				k += 1;
				i += 1;

				rep ++;

			}
		}
		while ( i <= m-l ) {
			a[k] = b[i];
			k += 1;
			i += 1;
		}
		while ( j <= r ) {
			a[k] = a[j];
			k += 1;
			j += 1;
		}

		//System.out.print(rep); //delete
	}

}