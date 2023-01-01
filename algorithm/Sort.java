package algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sort {

    long executionTime = 0;
    /*
     * Please implement all the sorting algorithm. Feel free to add helper methods.
     * Store all the sorted data into one of the databases.
     */


    public int[] selectionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;

        for(int j=0; j<array.length-1; j++){
            int min = j;
            for(int i=j+1; i<array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public  int[]insertionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        int temp;
        //implement here
        for (int i = 1;i<array.length;i++){
            for(int j=i;j>0;j--){
                if(array[j]<array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;

                }

            }
        }




        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] bubbleSort(int [] array){
        int [] list = array;
        //implement here



        return list;
    }

    public   void merge(int arr[], int l, int m, int r)
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
            R[j] = arr[m +1 + j];

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

    public  int [] mergeSort(int [] array, int l , int r ){
        int [] list = array;
        final long startTime = System.currentTimeMillis();
        //implement here
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);

            // Merge the sorted halves
            merge(array, l, m, r);
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;


        return list;
    }

    void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            if (arr[j] < pivot)
            {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }


    public  int [] quickSort(int [] array,int length){
        int [] list = array;
        boolean b=false;
        //implement here
        final long startTime = System.currentTimeMillis();
//
        final int MAX_LEVELS = 100000;
        int i=0,L,R,pivot;
        int[] beg = new int[MAX_LEVELS], end = new int[MAX_LEVELS];
        beg[0]=0;
        end[0]=length;
        while(i>=0) {
            L=beg[i];
            R=end[i]-1;
            if(L<R) {
                pivot=array[L]; if(i==MAX_LEVELS-1)
                    b=false;
                while(L<R) {
                    while(array[R]>=pivot&&L<R) R--; if(L<R) array[L++]=array[R];
                    while(array[L]<=pivot&&L<R) L++; if(L<R) array[R--]=array[L];
                }
                array[L]=pivot;
                beg[i+1]=L+1;
                end[i+1]=end[i];
                end[i++]=L;
            } else {
                i--;
            }
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        b=true;
        return array;


        //  return list;
    }

    public int[] heapSort(int arr[])
    {
        int n = arr.length;
        final long startTime = System.currentTimeMillis();

        for (int i = n / 2 - 1; i >= 0; i--)
            sortt(arr, n, i);


        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            sortt(arr, i, 0);
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return arr;
    }
    public   int [] sortt(int [] array , int n , int i ){
        int [] list = array;
        //implement here

        {
            int largest = i; // Initialize largest as root
            int l = 2 * i + 1; // left = 2*i + 1
            int r = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (l < n && array[l] > array[largest])
                largest = l;

            // If right child is larger than largest so far
            if (r < n && array[r] > array[largest])
                largest = r;

            // If largest is not root
            if (largest != i) {
                int swap = array[i];
                array[i] = array[largest];
                array[largest] = swap;


                sortt(array, n, largest);
            }

        }





        return list;
    }


    public   int [] bucketSort(int [] array ,int n ){
        int [] list = array;
        //implement here
        // Create bucket array
        final long startTime = System.currentTimeMillis();
        List<Integer>[] buckets = new List[n];

        for(int i = 0; i < n; i++){
            buckets[i] = new LinkedList<>();
        }
        // Assign numbers from array to the proper bucket
        // by using hashing function
        for(int num : array){
            //System.out.println("hash- " + hash(num));
            buckets[hash(num,n)].add(num);
        }
        // sort buckets
        for(List<Integer> bucket : buckets){
            Collections.sort(bucket);
        }
        int i = 0;
        // Merge buckets to get sorted array
        for(List<Integer> bucket : buckets){
            for(int num : bucket){
                array[i++] = num;
            }
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

        return list;
    }
    public  int hash(int num,int n){
        return num/n;
    }
    public  int [] shellSort(int [] array){
        int [] list = array;
        //implement here
        int n = array.length;
        final long startTime = System.currentTimeMillis();

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {

            for (int i = gap; i < n; i += 1)
            {
                int temp = array[i];

                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
                    array[j] = array[j - gap];


                array[j] = temp;
            }
        }
        //return 0;

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;



        return list;
    }

    public static void printSortedArray(int [] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }


}