import java.util.*;

public class leetcode1679 {

    public static void main(String[] args) {
//        maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3);
//        maxOperations(new int[]{3,1,3,4,3}, 6);
        maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3);
    }

    private static int maxOperations(int[] nums, int k){

        Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).boxed().toList();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int pointer = 0;

        ArrayList<Integer> distinctElementsInArr = new ArrayList<>();

        while (pointer < list.size()){

            int frequencyOfElement = Collections.frequency(list, list.get(pointer));
            hashMap.put(list.get(pointer), frequencyOfElement);
            distinctElementsInArr.add(list.get(pointer));
            pointer += frequencyOfElement;

        }
        int result = 0;

        System.out.println(distinctElementsInArr);
        System.out.println(hashMap);

        boolean isKEven = (k & 1) == 0;

        for (int i = 0; i < distinctElementsInArr.size(); i++) {

            int n = distinctElementsInArr.get(i);
            if(n > k){
                break;
            }

            if (isKEven && n == k / 2){
                int val = hashMap.get(n) / 2;
                result += val;
                hashMap.put(n, hashMap.get(n) - val);
            }else{
                if (hashMap.containsKey(k - n)){
                    int val;
                    if (hashMap.get(n) < hashMap.get(k-n)){
                        val = hashMap.get(n);
                        hashMap.put(n, 0);
                        hashMap.put(k-n, hashMap.get(k-n) - val);
                    }else {
                        val = hashMap.get(k-n);
                        hashMap.put(k-n, 0);
                        hashMap.put(n, hashMap.get(n) - val);
                    }
                    result += val;
                    System.out.println(n + "->" + Math.min(hashMap.get(n), hashMap.get(k-n)));
                }
            }

        }
        System.out.println(result);
        return result;

    }

}
