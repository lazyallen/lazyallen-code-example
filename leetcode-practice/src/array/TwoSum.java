package array;

import java.util.HashMap;

/**
 * @author allen
 * @Date 2019-10-29
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
		System.out.println(twoSum(nums,target)[0]);
		System.out.println(twoSum(nums,target)[1]);

	}

	static int[] twoSum(int[] nums, int target){
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		for (int i = 0;i<nums.length;i++) {
			if(hashMap.containsKey(nums[i])){
				return new int[]{hashMap.get(nums[i]),i};
			}
			hashMap.put(target - nums[i],i);
		}
		return new int[]{-1,-1};
	}
}
