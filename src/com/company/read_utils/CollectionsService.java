package com.company.read_utils;

import java.util.*;
import java.io.*;

public class CollectionsService implements WorkWithTxtFiles {
    protected String filePath;


    public CollectionsService(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    Set<String> fileText = new HashSet<String>();

    protected String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<String> getFileText() {
        return fileText;
    }

    @Override
    public HashSet<String> splitStringToWords(String string) {
        HashSet<String> stringSet = new HashSet<>();

        string = string.toLowerCase();
        string = string.replaceAll("\\W", " ");


        for (String retval : string.split("\\s+")) {
            stringSet.add(retval);
        }

        return stringSet;
    }

    @Override
    public void readFromFile(String fileName) { //read text from file with removing all puncts
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = br.readLine()) != null) {
                this.text = text.concat(s);

            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }


    }

    @Override
    public Map<String, Long> countWordRepeats() {
        Map<String, Long> map = new HashMap<>();
        HashSet<String> stringSet;
        String text2 = getText();
        stringSet = splitStringToWords(text2);

        for (String strInfori : stringSet) {
            if (map.containsKey(strInfori)){
                map.put(strInfori, map.get(strInfori));
            }
            else{
                map.put(strInfori, Long.valueOf(1));
            }
           // map.put(strInfori, map.containsKey(strInfori) ? Long.valueOf(map.get(strInfori) + 1) : Long.valueOf(1));


        }


        return map;
    }

    @Override
    public Set<String> getUniqueWords() {
        Set<String> set = new HashSet<>();
        Map<String, Long> map;
        map = countWordRepeats();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                set.add(entry.getKey());
            }

        }
        return set;
    }

    @Override
    public List<String> sortList(Comparator<String> comparator) {
        List<String> list;
        Set<String> set;
        set = getUniqueWords();
        list = new ArrayList<>(set);
        list.sort(comparator);
        return list;
    }

    @Override
    public void printMap(Map<String, Long> map) {
        System.out.println("List of words with number of repeats");
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " - " + m.getValue() + " times");
        }
    }

    @Override
    public void printSet(Set<String> set) {
        for (String s : set) {
            System.out.println(s);
        }
    }

    @Override
    public void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

}
