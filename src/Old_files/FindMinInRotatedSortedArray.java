package Old_files;

public class FindMinInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, -1, 1, 2, 3 };
		int[] arr = { 1, 2 };
		System.out.println(findMin(arr));
	}

	public static int findMin(int[] nums) {
		if (nums.length == 0)
			return -1;

		if (nums.length == 1)
			return nums[0];

		int s = 0;
		int e = nums.length - 1;
		while (s <= e) {
			int m = (s + e) / 2;
			int lm = m > 0 ? m - 1 : nums.length - 1;
			int rm = m < nums.length - 1 ? m + 1 : 0;

			if (m > 0 && m < nums.length - 1 && nums[m] < nums[rm] && nums[m] < nums[lm])
				return nums[m];

			if (nums[m] >= nums[s] && nums[m] > nums[e])
				s = m + 1;
			else
				e = m - 1;

			/*
			 * if(nums[m]<=nums[e]) { if(nums[m]<nums[s]) e = m-1; else s=m+1; }
			 */
		}
		return -1;
	}
}
