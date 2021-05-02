package searching;

// Maximum value in an array increasing or decreasing using Binary Search
public class MaxValueInAnArray {
    private int[] array;
    public MaxValueInAnArray(int[] arr){
        this.array = arr;
    }
    private int maxValue(int[] array, int low, int high){
        if(low == high){
            return array[low];
        }

        if(high == low + 1){
            if(array[low] > array[high]){
                return array[low];
            }else{
                return array[high];
            }
        }

        int mid = low + (high - low) / 2;
        if(array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
            return array[mid];
        }

        if(array[mid] > array[mid - 1] && array[mid] < array[mid + 1]){
            return maxValue(array, mid + 1, high);
        }else{
            return maxValue(array, low, mid);
        }
    }

    public static void main(String args[]){
        int array[] = {3, 5, 15, 50, 99, 11, 10, 8, 6};
        int n = array.length;
        MaxValueInAnArray maxVal = new MaxValueInAnArray(array);
        System.out.println("The maximum Value "+  maxVal.maxValue(array, 0, n-1));
    }
}
