package Prac2;

public class Stocks {
	public static void main(String[] args) {
		int[] p = { 1,2 };
		System.out.println(maxProfit2(p));
	}

	public static int maxProfit(int[] prices) {
		int bp = 0;
		int max = 0;
		if (prices == null || prices.length <= 1)
			return max;

		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[bp] >= prices[i]) {
				for (int j = i + 1; j < prices.length; j++) {
					if (prices[j] < prices[i])
						break;

					if (prices[j] - prices[i] >= max) {
						bp = i;
						max = prices[j] - prices[i];
					}
				}
			}
		}

		return max;
	}

	public static int maxProfit2(int[] prices) {
		int bp = 0;
		int max = 0;
		if (prices == null || prices.length <= 1)
			return max;

		for (int i = 1; i < prices.length; i++) {

			if (prices[i] - prices[bp] >= max) {
				// bp = i;
				max = prices[i] - prices[bp];
			}
			if(prices[bp] > prices[i])
				bp=i;
		}

		return max;
	}
}
