package application;

import application.entity.UnknownWord;
import application.learn.DefaultLearn;
import application.learn.RevertLearn;
import application.reader.Reader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main implements Reader {
    private static final String UNKNOWN_WORDS_PATH = "unknown_words.tsv";
    private static final String PREFIXES_PATH = "prefixes.tsv";


    public static void main(String[] args) throws IOException {
        //SpringApplication.run(Main.class, args);
        while (true)
            start(new Main().read(UNKNOWN_WORDS_PATH));
    }

    private static void start(final List<UnknownWord> words) {
        System.out.println("words size: " + words.size() + ", press 'r' to revert lesson");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if ("r".equals(input))
            new RevertLearn().process(new ArrayList<>(words));
        else
            new DefaultLearn().process(new ArrayList<>(words));
    }
}
