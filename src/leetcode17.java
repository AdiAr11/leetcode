import java.util.ArrayList;
import java.util.List;

public class leetcode17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static List<String> letterCombinations(String digits) {

        if (digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> ans;
        ans = combinations(digits);
        return ans;

    }

    static List<String> combinations(String digits){

        if(digits.length() == 1){
            List<String> list = switch (String.valueOf(digits.charAt(0))) {
                case "2" -> List.of("a", "b", "c");
                case "3" -> List.of("d", "e", "f");
                case "4" -> List.of("g", "h", "i");
                case "5" -> List.of("j", "k", "l");
                case "6" -> List.of("m", "n", "o");
                case "7" -> List.of("p", "q", "r", "s");
                case "8" -> List.of("t","u", "v");
                case "9" -> List.of("w","x", "y", "z");
                default -> new ArrayList<>(3);
            };
            return list;
        }


        List<String> lastDigit = combinations(String.valueOf(digits.charAt(digits.length() - 1)));
        List<String> otherDigits = combinations(digits.substring(0, digits.length() - 1));
        
        List<String> combos = new ArrayList<>();
        for (String str : otherDigits) {
            for (String s : lastDigit){
                combos.add(str + s);
            }
        }

        return combos;
    }

}
