public class ImportantProblem {
    /* Important Problems of any Topics */

    /* Binary Search */
    public static int binSearch(int arr[], int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        System.out.println("hello World");
        // binary search
        int arr[] = { 1, 3, 5, 5, 6, 9 };
        int key = 5;
        System.out.println(binSearch(arr, key));
    }
}