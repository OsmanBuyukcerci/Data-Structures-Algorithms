package Arrays;

public class Arrays {

    public void printArray(int[] arr) {
        System.out.println("");
        for (int member : arr) {
            System.out.print(member + " ");
        }
    }

    public int[] removeEven(int[] arr) {
        int n = arr.length;
        int oddCounter = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0)
                oddCounter++;
        }

        int[] result = new int[oddCounter];

        for (int i = 0, k = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                result[k] = arr[i];
                k++;
            }

        }
        return result;
    }

    /*
     * public int[] reverseArray(int[] arr) {
     * int n = arr.length;
     * int[] result = new int[n];
     * for (int i = n - 1, idx = 0; i >= 0; i--) {
     * result[idx] = arr[i];
     * idx++;
     * }
     * return result;
     * }
     */

    public int[] reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int min = arr[0];

        for (int i = 1; i < arr.length; i++)
            if (arr[i] < min)
                min = arr[i];
        return min;
    }

    /*
     * public int secondMax(int[] arr) {
     * int max = arr[0];
     * int secondMax = arr[0];
     * 
     * for (int i = 1; i < arr.length; i++) {
     * if (arr[i] > max)
     * max = arr[i];
     * }
     * 
     * for (int i = 0; i < arr.length; i++) {
     * for (int j = 0; j < arr.length; j++) {
     * if (arr[i] != max && arr[i] > secondMax)
     * secondMax = arr[i];
     * }
     * }
     * 
     * return secondMax;
     * }
     */

    public int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public int[] moveZeros(int[] arr) {
        int n = arr.length;

        for (int i = 0, j = 0; i < n; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            if (arr[j] != 0)
                j++;
        }

        return arr;
    }

    public int[] resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    public int findMissing(int[] arr, int n) { // ***
        int sum = (n * (n + 1)) / 2;
        for (int i : arr) {
            sum -= i;
        }
        return sum;
    }

    public boolean isStringPalindrome(String str) {
        char[] arrOfStr = str.toCharArray();

        for (int i = 0, j = arrOfStr.length - 1; i < j; i++, j--) {
            if (arrOfStr[i] != arrOfStr[j]) {
                return false;
            }
        }

        return true;
    }
}