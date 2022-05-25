import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode242 {

    public static void main(String[] args) {
        String s1 = "rat";
        String s2 = "car";
        System.out.println(isAnagram(s1, s2));
    }

     static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

         char[] str1 = s.toCharArray();
         char[] str2 = t.toCharArray();

         Arrays.sort(str1);
         Arrays.sort(str2);

         return Arrays.equals(str1, str2);
    }

    //Leetcode 49

    static List<List<String>> groupAnagrams(String[] strs) {

        String[] strings = new String[strs.length];

        for (int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            strings[i] = Arrays.toString(chars);
        }

        List<List<String>> ans = new ArrayList<>();
        
        for (int i = 0; i < strings.length; i++) {

            List<String> list = new ArrayList<>();
            list.add(strings[i]);

//            for (int j = 0; j < ; j++) {
//
//            }
            
        }
        return ans;
    }

}
