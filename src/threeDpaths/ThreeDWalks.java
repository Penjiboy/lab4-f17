package threeDpaths;

import java.util.Stack;

public class ThreeDWalks {

	private static Stack<Integer> countStack = new Stack<Integer>();

	/**
	 * 
	 * @param l
	 *            >= 0
	 * @param m
	 *            >= 0
	 * @param n
	 *            >= 0
	 * @return The number of paths from (0,0,0) to (l,m,n) using the rules
	 *         specified in the problem statement.
	 */
	public static long numPaths(int l, int m, int n) {

		// TODO: change this
		// You do not have to worry about overflows.
		if((m == 0) && (n==0) && ((l==0) || (l== 1) || (l==2)))
			return 1;
		if((n==0) && (l==0) && ((m == 0) || (m==1) || (m==2)))
			return 1;
		if((l==0) && (m==0) && ((n==0) || (n==1) || (n==2)))
			return 1;
		if((l== 1) && (m==1) && (n==1))
			return 0;
		if((l==2) && (m==2) && (n==3))
			return 0;
		if((l < 0) || (m < 0) || (n < 0))
			return 0;


		countStack.push(countStack.size() + 1);

		int numSteps = countStack.size() % 3;
		if(numSteps == 0)
			numSteps = 3;

		long result = numPaths(l-numSteps, m, n) + numPaths(l, m - numSteps, n) + numPaths(l,m,n - numSteps);

		while(!countStack.isEmpty()) {
			countStack.pop();
			break;
		}

		return result;

	}

	/**
	 *
	 */

}
