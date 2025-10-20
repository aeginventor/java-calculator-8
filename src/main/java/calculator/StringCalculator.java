package calculator;

public class StringCalculator {

    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String textToParse = text;

        if (text.startsWith("//")) {
            String[] parts = text.split("\n", 2);

            delimiter = parts[0].substring(2);
            textToParse = parts[1];
        }

        String[] numbers = textToParse.split(delimiter);

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
