import java.util.Arrays;

public class leetcode67 {

    public static void main(String[] args) {

        System.out.println(addBinary("1010", "1011"));

    }


    static String addBinary(String a, String b) {

        int carry = 0;

        int greaterLength = Math.max(a.length(), b.length());
        String[] ans = new String[greaterLength + 1];

        for (int i = 0; i < greaterLength; i++) {

            carry = 0;

            int str1NumAtI = Integer.parseInt(String.valueOf(a.charAt(i)));
            int str2NumAtI = Integer.parseInt(String.valueOf(b.charAt(i)));

            int sum = carry + str1NumAtI + str2NumAtI;

            if (sum == 3){
                ans[i] = "1";
                carry = 1;
            } else if (sum == 2) {
                carry = 1;
                ans[i] = "0";
            }else {
                ans[i] = String.valueOf(sum);
            }



        }

        if(carry == 1){
            ans[ans.length - 1] = "1";
        }

        System.out.println(ans.length);

        return Arrays.toString(ans);
    }

}
