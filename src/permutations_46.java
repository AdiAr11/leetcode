import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations_46 {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        List<List<Integer>> ans = permute(nums);

       System.out.println(ans);
    }

    public static List<List<Integer>> permute(ArrayList<Integer> nums) {

        List<List<Integer>> ans = permutations(nums);

        return ans;
    }

    public static List<List<Integer>> permutations (ArrayList<Integer> nums){

        if (nums.size() == 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums.get(0));
            return List.of(list);
        }


        List<List<Integer>> permutationsExcludingI = new ArrayList<>();

        for(int i = 0; i < nums.size(); i++){

            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(nums);
            int val = temp.remove(i);

//            System.out.println(temp);
            permutationsExcludingI = permutations(temp);


            for (int j = 0; j < permutationsExcludingI.size(); j++) {
                permutationsExcludingI.get(j).add(val);
            }

            System.out.println(permutationsExcludingI);

        }

        return permutationsExcludingI;
    }


}
