package LAB1.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {

    /**
     * Given two lists of strings, return a list of all unique strings that are anagrams of each other across both lists.
     * Strings are considered anagrams if they contain the same characters in any order (case-insensitive).
     *
     * Example:
     * list1 = ["listen", "hello", "enlist"]
     * list2 = ["silent", "world", "tinsel"]
     * Output: ["listen", "enlist", "silent", "tinsel"]
     *
     * The result should contain the matching strings from both lists, preserving their original casing and order.
     */
    public static List<String> findAnagrams(List<String> list1, List<String> list2) {
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException("Input lists must not be null.");
        }

        List<String> output = new ArrayList<>();
        List<String> lowerCaseOutput = new ArrayList<>(); // To track case-insensitive duplicates

        for (String word1 : list1) {
            for (String word2 : list2) {
                if (isAnagram(word1, word2)) {
                    String lowerWord1 = word1.toLowerCase();
                    String lowerWord2 = word2.toLowerCase();

                    // Add word1 if not already in output (case-insensitive)
                    if (!lowerCaseOutput.contains(lowerWord1)) {
                        output.add(word1);
                        lowerCaseOutput.add(lowerWord1);
                    }

                    // Add word2 if not already in output (case-insensitive)
                    if (!lowerCaseOutput.contains(lowerWord2)) {
                        output.add(word2);
                        lowerCaseOutput.add(lowerWord2);
                    }
                }
            }
        }

        return output;
    }

    /**
     * Determines if two given strings are anagrams of each other.
     * Two strings are considered anagrams if they contain the same characters in any order,
     * ignoring case sensitivity.
     *
     * Example:
     * str1 = "listen", str2 = "silent" → true
     * str1 = "hello", str2 = "world" → false
     * str1 = "123", str2 = "321" → true
     *
     * The comparison is case-insensitive, meaning "Listen" and "Silent" are also considered anagrams.
     *
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return true if the strings are anagrams, false otherwise
     */
    private static boolean isAnagram(String str1, String str2) {
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}

