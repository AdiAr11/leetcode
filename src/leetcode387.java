import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class leetcode387 {

    public static void main(String[] args) {

        String str = "aabb";
//        System.out.println(firstUniqCharBruteforce(str));
        System.out.println(str.toCharArray());
    }

    static int firstUniqChar(String s){
        HashMap<Character, Integer> charOccurence = new HashMap<>();

        char[] charsInS = s.toCharArray();

        for(char i = 0; i < charsInS.length; i++ ){
            charOccurence.put(charsInS[i], charOccurence.getOrDefault(charsInS[i], 0) + 1);
        }

        for(int i = 0; i < s.length(); i++ ){
            if(charOccurence.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    static int firstUniqCharBruteforce(String s) {

        int strlen = s.length();
//        List<Character> charsToBeSkipped = new ArrayList<>();
        HashSet<Character> charsToBeSkipped = new HashSet<>();

        for(int i = 0; i < s.length() - 1; i++){

            char ch = s.charAt(i);
            String substring = s.substring(i + 1, strlen);

            if(!charsToBeSkipped.contains(ch) && substring.indexOf(ch) == -1){
                return i;
            }else{
                charsToBeSkipped.add(ch);
            }

        }

        return -1;

    }

}
