package ru.spsuace.homework2.objects.simple;

import java.util.Arrays;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * Можно пользоваться Arrays.sort(arr), эта функция сортирует входящий массив
     */
    public static int[] getMaxArraySimple(int[] array, int count) {
        if (count > array.length) {
            return null;
        }
        int[] tempArr = array;
        Arrays.sort(tempArr);
        int endOfArray = tempArr.length - 1;
        int[] finalArray = new int[count];
        for (int i = 0; i <= count - 1; i++) {
            finalArray[i] = tempArr[endOfArray];
            endOfArray -= 1;
        }
        return finalArray;
    }

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * Нельзя пользоваться Arrays.sort
     */

    public static int[] getMaxArrayHard(int[] array, int count) {
        if (count == 0) {
            return new int[0];
        }
        if (count > array.length) {
            return null;
        }
        int[] tempArr = array;
        int tmp = 0;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = tempArr[j];
                    tempArr[j] = tempArr[j + 1];
                    tempArr[j + 1] = tmp;
                }
            }
        }
        int endOfArray = tempArr.length - 1;
        int[] finalArray = new int[count];
        for (int i = 0; i <= count - 1; i++) {
            finalArray[i] = tempArr[endOfArray];
            endOfArray -= 1;
        }
        return finalArray;
    }
}
