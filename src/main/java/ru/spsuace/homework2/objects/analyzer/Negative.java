package ru.spsuace.homework2.objects.analyzer;

public class Negative implements TextAnalyzer {
    private final static String[] negative = {"=(", ":(", ":|"};

    public FilterType analyze(String text) {
        for (String badEm : negative) {
            if (text.contains(badEm)) {
                return FilterType.NEGATIVE_TEXT;
            }
        }
        return FilterType.GOOD;
    }
}