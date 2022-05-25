import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode20 {

    public static void main(String[] args) {

        String str = "{[]}";
        System.out.println(isValid(str));

    }

    public static boolean isValid(String s) {

        Deque<Character> de_que = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            if (de_que.isEmpty()){
                de_que.addLast(s.charAt(i));
            }else {
                char topChar = de_que.getLast();

                if(topChar == '(' && s.charAt(i) == ')'){
                    de_que.removeLast();
                } else if (topChar == '[' && s.charAt(i) == ']') {
                    de_que.removeLast();
                } else if (topChar == '{' && s.charAt(i) == '}') {
                    de_que.removeLast();
                } else {
                    de_que.addLast(s.charAt(i));
                }
            }
        }
        return de_que.isEmpty();

    }

    public static boolean isValid1(String s) {

        for (int i = 0; i < s.length() - 1; i += 2) {

            if (s.charAt(i) == '(' && s.charAt(i + 1) != ')'){
                return false;
            }
            else if (s.charAt(i) == '[' && s.charAt(i + 1) != ']'){
                return false;
            }
            else if (s.charAt(i) == '{' && s.charAt(i + 1) != '}'){
                return false;
            }

        }
        return true;

    }

}
