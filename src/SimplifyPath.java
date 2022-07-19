import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String[] args) {
//        System.out.println(simplify("/home//foo/"));
        System.out.println(simplify("/a//b////c/d//././/.."));
    }

    private static String simplify(String path){
        String[] p = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for(String s : p){

            if(s.equals(".") || s.length() == 0){
                continue;

            }else if(s.equals("..") ){
                if(!stack.isEmpty()){
                    stack.removeLast();
                }

            }else{
                stack.addLast(s);
            }
        }

        StringBuilder ans = new StringBuilder();

         while(!stack.isEmpty()){
             ans.append("/").append(stack.pollFirst());
         }

         if(ans.length() == 0){
             return "/";
         }

        return ans.toString();
    }

}
