package calculator;

public class StringCalculator {

    public int add(String text) {
        if (text == null || text.isEmpty()) {
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

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
