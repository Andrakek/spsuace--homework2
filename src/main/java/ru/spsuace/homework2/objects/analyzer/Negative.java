package ru.spsuace.homework2.objects.analyzer;

//public class Negative implements TextAnalyzer {
    public class Negative extends Spam {
    private final static String[] NEGATIVE = {"=(", ":(", ":|"};

    public Negative() {
        super(NEGATIVE);
    }


   // public FilterType analyze(String text) {
     //   for (String badEm : NEGATIVE) {
       //     if (text.contains(badEm)) {
        //        return FilterType.NEGATIVE_TEXT;
         //   }
      //  }
       // return FilterType.GOOD;
//    }
}