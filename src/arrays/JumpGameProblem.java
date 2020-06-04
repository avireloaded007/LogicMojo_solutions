package arrays;

public class JumpGameProblem {
    public static int miniumJumps(int array[]){
        if(array.length < 1){
            return 0;
        }

        int a = array[0], jumps = 0;
        int max = 0;
        for(int i = 0; i < array.length; i++){
            if(i == array.length - 1){
                return jumps;
            }
            if(array[i] == 0){
                return -1;
            }

            a--;
            max = Math.max(max, array[i]);
            if(a == 0){
                a = max;
                jumps++;
            }

        }

        return jumps;
    }

    public static void main(String args[]){
        int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int minimumJumps = miniumJumps(array);
        System.out.println("Minimum Jumps Required to reach the end of the array -"+minimumJumps);
    }
}
