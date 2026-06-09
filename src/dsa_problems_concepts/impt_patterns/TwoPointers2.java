package dsa_problems_concepts.impt_patterns;

import java.util.Arrays;

public class TwoPointers2 {
    public static void main(String[] args) {
        int arr[] = new int[] {1, 5,6,8,6,4,2,54,6,8,9,8};
        System.out.println("Find two no whose sum is given: " + Arrays.toString(twoSumSorted(arr, 14)));
    }

    public static int[] twoSumSorted(int[] nums, int target) {
        Arrays.sort(nums); // O(n log n)
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { nums[left], nums[right] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}
