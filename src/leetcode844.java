import java.util.ArrayDeque;

public class leetcode844 {
    public static void main(String[] args) {

        System.out.println(backspaceCompare("a##c", "#a#c"));

    }

    private static void createStack(String str, ArrayDeque<Character> stack) {
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != '#'){
                stack.addLast(str.charAt(i));
            }else if (str.charAt(i) == '#' && !stack.isEmpty()){
                stack.removeLast();
            }

        }
    }

    static boolean backspaceCompare(String s, String t){


        ArrayDeque<Character> stackS = new ArrayDeque<>();
        ArrayDeque<Character> stackT = new ArrayDeque<>();

        createStack(s, stackS);

        createStack(t, stackT);

        System.out.println(stackS);
        System.out.println(stackT);


        if (stackS.size() != stackT.size()){
            return false;
        }else{
            int i = 0;
            while (i < stackS.size()){
                if (stackS.pop() != stackT.pop()){
                    return false;
                }
            }
            return true;
        }

    }

}
