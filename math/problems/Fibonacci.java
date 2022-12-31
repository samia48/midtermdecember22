package math.problems;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
          0,1,1,2,3,5,8,13
         */
        int NFibonacci = 40;
        int previousNum = 0;
        int nextNum = 1;

        System.out.print("Fibonacci of " + NFibonacci + " numbers:");

        for (int i = 1; i <= NFibonacci; ++i) {
            System.out.print(previousNum + " ");
            int sum = previousNum + nextNum;
            previousNum = nextNum;
            nextNum = sum;
        }
    }
}




