package ss8_clean_code_refactoring.thuc_hanh.doi_ten_bien_va_tach_hang;


public class Calculator {
    public static int calculate(int firstOperand, int secondOperand, char operator) {
        switch (operator) {
            case Operator.ADDITION:
                return firstOperand + secondOperand ;
            case Operator.SUBTRACTION:
                return firstOperand - secondOperand ;
            case Operator.MULTIPLICATION:
                return firstOperand * secondOperand ;
            case Operator.DIVISION:
                if (secondOperand != 0)
                    return firstOperand / secondOperand ;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
