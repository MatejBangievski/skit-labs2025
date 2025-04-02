package LAB1.test;

import LAB1.main.Anagrams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InterfaceBasedTest {

    public Anagrams anagramFinder;

    @BeforeEach
    void setUp() {
        anagramFinder = new Anagrams();
    }

    // ==================== PARTITION 1: LIST SIZE ====================

    // ===== INPUT VALIDATION TESTS =====
    @Test
    void testNullLists() {
        assertThrows(IllegalArgumentException.class, () -> anagramFinder.findAnagrams(null, Arrays.asList("silent")));
        assertThrows(IllegalArgumentException.class, () -> anagramFinder.findAnagrams(Arrays.asList("listen"), null));
    }

    @Test
    void testEmptyLists() {
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(Collections.emptyList(), Collections.emptyList()));
    }

    @Test
    void testEmptySecondList() {
        List<String> list1 = Arrays.asList("abc", "def");
        List<String> list2 = Collections.emptyList();
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    // ===== BASIC OPERATION TESTS =====
    @Test
    void testSingleElementLists() {
        List<String> list1 = Arrays.asList("abc");
        List<String> list2 = Arrays.asList("abc");
        assertEquals(Arrays.asList("abc"), anagramFinder.findAnagrams(list1, list2));

        List<String> list3 = Arrays.asList("abc");
        List<String> list4 = Arrays.asList("xyz");
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list3, list4));
    }

    @Test
    void testDifferentLengthStrings() {
        List<String> list1 = Arrays.asList("abc");
        List<String> list2 = Arrays.asList("abcd");
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void testMultipleElementLists() {
        List<String> list1 = Arrays.asList("apple", "banana", "grape");
        List<String> list2 = Arrays.asList("banana", "cherry", "grape");
        List<String> expected = Arrays.asList("banana", "grape");
        assertEquals(expected, anagramFinder.findAnagrams(list1, list2));
    }
}
