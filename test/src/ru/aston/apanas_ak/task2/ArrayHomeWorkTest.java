package src.ru.aston.apanas_ak.task2;

import org.junit.jupiter.api.Test;
import ru.aston.apanas_ak.task2.ArrayHomeWork;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayHomeWorkTest {
    private final ArrayHomeWork arrayHomeWork = new ArrayHomeWork();


    @Test
    public void checkSortArray() {
        int[] array = {1, 2, 3, 4, 5, 7, 6};
        assertEquals("Please, try again", arrayHomeWork.checkSortArray(array));
    }

    @Test
    public void changeFirstAndLastElement() {
        int[] array = {1, 2, 3, 4, 5, 7, 6};
        arrayHomeWork.changeFirstAndLastElement(array);
        assertEquals(6, (array[0]));
    }

    @Test
    public void uniqueNumber() {
        int[] array = {2, 2, 3, 3, 5, 5, 6, 7, 6, 6};
        assertEquals(7, arrayHomeWork.uniqueNumber(array));
    }

    @Test
    public void mergeSort() {
        int[] array = {5, 2, 7, 0, 1, 3, 7, 4};
        arrayHomeWork.mergeSort(array);
        assertEquals("OK", arrayHomeWork.checkSortArray(array));
    }

}
