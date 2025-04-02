package LAB1.test;

import LAB1.main.Anagrams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionalityBasedBCCTest {
    private Anagrams anagramFinder;

    @BeforeEach
    void setUp() {
        anagramFinder = new Anagrams();
    }

    // ===== BASE TEST =====
    @Test
    void baseTest_NormalOperation() {
        List<String> list1 = Arrays.asList("listen", "state", "hello");
        List<String> list2 = Arrays.asList("silent", "taste", "world");
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.containsAll(Arrays.asList("listen", "silent", "state", "taste")));
        assertEquals(4, result.size());
    }

    // ===== LIST1 VARIATIONS (list2 at base) =====
    @Test
    void list1_v1_NoAnagrams() {
        List<String> list1 = Arrays.asList("apple", "banana");
        List<String> list2 = Arrays.asList("silent", "taste", "world"); // base
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void list1_v2_AllAnagrams() {
        List<String> list1 = Arrays.asList("listen", "enlist");
        List<String> list2 = Arrays.asList("silent", "taste", "world"); // base
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.containsAll(Arrays.asList("listen", "silent", "enlist")));
        assertEquals(3, result.size());
    }

    @Test
    void list1_v3_IdenticalStrings() {
        List<String> list1 = Arrays.asList("aaa", "aaa");
        List<String> list2 = Arrays.asList("silent", "taste", "world"); // base
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void list1_v4_SubsetAnagrams() {
        List<String> list1 = Arrays.asList("abc", "def");
        List<String> list2 = Arrays.asList("silent", "taste", "world"); // base
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void list1_v5_CaseInsensitive() {
        List<String> list1 = Arrays.asList("Listen", "State");
        List<String> list2 = Arrays.asList("silent", "taste", "world"); // base
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.containsAll(Arrays.asList("Listen", "silent", "State", "taste")));
        assertEquals(4, result.size());
    }

    @Test
    void list1_v6_SpecialCharacters() {
        List<String> list1 = Arrays.asList("a!b@", "b!a@");
        List<String> list2 = Arrays.asList("silent", "taste", "world"); // base
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void list1_v7_Whitespace() {
        List<String> list1 = Arrays.asList("a b c", "abc ");
        List<String> list2 = Arrays.asList("silent", "taste", "world"); // base
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void list1_v8_Unicode() {
        List<String> list1 = Arrays.asList("café", "éfac");
        List<String> list2 = Arrays.asList("silent", "taste", "world"); // base
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void list1_v9_NoDuplicates() {
        List<String> list1 = Arrays.asList("abc");
        List<String> list2 = Arrays.asList("silent", "taste", "world"); // base
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void list1_v10_WithDuplicates() {
        List<String> list1 = Arrays.asList("abc", "abc");
        List<String> list2 = Arrays.asList("silent", "taste", "world"); // base
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    // ===== LIST2 VARIATIONS (list1 at base) =====
    @Test
    void list2_v1_NoAnagrams() {
        List<String> list1 = Arrays.asList("listen", "state", "hello"); // base
        List<String> list2 = Arrays.asList("apple", "banana");
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void list2_v2_AllAnagrams() {
        List<String> list1 = Arrays.asList("listen", "state", "hello"); // base
        List<String> list2 = Arrays.asList("silent", "taste");
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.containsAll(Arrays.asList("listen", "silent", "state", "taste")));
        assertEquals(4, result.size());
    }

    @Test
    void list2_v3_IdenticalStrings() {
        List<String> list1 = Arrays.asList("listen", "state", "hello"); // base
        List<String> list2 = Arrays.asList("aaa", "aaa");
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void list2_v4_SubsetAnagrams() {
        List<String> list1 = Arrays.asList("listen", "state", "hello"); // base
        List<String> list2 = Arrays.asList("silent", "apple");
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.containsAll(Arrays.asList("listen", "silent")));
        assertEquals(2, result.size());
    }

    @Test
    void list2_v5_CaseInsensitive() {
        List<String> list1 = Arrays.asList("listen", "state", "hello"); // base
        List<String> list2 = Arrays.asList("Silent", "Taste");
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.containsAll(Arrays.asList("listen", "Silent", "state", "Taste")));
        assertEquals(4, result.size());
    }

    @Test
    void list2_v6_SpecialCharacters() {
        List<String> list1 = Arrays.asList("listen", "state", "hello"); // base
        List<String> list2 = Arrays.asList("@ba!", "d@b!");
        assertEquals(Collections.emptyList(), anagramFinder.findAnagrams(list1, list2));
    }

    @Test
    void list2_v7_Whitespace() {
        List<String> list1 = Arrays.asList("listen", "state", "hello"); // base
        List<String> list2 = Arrays.asList("t a s t e", "silent");
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.contains("silent"));
    }

    @Test
    void list2_v8_Unicode() {
        List<String> list1 = Arrays.asList("listen", "state", "hello"); // base
        List<String> list2 = Arrays.asList("facé", "taste");
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.contains("taste"));
    }

    @Test
    void list2_v9_NoDuplicates() {
        List<String> list1 = Arrays.asList("listen", "state", "hello"); // base
        List<String> list2 = Arrays.asList("silent");
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.containsAll(Arrays.asList("listen", "silent")));
        assertEquals(2, result.size());
    }

    @Test
    void list2_v10_WithDuplicates() {
        List<String> list1 = Arrays.asList("listen", "state", "hello"); // base
        List<String> list2 = Arrays.asList("silent", "silent");
        List<String> result = anagramFinder.findAnagrams(list1, list2);
        assertTrue(result.containsAll(Arrays.asList("listen", "silent")));
        assertEquals(2, result.size());
    }
}