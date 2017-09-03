package edu.bionic.testdata;

import com.google.common.collect.Lists;
import edu.bionic.domain.Color;
import edu.bionic.domain.Operation;

import java.math.BigDecimal;
import java.util.List;

public class ProductFactory {

    public static Operation getProduct1() {
        return new Operation(
                1,
                "iPhone 6",
                BigDecimal.valueOf(650),
                Color.BLACK,
                64,
                "4,7 inch",
                null
        );
    }

    public static Operation getProduct2() {
        return new Operation(
                2,
                "iPhone 7",
                BigDecimal.valueOf(700),
                Color.WHITE,
                128,
                "4,7 inch",
                null
        );
    }

    public static Operation getProduct3() {
        return new Operation(
                3,
                "iPhone 8",
                BigDecimal.valueOf(750),
                Color.GRAY,
                256,
                "4,7 inch",
                null
        );
    }

    public static Operation getProduct4() {
        return new Operation(
                4,
                "iPhone 6 Plus",
                BigDecimal.valueOf(700),
                Color.BLACK,
                256,
                "5,5 inch",
                null
        );
    }

    public static Operation getProduct5() {
        return new Operation(
                5,
                "iPhone 7 Plus",
                BigDecimal.valueOf(800),
                Color.GRAY,
                64,
                "5,5 inch",
                null
        );
    }

    public static Operation getProduct6() {
        return new Operation(
                6,
                "iPhone 8 Plus",
                BigDecimal.valueOf(900),
                Color.WHITE,
                128,
                "5,5 inch",
                null
        );
    }

    public static List<Operation> getAllProducts() {
        return Lists.newArrayList(
                getProduct1(),
                getProduct2(),
                getProduct3(),
                getProduct4(),
                getProduct5(),
                getProduct6()
        );
    }

    public static Operation newProduct() {
        return new Operation(
                null,
                "iPhone 8",
                BigDecimal.valueOf(900),
                Color.WHITE,
                512,
                "6,0 inch",
                null
        );
    }

    public static Operation getProduct2Updated() {
        return new Operation(
                2,
                "iPhone 8",
                BigDecimal.valueOf(900),
                Color.BLACK,
                512,
                "6,0 inch",
                null
        );
    }
}
