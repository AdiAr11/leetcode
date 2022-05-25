public class leetcode224 {

    public static void main(String[] args) {

        String s = "1 + 1";
        int ans = calculate(s);

        System.out.println(ans);

    }

    public static int calculate(String s) {

        StringBuilder str = new StringBuilder();
        str.append(s);

//        s.replaceAll("");

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == ' '){}
        }
        return 0;
    }

}
