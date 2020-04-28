package ru.spsuace.homework2.objects.analyzer;

//public abstract class Spam implements TextAnalyzer {


// @Override
// public FilterType analyze(String text) {
//     return null;
//  }

// public class Spam extends Negative {

//   private String[] spam;

// public Spam(String[] spam) {
//   this.spam = spam;
//}

//public Spam () {
//  super(Spam);

public class Spam implements TextAnalyzer {
    private final String[] spam;

    Spam(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType analyze(String text) {
        for (String badSymb : spam) {
            if (text.contains(badSymb)) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}
