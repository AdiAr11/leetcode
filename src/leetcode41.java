public class leetcode41 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }

    private static int firstMissingPositive(int[] nums) {

        if(nums.length == 1){
            if(nums[0] != 1){
                return 1;
            }else{
                return 2;
            }
        }

        int i = 0;
        while(i < nums.length){

            if(nums[i] <= 0){
                nums[i] = -1;
            }else if(nums[i] != i + 1){
                if(nums[i] > nums.length || nums[i] == -1){
                    nums[i] = -1;
                    i++;
                }else if(nums[i] != i + 1){
                    if(nums[i] == nums[nums[i] - 1]){ //duplicate elements
                        nums[i] = -1;
                        i++;
                    }else{
                        swap(nums, i, nums[i] - 1);
                    }
                }
            }

            if(i < nums.length && (i + 1 == nums[i] || nums[i] == -1)){
                i++;
            }

        }

        int ans = nums.length + 1;
        // System.out.println(Arrays.toString(nums));

        for(int j = 0; j < nums.length; j++){

            if(nums[j] == -1 || nums[j] != j + 1){
                ans = j + 1;
                break;
            }

        }

        return ans;

    }

    private static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
