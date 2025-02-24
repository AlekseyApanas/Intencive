package src.ru.aston.apanas_ak.task2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionTest {

    @Test
    public void testArrayList() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        assertArrayEquals(new Integer[]{1}, list1.toArray());

        List<Integer> list2 = new ArrayList<>(1);
        list2.add(1);
        assertArrayEquals(new Integer[]{1}, list2.toArray());

        List<Integer> list3 = new ArrayList<>(list1);
        assertArrayEquals(new Integer[]{1}, list3.toArray());
    }

    @Test
    public void testHashMap() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("Key1", "Value1");
        assertEquals("Value1", map1.get("Key1"));

        Map<String, String> map2 = new HashMap<>(2);
        map2.put("Key2", "Value2");
        assertEquals("Value2", map2.get("Key2"));

        Map<String, String> map3 = new HashMap<>(map1);
        assertEquals("Value1", map3.get("Key1"));

    }

    @Test
    public void testTreeSet() {
        Set<Integer> treeSet1 = new TreeSet<>();
        treeSet1.add(1);
        assertTrue(!treeSet1.isEmpty());

        Set<Integer> treeSet2 = new TreeSet<>(treeSet1);
        assertEquals(1, treeSet2.size());

        Set<Integer> treeSet3 = new TreeSet<>(Comparator.naturalOrder());
        treeSet3.add(3);
        treeSet3.add(2);
        treeSet3.add(1);
        Iterator<Integer> iterator = treeSet3.iterator();
        assertEquals(1, iterator.next());

        Set<Integer> treeSet4 = new TreeSet<>(/*new SortedSet<Integer>() {}*/);

    }

    @Test
    public void testCollections() {
        List<Integer> arrayList1 = new ArrayList<>();
        Collections.addAll(arrayList1, 1, 2, 3, 4);
        assertEquals(4, arrayList1.size());

        Collections.replaceAll(arrayList1, 1, 5);
        assertEquals(arrayList1.get(0), 5);

        List<Integer> arrayList2 = new ArrayList<>(List.of(5, 6, 7, 8, 9));
        Collections.copy(arrayList2, arrayList1);
        assertEquals(arrayList2.size(), 5);

        Collections.reverse(arrayList2);
        assertEquals(arrayList2.get(0), 9);

        Collections.sort(arrayList2);
        assertEquals(arrayList2.get(0), 2);

        assertEquals(2, Collections.min(arrayList2));

        assertEquals(9, Collections.max(arrayList2));

        assertEquals(0, Collections.binarySearch(arrayList2, 2));

        assertFalse(Collections.disjoint(arrayList2, arrayList1));


    }
}
