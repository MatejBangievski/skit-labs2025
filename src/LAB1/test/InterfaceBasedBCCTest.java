package LAB1.test;

import LAB1.main.Anagrams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InterfaceBasedBCCTest {
    private Anagrams anagramFinder;

    @BeforeEach
    void setUp() {
        anagramFinder = new Anagrams();
    }

    // ===== BASE TEST =====
    @Test
    void baseTest_NormalOperation() {
        List<String> list1 = Arrays.asList("listen", "state");
        List<String> list2 = Arrays.asList("silent", "taste");
        assertEquals(Arrays.asList("listen", "silent", "state", "taste"),
                anagramFinder.findAnagrams(list1, list2));
    }

    // ===== VARIATIONS FOR list1 (list2 at base choice) =====
    @Test
    void variation1_NullList1() {
        assertThrows(IllegalArgumentException.class,
                () -> anagramFinder.findAnagrams(null, Arrays.asList("silent", "taste")));
    }

    @Test
    void variation2_EmptyList1() {
        assertEquals(Collections.emptyList(),
                anagramFinder.findAnagrams(Collections.emptyList(), Arrays.asList("silent", "taste")));
    }

    @Test
    void variation3_SingleElementList1() {
        List<String> result = anagramFinder.findAnagrams(
                Arrays.asList("listen"),
                Arrays.asList("silent", "taste"));
        assertTrue(result.containsAll(Arrays.asList("listen", "silent")));
        assertEquals(2, result.size());
    }

    @Test
    void variation4_List1WithDifferentLengths() {
        assertEquals(Collections.emptyList(),
                anagramFinder.findAnagrams(Arrays.asList("a", "ab"), Arrays.asList("silent", "taste")));
    }

    // ===== VARIATIONS FOR list2 (list1 at base choice) =====
    @Test
    void variation5_NullList2() {
        assertThrows(IllegalArgumentException.class,
                () -> anagramFinder.findAnagrams(Arrays.asList("listen", "state"), null));
    }

    @Test
    void variation6_EmptyList2() {
        assertEquals(Collections.emptyList(),
                anagramFinder.findAnagrams(Arrays.asList("listen", "state"), Collections.emptyList()));
    }

    @Test
    void variation7_SingleElementList2() {
        List<String> result = anagramFinder.findAnagrams(
                Arrays.asList("listen", "state"),
                Arrays.asList("silent"));
        assertTrue(result.containsAll(Arrays.asList("listen", "silent")));
        assertEquals(2, result.size());
    }

    @Test
    void variation8_List2WithDifferentLengths() {
        assertEquals(Collections.emptyList(),
                anagramFinder.findAnagrams(Arrays.asList("listen", "state"), Arrays.asList("a", "ab")));
    }

    // ===== BOUNDARY VALUE TESTS =====
    @Test
    void boundary1_SingleCharacterStrings() {
        List<String> result = anagramFinder.findAnagrams(
                Arrays.asList("a"),
                Arrays.asList("a"));
        assertEquals(Collections.singletonList("a"), result);
    }

    @Test
    void boundary2_MaxLengthStrings() {
        // Create two different long strings that are anagrams
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // Build 1000 'a's followed by 1000 'b's
        for (int i = 0; i < 1000; i++) {
            sb1.append("a");
            sb2.append("b");
        }
        // Build 1000 'b's followed by 1000 'a's
        for (int i = 0; i < 1000; i++) {
            sb1.append("b");
            sb2.append("a");
        }

        String longStr1 = sb1.toString();
        String longStr2 = sb2.toString();

        List<String> result = anagramFinder.findAnagrams(
                Arrays.asList(longStr1),
                Arrays.asList(longStr2));

        // Verify both strings are in the result
        assertTrue(result.contains(longStr1));
        assertTrue(result.contains(longStr2));
        assertEquals(2, result.size());
    }
}