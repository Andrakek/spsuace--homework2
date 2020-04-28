package ru.spsuace.homework2.objects.analyzer;


public class TooLong implements TextAnalyzer {

    private final long maxLength;

    public TooLong(long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public FilterType analyze(String text) {
        if (text.length() > maxLength) {
            return FilterType.TOO_LONG;
        } else {
            return FilterType.GOOD;
        }
    }
}
