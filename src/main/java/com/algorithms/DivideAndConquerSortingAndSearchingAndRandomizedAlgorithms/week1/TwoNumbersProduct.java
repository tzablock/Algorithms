package com.algorithms.DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//algoritm according to school mult
// 111
// 111
//--------
//  111
// 1110
//11100
//-------
//12321
public class TwoNumbersProduct {
    public String product(String num1, String num2){

        return mult(parseToList(num1), parseToList(num2)).stream().map(String::valueOf).reduce((acc, i) -> acc+i).orElse("");
    }

    private List<Integer> mult(List<Integer> num1, List<Integer> num2){
        List<List<Integer>> subMultResults = recMult(num1, num2, new ArrayList<>());
        return subMultResults.stream().reduce(this::sum).orElse(Collections.emptyList());
    }

    private List<List<Integer>> recMult(List<Integer> num1, List<Integer> num2, List<List<Integer>> result) {
        if (num2.size() == 0){
            return result;
        } else {
            int lastNum = num2.get(num2.size()-1);
            num2.remove(num2.size()-1);
            result.add(
                    Stream.of(
                            num1.stream().map(i -> i*lastNum),
                            IntStream.range(0, result.size()+1).filter(i -> i != 0).map(i -> 0).boxed()
                    ).flatMap(s -> s).collect(toList()));
            return recMult(num1, num2, result);
        }
    }

    private List<Integer> parseToList(String num){
        return Arrays.stream(num.split("")).mapToInt(Integer::valueOf).boxed().collect(toList());
    }

    private List<Integer> sum(List<Integer> num1, List<Integer> num2){
        List<Integer> biggerNum = num1.size() >= num2.size() ? num1 : num2;
        List<Integer> smallerNum = num1.size() < num2.size() ? num1 : num2;
        int resLength = biggerNum.size();
        return recSum(biggerNum, smallerNum, resLength, 0);
    }
    private List<Integer> recSum(List<Integer> biggerNum, List<Integer> smallerNum, int resLength, int rest){
        if (resLength == 0){
            if(rest != 0) biggerNum.add(0, rest);
            return biggerNum;
        } else {
            int biggerNumIdx = resLength - 1;
            int smallerNumIdx = biggerNumIdx - (biggerNum.size() - smallerNum.size());
            int dig1 = biggerNum.get(biggerNumIdx);
            int dig2 = smallerNumIdx >= 0 ? smallerNum.get(smallerNumIdx): 0;
            biggerNum.remove(biggerNumIdx);
            biggerNum.add(biggerNumIdx, (dig1+dig2+rest)%10);
            return recSum(biggerNum, smallerNum, --resLength, (dig1+dig2 + rest)/10);
        }
    }
}
