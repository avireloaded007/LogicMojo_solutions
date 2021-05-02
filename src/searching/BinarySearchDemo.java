package searching;

public class BinarySearchDemo {
    static class ElementNotFoundException extends Exception{
        public ElementNotFoundException(String message){
            super(message);
        }
    }
    public BinarySearchDemo(){}

    private int binarySearch(int element, int low, int high, int... arr){
        if(low > high){
            return -1;
        }

        int mid = low + (high - low) / 2;
        if(arr[mid] == element){
            return mid;
        }else if(arr[mid] < element){
            return binarySearch(element, mid + 1, high, arr);
        }else{
            return binarySearch(element, 0, mid, arr);
        }
    }

    public static void main(String args[]) {
        int[] array = {1, 2, 4, 5, 11, 19, 219, 1092, 9955};
        int index = new BinarySearchDemo().binarySearch(19, 0, array.length - 1, array);
        System.out.println("Element found at index - "+index);
    }
}
