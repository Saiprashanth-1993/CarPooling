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
 * @version 1.0
 */
public class Constants {

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

    /**
     * Gallery intent request code.
     */
    public static final int GALLERY_SELECTION = 1001;

    /**
     * Catch error message.
     */
    public static final String EXCEPTION_MESSAGE = "exception";

    /**
     * Check whether click on edit ride or create ride.
     */
    public static final String CLICK_RIDE = "intent_ride";

    /**
     * Check whether click on edit ride or create ride.
     */
    public static final String NAME_NAVIGATION_DASHBOARD = "dashboard";

    /**
     * Check whether click on edit ride or create ride.
     */

    public static final String NAME_NAVIGATION_MY_PROFILE = "my_profile";

    /**
     * Check whether click on edit ride or create ride.
     */
    public static final String NAME_NAVIGATION_SETTINGS = "settings";

    /**
     * Instantiates a new constants.
     */
    private Constants() {
        //Private constructor for prevent instance.
    }

}
