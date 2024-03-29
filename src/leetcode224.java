import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode224 {

    public static void main(String[] args) {

        String s = "-1+(-4+5+2)-3";
        int ans = calculate(s);

        System.out.println(ans);

    }

    private static int calculate(String s) {

        Deque<Integer> operandStack = new ArrayDeque<>();
        Deque<Character> operatorStack = new ArrayDeque<>();

        boolean negativeOp = false;

        s = s.trim();


        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if(i == 0 && ch == '-'){
                if(s.charAt(1) == '('){
                    negativeOp = true;
                }else{
                    operandStack.push(-(s.charAt(1) - '0'));
                    i = 2;
                }

                continue;

            }

            if(ch == ' '){
                continue;
            }

            if(ch == '('){
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
            }
            else if(ch == ')'){

                while(operatorStack.peek() != '('){
                    int op2 = operandStack.pop();
                    int op1 = operandStack.pop();

                    operandStack.push(performOperation(op1, op2, operatorStack.pop()));
                }

                if(negativeOp){
                    int num = operandStack.pop();
                    operandStack.push(-num);
                    negativeOp = false;
                }

                operatorStack.pop();

            }else{
//
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    int n = s.charAt(i) - '0';
                    num = num * 10 + n;
                    i++;
                    // System.out.println(num + " ," + n);

                }
                i--;
                operandStack.push(num);
            }

            System.out.println(operandStack);
            System.out.println(operatorStack);

        }


        while(!operatorStack.isEmpty()){
            int op2 = operandStack.pop();
            int op1 = operandStack.pop();

            operandStack.push(performOperation(op1, op2, operatorStack.pop()));
        }

        while(!operandStack.isEmpty()){
            int op2 = operandStack.pop();
            int op1 = operandStack.pop();

            operandStack.push(performOperation(op1, op2, '+'));
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
