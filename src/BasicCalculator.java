import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {

    public static void main(String[] args) {

        String s = "- (3 + (4 + 5))";
        int ans = calculate(s);

        System.out.println(ans);
    }

    public static int calculate(String s) {

        Deque<Integer> operandStack = new ArrayDeque<>();
        Deque<Character> operatorStack = new ArrayDeque<>();

        int sign = 1;

        s = s.trim();

        int i = 0;

        while(i < s.length()){

            char ch = s.charAt(i);

            if(ch == ' '){
                i++;
                continue;

            }

            if(Character.isDigit(ch)){
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    int n = s.charAt(i) - '0';
                    num = num * 10 + n;
                    i++;
                    // System.out.println(num + " ," + n);
                }
                i--;
                // number = number * (ch - '0');
                operandStack.push(num);
            }

            else if(ch == '('){
                operatorStack.push(ch);

            }else if(ch == '+'){

                if(operatorStack.isEmpty() || operatorStack.peek() == '('){
                    operatorStack.push(ch);

                }
                else{

                    int op2 = operandStack.pop();
                    int op1 = operandStack.pop();

                    operandStack.push(performOperation(op1, op2, operatorStack.pop()));
                    operatorStack.push(ch);
                }

                sign = 1;

            }else if(ch == '-'){

                if(operatorStack.isEmpty() ){
                    operatorStack.push(ch);

                }else if(operatorStack.peek() == '('){
                    int num = s.charAt(i + 1) - '0';
                    operandStack.push(-num);
                    i++;
                    continue;
                }else{

                    int op2 = operandStack.pop();
                    int op1 = operandStack.pop();

                    operandStack.push(performOperation(op1, op2, operatorStack.pop()));
                    operatorStack.push(ch);
                }

                sign = -1;

            }
            else if(ch == ')'){

                while(operatorStack.peek() != '('){
                    int op2 = operandStack.pop();
                    int op1 = operandStack.pop();

                    operandStack.push(performOperation(op1, op2, operatorStack.pop()));
                }

                operatorStack.pop();

            }

             System.out.println(operandStack);
             System.out.println(operatorStack);
            i++;

        }


        while(!operatorStack.isEmpty()){
            int op2 = operandStack.pop();
            int op1 = operandStack.pop();

            operandStack.push(performOperation(op1, op2, operatorStack.pop()));
        }

        return operandStack.peek();

    }

    private static int performOperation(int op1, int op2, char op){

        if(op == '+'){
            return op1 + op2;
        }else if(op == '-'){
            return op1 - op2;
        }else if(op == '*'){
            return op1 * op2;
        }else if(op == '/'){
            return op1 / op2;
        }

        return 0;

    }

}
