package arrays;

public class JumpGameProblem {
    public static int miniumJumps(int nums[]){
        if(nums.length <= 1){
            return 0;
        }
        int a = nums[0], jumps = 1;
        int b = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i == nums.length - 1){
                return jumps;
            }

            b = Math.max(b, i + nums[i]);

            a--;
            if(a == 0){
                jumps++;
                if(i >= b){
                    return -1;
                }

                a = b - i;
            }
        }

        return jumps;
    }

    public static void main(String args[]){
        int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int minimumJumps = miniumJumps(array);
        System.out.println("Minimum Jumps Required to reach the end of the array - "+minimumJumps);
    }
}
