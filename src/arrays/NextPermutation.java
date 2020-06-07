package arrays;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

    private static int[] nextPermutation(int[] nums){
        if(nums == null || nums.length == 0)
            return nums;

        int high = nums.length - 1;
        int len = 0;
        int swap_index = 0, curr = 0;
        boolean flag = false;
        for(int i = high; i >= 0; i--){
            if(nums[i] <= nums[i-1]){
                len++;
                if(len == nums.length - 1) {
                    return reverse(nums);
                }
            }else {
                flag = true;
                swap_index = i - 1;
                curr = nums[i - 1];
                break;
            }
        }

        if(flag) {
            int smallestToRight = findSmallestOfLot(nums, curr,swap_index + 1, high);
            swap(nums, swap_index, smallestToRight);
            Arrays.sort(nums, swap_index + 1, nums.length);
        }

        return nums;
    }

    private static int[] reverse(int[] nums){
        int low = 0, high = nums.length - 1;
        int mid = high - (high - low) / 2;
        while(low < mid){
            int temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
            high --;
            low ++;
        }

        return nums;
    }

    private static int findSmallestOfLot(int[] nums, int curr, int sIdx, int eIdx){
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = sIdx; i <= eIdx; i++){
            if(min > nums[i] && nums[i] >= curr){
                min = nums[i];
                idx = i;
            }
        }
        return idx;
    }

    private static void swap(int[] nums, int sIdx, int eIdx){
        int temp = nums[sIdx];
        nums[sIdx] = nums[eIdx];
        nums[eIdx] = temp;
    }

    public static void main(String args[]){
//        int[] nums = {2, 5, 8, 7, 6, 1};
        int[] nums = {5, 4, 3, 2, 1};
//        int[] nums = {2, 1, 8, 7, 4, 5};
        nums = nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
