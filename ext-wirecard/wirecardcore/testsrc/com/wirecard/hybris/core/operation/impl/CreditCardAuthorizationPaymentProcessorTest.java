/*
 * Shop System Plugins - Terms of Use
 *
 * The plugins offered are provided free of charge by Wirecard AG and are explicitly not part
 * of the Wirecard AG range of products and services.
 *
 * They have been tested and approved for full functionality in the standard configuration
 * (status on delivery) of the corresponding shop system. They are under MIT license
 * and can be used, developed and passed on to third parties under
 * the same terms.
 *
 * However, Wirecard AG does not provide any guarantee or accept any liability for any errors
 * occurring when used in an enhanced, customized shop system configuration.
 *
 * Operation in an enhanced, customized configuration is at your own risk and requires a
 * comprehensive test phase by the user of the plugin.
 *
 * Customers use the plugins at their own risk. Wirecard AG does not guarantee their full
 * functionality neither does Wirecard AG assume liability for any disadvantages related to
 * the use of the plugins. Additionally, Wirecard AG does not guarantee the full functionality
 * for customized shop systems or installed plugins of other vendors of plugins within the same
 * shop system.
 *
 * Customers are responsible for testing the plugin's functionality before starting productive
 * operation.
 *
 * By installing the plugin into the shop system the customer agrees to these terms of use.
 * Please do not use the plugin if you do not agree to these terms of use!
 */

package com.wirecard.hybris.core.operation.impl;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wirecard.hybris.core.data.types.CardToken;
import com.wirecard.hybris.core.data.types.Payment;
import com.wirecard.hybris.core.operation.PaymentOperationData;
import com.wirecard.hybris.exception.WirecardPaymenException;

import de.hybris.bootstrap.annotations.UnitTest;

@UnitTest
public class CreditCardAuthorizationPaymentProcessorTest {

    private CreditCardAuthorizationPaymentProcessor creditCardAuthorizationPaymentProcessor;

    @Mock
    private Payment payment;
    @Mock
    private CardToken cardToken;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        creditCardAuthorizationPaymentProcessor = new CreditCardAuthorizationPaymentProcessor();
        when(payment.getCardToken()).thenReturn(cardToken);
    }

    @Test
    public void testPaymentOperation() throws WirecardPaymenException {
        PaymentOperationData data = new PaymentOperationData();
        creditCardAuthorizationPaymentProcessor.processPayment(payment, data);
        assertEquals("Response data does not match", cardToken, payment.getCardToken());
    }
}
