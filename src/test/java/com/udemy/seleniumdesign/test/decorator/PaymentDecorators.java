package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.PaymentScreenPage;
import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentDecorators {

        //actions
        public static final Consumer<PaymentScreenPage> freeCoupon = (p) -> p.applyPromocode("FREEUDEMY");
        public static final Consumer<PaymentScreenPage> discountedCoupon = (p) -> p.applyPromocode("PARTIALUDEMY");
        public static final Consumer<PaymentScreenPage> validCC = (p) -> p.enterCC("4111111111111111", "2023", "123");
        public static final Consumer<PaymentScreenPage> invalidCC = (p) -> p.enterCC("4111111111111112", "2023", "123");
        public static final Consumer<PaymentScreenPage> buy = (p) -> p.buyProduct();

        //validations
        public static final Consumer<PaymentScreenPage> successfulPurchase = (p) -> Assert.assertEquals(p.getStatus(), "PASS");
        public static final Consumer<PaymentScreenPage> failedPurchase = (p) -> Assert.assertEquals(p.getStatus(), "FAIL");

}
