/*
* Time: O(n)
* Space: O(n)
*/

public int climbStairs(int n) {

	int ways[] = new int[n + 1];
	ways[0] = 1;
	ways[1] = 1;

	for (int i = 2; i <= n; i++) {
		ways[i] = ways[i - 1] + ways[i - 2];
	}
	
	return ways[n];

}

                                                                               [ Unknown Command ]
^G Get Help                  ^O WriteOut                  ^R Read File                 ^Y Prev Page                 ^K Cut Text                  ^C Cur Pos

