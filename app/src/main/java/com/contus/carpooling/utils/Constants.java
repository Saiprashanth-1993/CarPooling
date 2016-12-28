/**
 * @category CarPooling
 * @package com.contus.carpooling.utils
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.utils;

/**
 * Constants variables used for the application.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.1
 */
public class Constants {
    /**
     * Instantiates a new constants.
     */
    private Constants() {
        //Private constructor for prevent instance.
    }

    /**
     * The result of google place on activity result to get company location.
     */
    public static final int REQUEST_CODE_COMPANY_LOCATION = 1;

    /**
     * The result of google place on activity result to get user from location.
     */
    public static final int REQUEST_CODE_USER_FROM_LOCATION = 2;

    /**
     * The result of google place on activity result to get user to location.
     */
    public static final int REQUEST_CODE_USER_TO_LOCATION = 3;

    /**
     * OnClick item selection type of image view.
     */
    public static final String CLICK_FRONT_IMAGE_VIEW = "front_image";

    /**
     * OnClick item selection type of image view.
     */
    public static final String CLICK_BACK_IMAGE_VIEW = "back_image";

    /**
     * OnClick on gallery or camera type.
     */
    public static final String SELECTION_TYPE = "selected_image_type";
    /**
     * Camera intent request code.
     */
    public static final int CAMERA_SELECTION = 1000;
}
