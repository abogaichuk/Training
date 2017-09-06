package application.learn;

import application.entity.UnknownWord;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.*;
import static java.util.Objects.isNull;

public class DefaultLearn implements Learn {
    private final Scanner sc = new Scanner(in);

    @Override
    public void process(List<UnknownWord> words) {
        words = setWords(words);
        long start = currentTimeMillis();
        sc.nextLine();
        UnknownWord previous = null;
        while (true) {
            UnknownWord word = getRandomWord(words);
            if (isNull(word))
                break;
            printQuestion(word);
            String input = sc.nextLine();

            if (input.contains("r") && previous != null) {
              words.add(previous);
            }

            if (input.contains("d"))
                words.remove(word);
            else if ("exit".equals(input))
                break;
            previous = word;
            printAnswer(word);
        }
        out.println("time: " + (currentTimeMillis() - start) / 1000 / 60 + " minutes");
    }

    protected void printQuestion(UnknownWord word) {
        out.println();
        out.println(word.getWord() + " ----- " + word.getTranscription());
    }

    private UnknownWord getRandomWord(List<UnknownWord> words) {
        if (words.size() == 0)
            return null;
        int random = ThreadLocalRandom.current().nextInt(0, words.size());
        return words.get(random);
    }

    protected void printAnswer(UnknownWord word) {
        String answer = "вірна відповідь: " + word.getTranslate();
        if (word.getWithPrefix() != null && !word.getWithPrefix().isEmpty())
            answer = answer + ". With prefix: "+ word.getWithPrefix();
        out.println(answer);
        out.println("----------------------------------------------");
    }

    private List<UnknownWord> setWords(List<UnknownWord> words) {
        out.println("enter from value: ");
        int from = sc.nextInt();
        out.println("enter to value: ");
        int to = sc.nextInt();
        to = to >= words.size() ? words.size() -1 : to;
        return isRightValues(from, to, words.size()) ? words.subList(from, to) : words;
    }

    private boolean isRightValues(int from, int to, int size) {
        return from >= 0 && from < to && from < size;
    }
}
