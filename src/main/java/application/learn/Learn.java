package application.learn;

import application.entity.UnknownWord;

import java.util.List;

public interface Learn {
    void process(List<UnknownWord> words);
}
