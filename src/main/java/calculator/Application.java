package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readCalculatorInput();

        try {
            StringCalculator calculator = new StringCalculator();
            int result = calculator.add(input);

            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readCalculatorInput() {
        String input = Console.readLine();

        if (input.startsWith("//")) {
            String numbers = Console.readLine();
            input = input + "\n" + numbers;
        }

        return input;
    }
}
