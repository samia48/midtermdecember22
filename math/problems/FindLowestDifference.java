package math.problems;

import java.util.Arrays;

public class FindLowestDifference {
    //public static void main(String[] args) {
        /*
         Implement in java.
         Read this below two array. Find the lowest difference between the two array cell.
         The lowest difference between cells is 1
        */

    static int FindLowestDifference(int[] array1, int[] array2, int m, int n) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        int i = 0;
        int j = 0;

        int diff = Integer.MAX_VALUE;


        while (i < m && j < n) {
            if (Math.abs(array1[i] - array2[j]) < diff)
                diff = Math.abs(array1[i] - array2[j]);


            if (array1[i] < array2[j])
                i++;

            else
                j++;
        }


        return diff;
    }

    public static void main(String[] args) {
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19};

        int m = array1.length;
        int n = array2.length;

        System.out.println( FindLowestDifference(array1, array2, m, n));

    }


}




