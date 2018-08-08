package com.company.read_utils;

import java.util.*;

public interface WorkWithTxtFiles {

    HashSet<String> splitStringToWords(String string);

    void readFromFile(String fileName);

    Map<String, Long> countWordRepeats();

    Set<String> getUniqueWords();

    List<String> sortList(Comparator<String> comparator);

    void printMap(Map<String, Long> map);

    void printSet(Set<String> set);

    void printList(List<String> list);

}
