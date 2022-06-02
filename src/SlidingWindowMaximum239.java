import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum239 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindowAltSol(nums, 3)));
    }

    //O(logn) TLE
    private static int[] maxSlidingWindowAltSol(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int ansLength = nums.length - k + 1;
        int[] ans = new int[ansLength];

        int index = 0;

        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        ans[0] = maxHeap.peek();

        for (int i = k; i < nums.length; i++) {
            maxHeap.remove(nums[index]);
            maxHeap.add(nums[i]);
            ans[index + 1] = maxHeap.peek();
            index++;
        }

        return ans;
    }

}
