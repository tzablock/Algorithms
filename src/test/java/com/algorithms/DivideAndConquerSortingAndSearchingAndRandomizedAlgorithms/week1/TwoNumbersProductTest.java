package com.algorithms.DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.week1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TwoNumbersProductTest {
    private TwoNumbersProduct out = new TwoNumbersProduct();
    @Test
    void productOf3141592653589793238462643383279502884197169399375105820974944592And2718281828459045235360287471352662497757247093699959574966967627ShouldReturn8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184() {
        String result = out.product("3141592653589793238462643383279502884197169399375105820974944592", "2718281828459045235360287471352662497757247093699959574966967627");
        assertThat(result).isEqualTo("8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184");
    }

    @Test
    void product2And2Is4() {
        String result = out.product("2", "2");
        assertThat(result).isEqualTo("4");
    }

    /*
    111
    111
      1
     */
    @Test
    void product111And111Is12321() {
        String result = out.product("111", "111");
        assertThat(result).isEqualTo("12321");
    }
}