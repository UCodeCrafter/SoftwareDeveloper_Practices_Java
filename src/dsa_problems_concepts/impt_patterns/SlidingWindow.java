package dsa_problems_concepts.impt_patterns;

public class SlidingWindow {
    public static void main(String[] args) {
        int array[] = new int[]{1, 5,6,9,0,5,3,2,4,6,8,7,};
        System.out.println("Max SubArray Of size K:" + maxSubArrayOfSizeK(array, 3));


        System.out.println("Smallest Sub Array with Greater sum: "+ smallestSubArrayWithGreaterSum(array, 17));
    }



    //max sum subArray of size k
    public static int maxSubArrayOfSizeK(int arr[], int k){
       int currSum = 0;
       int maxSum = 0;

        for(int i=0; i<k; i++){
            currSum += arr[i];
        }
        maxSum = currSum;

        for(int j = k ; j < arr.length; j++){
            currSum  =  currSum + arr[j] - arr[j-k];
            maxSum = Math.max(currSum, maxSum);

        }


        return maxSum;
    }
    //Smallest Subarray With Greater Sum
    private static int  smallestSubArrayWithGreaterSum(int[] array, int sum) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {

            windowSum += array[windowEnd]; //Expand the window till greater or equal to sum


            while (windowSum >= sum){
                minLength = Math.min(minLength, windowEnd - windowStart +1);
                windowSum = windowSum  - array[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }
}
