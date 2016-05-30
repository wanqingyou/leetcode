public class Solution {
    public boolean isUgly(int num) {
        int[] factors = { 2, 3, 5 };

		if (num == 0) return false;

		while (true) {
			if (num == 1)
				return true;
			else if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) return false;

			for (int n : factors) {
				if (num % n == 0) num = num / n;
			}
		}
    }
}