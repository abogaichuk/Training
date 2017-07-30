package application.learn;

import application.entity.UnknownWord;

public class RevertLearn extends DefaultLearn {

    @Override
    protected void printQuestion(UnknownWord word) {
        System.out.println();
        System.out.println(word.getTranslate());
    }

    @Override
    protected void printAnswer(UnknownWord word) {
        String answer = "вірна відповідь: " + word.getWord() + ", транскрипція: " + word.getTranscription();
        if (word.getWithPrefix() != null && !word.getWithPrefix().isEmpty())
            answer = answer + ". With prefix: "+ word.getWithPrefix();
        System.out.println(answer);
        System.out.println("----------------------------------------------");
    }
}
