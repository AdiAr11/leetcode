import java.util.ArrayDeque;
import java.util.Arrays;

public class leetcode905 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{1, 2, 3, 4})));
    }

    private static int[] sortArrayByParity(int[] nums) {

        ArrayDeque<Integer> ans = new ArrayDeque<>(nums.length);

        for (int num : nums) {
            if ((num & 1) == 0) {   //even
                ans.addFirst(num);
            } else {
                ans.addLast(num);
            }
        }

        int[] arr = new int[ans.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans.getFirst();
            ans.removeFirst();
        }

        return arr;

    }

}
