package calculator;

public class StringCalculator {

    public int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        String[] numbers = split(text);

        return sum(numbers);
    }

    private String[] split(String text) {
        if (text.startsWith("//")) {
            return splitByCustomDelimiter(text);
        }

        return splitByDefaultDelimiter(text);
    }

    private String[] splitByCustomDelimiter(String text) {
        String[] parts = text.split("\n", 2);

        String delimiter = parts[0].substring(2);
        String textToParse = parts[1];

        return textToParse.split(delimiter);
    }

    private String[] splitByDefaultDelimiter(String text) {
        String delimiter = "[,:]";
        return text.split(delimiter);
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += toInt(number);
        }

        return sum;
    }

    private int toInt(String numberText) {
        try {
            int number = Integer.parseInt(numberText);

            if (number < 0) {
                throw new IllegalArgumentException("입력된 숫자 중 음수가 있습니다.");
            }

            return number;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 문자열에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
