package com.company.read_utils;
import java.util.Comparator;

public class CompareStringsByLengh implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if (s1 == null) {
                return -1;
            }

            return s2 == null ? 1 : s1.length() - s2.length();
        }
    }

