package com.chaoran;

/**
 * Created by chaoranli on 5/23/17.
 */
public class FindElementInArray {

    public int contains(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            /**
             * we can not set left = mid and right = mid
             * when input array contain only one element
             * we can not step out of the while loop
             */
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public boolean containsIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / col;
            int c = mid % col;

            if (matrix[r][c] < target) {
                left = mid + 1;
            } else if (matrix[r][c] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int closetElement(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array.length == 1) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (array[mid] < target) {
                 left = mid;
            } else {
                right = mid;
            }
        }

        if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
            return left;
        } else {
            return right;
        }
    }

    public int firstOccurrenceElement(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public int firstOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        /**
         * when left == right, the algorithm step out the while loop
         * so there is only one element left
         */
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (array[left] == target) {
            return left;
        }
        return -1;
    }

    public int lastOccurenceElement(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                left = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (array[right] == target) {
            return left;
        }
        if (array[left] == target) {
            return right;
        }
        return -1;
    }

    /**
     * @param array
     * @param K
     * @param target
     * @return
     * time complexity: O(log^n)
     * space complexity: O(k);
     */
    public int[] kClosestElement(int[] array, int K, int target) {
        if (array == null || array.length == 0 || K > array.length) {
            return null;
        }

        int left = 0;
        int right = array.length - 1;
        int[] kClosest = new int[K];

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        /**
         * When left and right have not out of bound, if the distance of left to target
         * is smaller than right to target, put left index into result array. Otherwise, put right index.
         * when left index is out of bound, put right. Otherwise, put left.
         */
        for (int i = 0; i < K; i++) {
            if (right >= array.length || left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                kClosest[i] = array[left--];
            } else {
                kClosest[i] = array[right++];
            }
        }
        return kClosest;
    }
}
