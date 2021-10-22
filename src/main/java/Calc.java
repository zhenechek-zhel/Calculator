import java.util.InputMismatchException;


public  class Calc extends Search{
    static int num1, num2, result;

    private static int calculated(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch ( InputMismatchException | ArithmeticException e) {
                    System.out.println("Exception : " + e);
                    break;
                }
                break;
            default:
                try {
                    throw new CalculatorException("Operator not found");
                } catch (CalculatorException e) {
                    e.printStackTrace();
                }
        }
        return result;
    }

    public static void basic() {
        String valueChar = String.valueOf(charArray);
        String[] blacks = valueChar.split("[+-/*]");


        if (blacks.length > 2) {
            try {
                throw new CalculatorException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } catch (CalculatorException e) {
                e.printStackTrace();
                return;
            }
        }
        String operand1 = blacks[0];
        String stable2 = blacks[1];
        String operand2 = stable2.trim();

        if (isNumeric(operand1) && isNumeric(operand2)) {
            num1 = Integer.parseInt(operand1);
            num2 = Integer.parseInt(operand2);
            if ((num1 <= 10 && num1 >= 1) && (num2 <= 10 && num2 >= 1)) {
                result = calculated(num1, num2, operation);
                System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
            } else {
                try {
                    throw new CalculatorException("User input inappropriate value");
                } catch (CalculatorException e) {
                    e.printStackTrace();
                }
            }
        } else {
            num1 = romanToNumber(operand1);
            num2 = romanToNumber(operand2);

            if ((num1 <= 10 && num1 >= 1) && (num2 <= 10 && num2 >= 1)) {
                result = calculated(num1, num2, operation);
                if (result < 0) {
                    try {
                        throw new CalculatorException("В римской системе нет отрицательных чисел");
                    } catch (CalculatorException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                String resultRoman = arabToRoman(result);
                System.out.println(operand1 + " " + operation + " " + operand2 + " = " + resultRoman);
            } else {
                try {
                    throw new CalculatorException("User input inappropriate value");
                } catch (CalculatorException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}


