public class BinarySearchRotatedArray {
    /**
     * Searches for a target value in a rotated sorted array.
     *
     * @param arr            The rotated sorted array to search in
     * @param target         The value to search for
     * @param rotationIndex  The index at which the array is rotated
     * @return               The index of the target value if found, -1 otherwise
     */
    public int search(int[] arr, int target, int rotationIndex){
        //TODO
        /*
         * You have to check if the rotatedIndex is 0,
         * that means the array is not rotated at all or
         * the smallest index is at position 0.(remember the array is sorted)
         */


  if (arr == null || arr.length == 0) {
            return -1;
        }
        
        int n = arr.length;
        
        // If the rotation index is 0, the array is not rotated
        if (rotationIndex == 0) {
            return binarySearch(arr, 0, n - 1, target);
        }
        
        // Determine which half of the rotated array to search
        if (target >= arr[rotationIndex] && target <= arr[n - 1]) {
            return binarySearch(arr, rotationIndex, n - 1, target);
        } else {
            return binarySearch(arr, 0, rotationIndex - 1, target);
        }
             
    }

    /**
     * Performs a binary search on a sorted array within the specified range.
     *
     * @param arr     The sorted array to search in
     * @param left    The left boundary of the search range (inclusive)
     * @param right   The right boundary of the search range (inclusive)
     * @param target  The value to search for
     * @return        The index of the target value if found, -1 otherwise
     */
    private int binarySearch(int[] arr, int left, int right, int target){
        

         while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
        
    }
}


