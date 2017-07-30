package application.reader;


import application.entity.UnknownWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.*;

public interface Reader {

    default List<UnknownWord> read(String file) throws IOException {
        if (file == null || file.isEmpty())
            return emptyList();

        List<UnknownWord> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Scanner scanner;
        int index = 0;
        while ((line = reader.readLine()) != null) {
            UnknownWord word = new UnknownWord();
            scanner = new Scanner(line);
            scanner.useDelimiter("\\t"); // tab symbol
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0) word.setWord(data);
                else if (index == 1) word.setTranscription(data);
                else if (index == 2) word.setTranslate(data);
                else if (index == 3) word.setWithPrefix(data);
                index++;
            }
            index = 0;
            words.add(word);
        }
        return words;
    }
}
