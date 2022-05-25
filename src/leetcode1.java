import java.util.Arrays;
import java.util.HashMap;

public class leetcode1 {

    public static void main(String[] args) {
        int[] nums = {3,2,4,6};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    static int[] twoSum(int[] nums, int target) {

        //hashmap<value, index>
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        hashmap.put(nums[0], 0);

        int[] ans = new int[2];

        for(int i = 1; i < nums.length; i++){

            if(hashmap.containsKey(target - nums[i])){
                ans[0] = hashmap.get(target - nums[i]);
                ans[1] = i;
            }else {
                hashmap.put(nums[i], i);
            }

        }
        return ans;
    }

}
