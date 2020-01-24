package com.udemy.seleniumdesign.test.decorator;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.decorator.PaymentScreenPage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static com.udemy.seleniumdesign.test.decorator.PaymentDecorators.*;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreenPage paymentScreenPage;

    @BeforeTest
    public void setPaymentScreenPage(){
        this.paymentScreenPage = new PaymentScreenPage(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentScreenTest(Consumer<PaymentScreenPage> consumer) {
        paymentScreenPage.goTo();
        consumer.accept(paymentScreenPage);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                validCC.andThen(buy).andThen(successfulPurchase),
                freeCoupon.andThen(buy).andThen(successfulPurchase),
                discountedCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase),
                invalidCC.andThen(buy).andThen(failedPurchase),
                invalidCC.andThen(discountedCoupon).andThen(buy).andThen(failedPurchase),
                buy.andThen(failedPurchase)
        };
    }

}
