package com.algorithms.DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.sort;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
//TODO make lib that will make few iteration for some size of input and count avg from them and do the same for more and more input and than paint wykres :)
class MergeSortTest {  //In theory nlogn in big O notation
    private MergeSort out = new MergeSort();
    @Test
    void ifSortWorkForEvenNumberOfNumbers() {
        int[] arr = {5,4,1,8,7,2,6,3};
        int[] result = out.sort(arr);
        assertThat(result).contains(1, Index.atIndex(0));
        assertThat(result).contains(2,Index.atIndex(1));
        assertThat(result).contains(3,Index.atIndex(2));
        assertThat(result).contains(4,Index.atIndex(3));
        assertThat(result).contains(5,Index.atIndex(4));
        assertThat(result).contains(6,Index.atIndex(5));
        assertThat(result).contains(7,Index.atIndex(6));
        assertThat(result).contains(8,Index.atIndex(7));
    }

    @Test
    void ifSortWorkForNotEvenNumberOfNumbers() {
        int[] arr = {5,4,1,8,7,2,6,3, 10,10,9,9,8};
        int[] result = out.sort(arr);
        assertThat(result).contains(1, Index.atIndex(0));
        assertThat(result).contains(2,Index.atIndex(1));
        assertThat(result).contains(3,Index.atIndex(2));
        assertThat(result).contains(4,Index.atIndex(3));
        assertThat(result).contains(5,Index.atIndex(4));
        assertThat(result).contains(6,Index.atIndex(5));
        assertThat(result).contains(7,Index.atIndex(6));
        assertThat(result).contains(8,Index.atIndex(7));
        assertThat(result).contains(8,Index.atIndex(8));
        assertThat(result).contains(9,Index.atIndex(9));
        assertThat(result).contains(9,Index.atIndex(10));
        assertThat(result).contains(10,Index.atIndex(11));
        assertThat(result).contains(10,Index.atIndex(12));
    }

    @Test
    void checkPerformanceFor10RecordsSortedArray() {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        long start = currentTime();
        out.sort(arr);
        long stop = currentTime();
        System.out.println(String.format("%d s %d ms", (stop - start) /1000, stop - start));
    }

    @Test
    void checkPerformanceFor10RecordsUnsortedArray() {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        long start = currentTime();
        out.sort(arr);
        long stop = currentTime();
        System.out.println(String.format("%d s %d ms", (stop - start) /1000, stop - start));
    }

    @Test
    void checkPerformanceFor10000RecordsSortedArray() {
        int[] arr = IntStream.range(0,10000).toArray();
        long start = currentTime();
        out.sort(arr);
        long stop = currentTime();
        System.out.println(String.format("%d s %d ms", (stop - start) /1000, stop - start));
    }

    @Test
    void checkPerformanceFor10000RecordsUnsortedArray() {
        int[] arr = IntStream.iterate(10000, i -> i-1).limit(10000).toArray();
        long start = currentTime();
        out.sort(arr);
        long stop = currentTime();
        System.out.println(String.format("%d s %d ms", (stop - start) /1000, stop - start));
    }

    private long currentTime(){
        return System.currentTimeMillis();
    }
}