package LAB1.test;

import LAB1.main.Anagrams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionalityBasedTest {
    private Anagrams anagramFinder;

    @BeforeEach
    void setUp() {
        anagramFinder = new Anagrams();
    }

    // ===== CORE FUNCTIONALITY =====
    @Test
    void shouldFindAllAnagramPairs() {
        List<String> list1 = Arrays.asList("listen", "hello", "enlist");
        List<String> list2 = Arrays.asList("silent", "world", "tinsel");
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.containsAll(Arrays.asList("listen", "silent", "tinsel", "enlist")));
        assertEquals(4, result.size());
    }

    @Test
    void shouldReturnEmptyListForNoAnagrams() {
        List<String> list1 = Arrays.asList("apple", "banana");
        List<String> list2 = Arrays.asList("cherry", "date");
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    // ===== EDGE CASES =====
    @Test
    void shouldHandleIdenticalStrings() {
        List<String> list1 = Arrays.asList("aaa", "aaa", "aaa");
        List<String> list2 = Arrays.asList("aaa", "aaa");
        assertEquals(Collections.singletonList("aaa"), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void shouldHandleSubsetAnagrams() {
        List<String> list1 = Arrays.asList("abc", "def", "ghi");
        List<String> list2 = Arrays.asList("cba", "fed");
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.containsAll(Arrays.asList("abc", "cba", "def", "fed")));
        assertEquals(4, result.size());
    }

    // ===== STRING PROPERTY CHECKS =====
    @Test
    void shouldHandleCaseInsensitiveAnagrams() {
        List<String> list1 = Arrays.asList("Listen");
        List<String> list2 = Arrays.asList("silent", "listen");
        assertEquals(Arrays.asList("Listen", "silent"), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void shouldHandleSpecialCharacters() {
        List<String> list1 = Arrays.asList("#1b");
        List<String> list2 = Arrays.asList("b1#");
        assertEquals(Arrays.asList("#1b", "b1#"), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void shouldHandleWhitespaceStrings() {
        List<String> list1 = Arrays.asList(" ");
        List<String> list2 = Arrays.asList(" ");
        assertEquals(Arrays.asList(" "), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void shouldHandleUnicodeStrings() {
        List<String> list1 = Arrays.asList("café");
        List<String> list2 = Arrays.asList("éfac");
        assertEquals(Arrays.asList("café", "éfac"), anagramFinder.findAnagrams(list1, list2));
    }

    // ===== DUPLICATE HANDLING =====
    @Test
    void shouldHandleListsWithoutDuplicates() {
        assertEquals(Arrays.asList("abc", "cba"),
                anagramFinder.findAnagrams(Arrays.asList("abc"), Arrays.asList("cba")));
    }

    @Test
    void shouldHandleListsWithDuplicates() {
        List<String> list1 = Arrays.asList("abc", "bca", "abc");
        List<String> list2 = Arrays.asList("cba", "def", "bca");
        List<String> expected = Arrays.asList("abc", "cba", "bca");
        assertEquals(expected, anagramFinder.findAnagrams(list1, list2));
    }
}