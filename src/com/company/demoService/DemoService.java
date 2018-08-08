package com.company.demoService;

import com.company.read_utils.CollectionsService;
import com.company.read_utils.CompareStringsByLengh;
import com.company.read_utils.WorkWithTxtFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DemoService implements DemoServiceInt {
    @Override
    public void startDemo() {
        File file = new File("resources/gunslinger.txt");
        String fileName = file.getAbsolutePath();

         WorkWithTxtFiles workWithTxtFiles = new CollectionsService(fileName);
         workWithTxtFiles.readFromFile(fileName);

        System.out.println("CountRepeats");
        Map<String, Long> repeatWords = workWithTxtFiles.countWordRepeats();
        workWithTxtFiles.printMap(repeatWords);

        System.out.println("Unsorted Uniques ");
        Set<String> set;
        set = workWithTxtFiles.getUniqueWords();
        workWithTxtFiles.printSet(set);

        System.out.println("Sorted Uniques by word.length");
        List<String> list = new ArrayList<>(set);
        workWithTxtFiles.printList(workWithTxtFiles.sortList(new CompareStringsByLengh()));


    }
}
