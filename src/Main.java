import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String input;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            input = scanner.nextLine();
            System.out.println(calc(input));
        }
    }
    public static String calc(String input) throws Exception {
        String result;
        String[] interim = input.split(" ");
        int a, b;
        char op;
        boolean rimMode = false;
        if (interim.length != 3) { // Выражение не соответствует виду - два операнда и один оператор (+, -, /, *), выбрасываем исключение
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (!(interim[1].equals("+") || interim[1].equals("-") || interim[1].equals("*") || interim[1].equals("/"))) { // Вместо (+, -, /, *) что-то другое, выбрасываем исключение
            throw new Exception("Формат математической операции не удовлетворяет заданию - в качестве оператора можгут использоваться следующие знаки: \"(+, -, /, *\")");
        } else {
            op = interim[1].toCharArray()[0]; // сохранили валидный оператор математической операции
            try { // Если операнды целые числа и валидны, то переходим после catch
                a = Integer.parseInt(interim[0]);
                b = Integer.parseInt(interim[2]);
                if ((a > 10 || b > 10) || (a <= 0 || b <= 0)) { throw new Exception("Операнды должны быть от 1 до 10");}
            } catch (NumberFormatException e) { // если операнды не числа, проверяем на римские цифры
                a = RimDiget.decodeRim(interim[0]);
                b = RimDiget.decodeRim(interim[2]);
                rimMode = true;
            }
            if (rimMode) {
                result = calcRim(a, b, op);
            } else {
                result = calcInt(a, b, op);
            }
        }

        return result;
    }

    private static String calcInt(int a, int b, char op) {
        int result = switch (op) {
            case ('+') -> (a + b);
            case ('-') -> (a - b);
            case ('*') -> (a * b);
            case ('/') -> (a / b);
            default -> 0;
        };

        return ""+result;
    }

    private static String calcRim(int a, int b, char op) throws Exception {
        int result = switch (op) {
            case ('+') -> (a + b);
            case ('-') -> (a - b);
            case ('*') -> (a * b);
            case ('/') -> (a / b);
            default -> 0;
        };

        if (result < 1) {
            throw new Exception("Римские цифры не могут быть отрицательными и ровняться нулю");
        }
        return RimDiget.intToRimDiget(result);
    }
}