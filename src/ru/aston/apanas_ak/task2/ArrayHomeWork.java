package ru.aston.apanas_ak.task2;

import java.util.Arrays;

public class ArrayHomeWork {

    public String checkSortArray(int[] array) {
        String result = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                result = "Please, try again";
                break;
            } else if (i == array.length - 2) {
                result = "OK";
                break;
            }
        }
        return result;
    }

    public void changeFirstAndLastElement(int[] array) {
        int firstElement;
        int lastElement;
        for (int i = 0; i < array.length; i++) {
            firstElement = array[i];
            for (int i1 = array.length - 1; i1 > 0; i1--) {
                lastElement = array[i1];
                array[i] = lastElement;
                array[i1] = firstElement;
                break;
            }
            break;
        }

    }

    public int uniqueNumber(int[] array) {
        int unique;
        int index;
        int repit = 0;
        for (int i = 0; i < array.length; i++) {
            unique = array[i];
            index = i;
            for (int i1 = array.length - 1; i1 >= 0; i1--) {
                if (array[i1] == unique && index != i1) {
                    repit++;
                }
            }
            if (repit == 0) {
                return unique;
            }
            repit = 0;
        }
        throw new IllegalArgumentException("No found");
    }

    public void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    public void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }

    }
}

