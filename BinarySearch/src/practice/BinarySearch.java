package practice;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 5, 7, 9 };
		int target = 7;
		Integer result = binarySearch(nums, target);
		if(result == -1) {
			System.out.println("Not Found");
		}
		String answer = (result == -1) ? "Not Found" : result.toString();
		System.out.println(answer);
		
	}

	public static int binarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int midPoint = end / 2;

		while(start <= end) {
			midPoint = (start + end) / 2;
			if(target == nums[midPoint]) {
				return midPoint;
			} else if(target < nums[midPoint]) {
				end = midPoint -1;
			} else {
				start = midPoint + 1;
			}
		};
		return -1;
	}
}
