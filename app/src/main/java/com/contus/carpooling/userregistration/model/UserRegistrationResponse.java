/**
 * @category Car Pooling
 * @package com.contus.carpooling.userregistration.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.userregistration.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * The model class to get the user register information from the response
 *
 * @author Contus Team <developers@contus.in>
 * @version 2.3
 */
public class UserRegistrationResponse extends ErrorResponse {

   @SerializedName(Constants.Register.USER_DETAILS)
   public UserRegistrationInfo registerAPIResponse;
}
