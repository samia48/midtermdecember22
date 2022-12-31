package math.problems;

public class Pattern {

	public static void main(String[] args) {
		/* Read this numbers, find the pattern then implement the logic from this pattern.which will give you this output.
		 * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32............
		 *
		 *
		 */
		int i=100;
		int count=100;
		int decr = 1;
		while(i>=0) {
			System.out.print(i);
			if(i!=0) {
				System.out.print(",");
			}
			if(i==(count - decr*10)) {
				count = i;
				decr++;

			}
			i=i-decr;
		}


	}
}


