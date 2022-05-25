import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
//        System.out.println(permute(nums));
        System.out.println(containsDuplicate(nums));
    }

    static boolean containsDuplicate(int[] nums) {


        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1){
                return true;
            }
        }
        return false;
    }

//    static List<List<Integer>> permute(int[] nums) {
//
////        return permutations(Arrays.stream(nums).boxed().toList());
//
//    }


//    static List<List<Integer>> permutations (List<Integer> nums){
//
//
//
//        List<List<Integer>> lastDigit = permutations(List.of(nums.get(nums.size() - 1)));
//        nums.remove(nums.size() - 1);
//        List<List<Integer>> otherDigits = permutations(nums);
//
//
//    }

}
