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
//
//
//

package com.wirecard.hybris.core.service;

import com.wirecard.hybris.core.data.types.Payment;
import com.wirecard.hybris.core.model.WirecardAuthenticationModel;
import com.wirecard.hybris.exception.WirecardPaymenException;

public interface PaymentCommandService {

    /**
     * This method executes a request transaction to a transaction
     *
     * @param payment
     *     the request data that should be send to payment method url
     * @param url
     *     the url where request are going to be sent
     * @return response for the operation
     * @throws WirecardPaymenException
     *     if an error occurs during process (e.g. conversion of xml, or signature check)
     */
    Payment sendRequest(Payment payment, String url, WirecardAuthenticationModel wirecardAuthenticationModel)
        throws WirecardPaymenException;

    /**
     * Executes a http request and returns the statusCode
     *
     * @param url
     *     the info about where is made the httprequest
     * @param wirecardAuthenticationModel
     *     information about the user needed for the httprequest
     * @return the code of the response of the httprequest
     */
    int sendTestAuthenticationRequest(String url, WirecardAuthenticationModel wirecardAuthenticationModel);

    /**
     * Executes an http request and returns the info
     *
     * @param url
     *     the info about where is made the httprequest
     * @param wirecardAuthenticationModel
     *     information about the user needed for the httprequest
     * @return the body of the response after a httprequest is done
     */
    String sendSearchRequest(String url, WirecardAuthenticationModel wirecardAuthenticationModel);
}
