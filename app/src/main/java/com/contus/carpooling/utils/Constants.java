/**
 * @category CarPooling
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
     * Constants API base URL
     */
    public static final String BASE_URL = "http://p105.dev.contus.us/p105-carpooling-web/public/api/";

    /**
     * To get the device token from device by using fireBase
     */
    public static final String DEVICE_TOKEN = "device_token";

    /**
     * Header type need to use that
     */
    public static final String REQUEST_TYPE_HEADER = "X-REQUEST-TYPE";

    /**
     * Constants for device token header
     */
    public static final String ACCESS_TOKEN_HEADER = "X-ACCESS-TOKEN";

    /**
     * Constants for access token header
     */
    public static final String DEVICE_TOKEN_HEADER = "X-DEVICE-TOKEN";

    /**
     * Constants for DEVICE_TOKEN_HEADER_VALUE
     */

    public static final String DEVICE_TOKEN_HEADER_VALUE = "deviceToken";

    /**
     * Constants for ACCESS_TOKEN_HEADER_VALUE
     */
    public static final String ACCESS_TOKEN_HEADER_VALUE = "acesssToken";

    /**
     * The constats for Shared Preference
     */
    public static final String DEVICE_TOKEN_PREF = "deviceTokenPref";

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
     * New ride empty seat validation.
     */
    public static final String EMPTY_SEAT = "0";

    /**
     * The Constant used to check the internet.
     */
    public static final int CHECK_INTERNET = 2000;

    /**
     * The Constant used to check the internet while the user logged in.
     */
    public static final int CHECK_INTERNET_LOGIN = 2001;

    /**
     * The Constant used to check internet and redirect to login page
     */
    public static final int CHECK_INTERNET_LOGIN_REDIRECT = 2002;

    /**
     * The Constant used to check the user logged in.
     */
    public static final int CHECK_USER_LOGIN = 2003;

    /**
     * The Constant success value.
     */
    public static final int SUCCESS_VALUE = 200;

    /**
     * The constant for get the API response Error status value
     */
    public static final int ERROR_STATUS_VALUE = 200;

    /**
     * The Constant for Email Id
     */
    public static final String USER_REG_EMAIL = "userEmail";

    /**
     * The Constant UserId
     */
    public static final String REG_USER_ID = "id";

    /**
     * Constant USER_EMAIL_ID value set from response
     */
    public static final String USER_EMAIL_ID = "email";


    /**
     * Instantiates a new constants.
     */
    private Constants() {
        //Private constructor for prevent instance.
    }

    /**
     * Constants for Login class
     */
    public static final class Login {

        /**
         * Constant  ADMIN_USER for get the Login API response and store intp adminUser model
         */
        public static final String ADMIN_USER = "adminusers";

        /**
         * Constant USER_PD value set from response
         */
        public static final String USER_PD = "password";

        /**
         * Constant LOGIN_ID value set from response
         */
        public static final String LOGIN_ID = "id";

        /**
         * Constant  USER_ROLE_ID value set from response
         */
        public static final String USER_ROLE_ID = "userRoleId";

        /**
         * Constant LOGIN_NAME value set from response
         */
        public static final String LOGIN_NAME = "name";


        /**
         * Constant USER_NAME value set from response
         */
        public static final String USER_NAME = "username";

        /**
         * Constant MOBILE value set from response
         */
        public static final String MOBILE = "mobile";


        /***
         * Constant GENDER value set from response
         */
        public static final String GENDER = "gender";

        /***
         * Constant FROM_LOCATION value set from response
         */
        public static final String FROM_LOCATION = "from_location";

        /***
         * Constant TO_LOCATION value set from response
         */
        public static final String TO_LOCATION = "to_location";

        /***
         * Constant AGE value set from response
         */
        public static final String AGE = "age";

        /***
         * Constant PROFILE_IMAGE value set from response
         */
        public static final String PROFILE_IMAGE = "profile_image";

        /***
         * Constant COMPANY_ID value set from response
         */
        public static final String COMPANY_ID = "company_id";

        /***
         * Constant COMPANY_CATEGORY_ID value set from response
         */
        public static final String COMPANY_CATEGORY_ID = "company_category_id";

        /***
         * Constant COMPANY_LOCATION value set from response
         */
        public static final String COMPANY_LOCATION = "company_location";
        /***
         * Constant DEVICE_TYPE value set from response
         */
        public static final String DEVICE_TYPE = "device_type";

        /***
         * Constant EMPLOYEE_ID value set from response
         */
        public static final String EMPLOYEE_ID = "employee_id";

        /**
         * Store the emailId for preference
         */
        public static final String USER_EMAIL_ID = "userEmailId";

        /**
         * Instantiates a new constants.
         */
        private Login() {
            //Private constructor for prevent instance.
        }
    }

    /**
     * Constants fro Register class
     */
    public static final class Register {

        /**
         * Get the USER_DETAILS response from API after register the user details
         */
        public static final String USER_DETAILS = "UserDetails";

        /**
         * Get the id from API response  after register the user details
         */
        public static final String ID = "id";

        /**
         * Constant value USER_NAME for post the name and set the error
         */
        public static final String USER_NAME = "username";

        /**
         * constant value USER_EMAIL for post the email and set the error
         */
        public static final String USER_EMAIL = "email";

        /**
         * constant value USER_MOBILE_NUMBER for register the userMobileNumber
         */
        public static final String USER_MOBILE_NUMBER = "mobile";

        /**
         * constant value USER_GENDER set from response
         */
        public static final String USER_GENDER = "gender";

        /**
         * Constant value USER_FROM_LOCATION set from response
         */
        public static final String USER_FROM_LOCATION = "from_location";

        /**
         * constant value USER_TO_LOCATION set from response
         */
        public static final String USER_TO_LOCATION = "to_location";

        /**
         * constant value  USER_REG_PD set from response
         */
        public static final String USER_REG_PD = "password";

        /**
         * Instantiates a new constants.
         */
        private Register() {
            //Private constructor for prevent instance.
        }
    }

    /**
     * Constants for get the company name and company category
     */
    public static final class CompanyList {

        /**
         * Constant value for CompanyList the COMPANY_DATA set from response
         */
        public static final String COMPANY_DATA = "data";

        /**
         * Constant value for CompanyList the COMPANY set from response
         */
        public static final String COMPANY = "company";

        /**
         * Constant value for CompanyList the CATEGORY set from response
         */
        public static final String CATEGORY = "sector";

        /**
         * Constant value for CompanyList the COMPANY_NAME_ID set from response
         */
        public static final String COMPANY_NAME_ID = "id";

        /**
         * Constant value for CompanyList the COMPANY_NAME set from response
         */
        public static final String COMPANY_NAME = "name";

        /**
         * Constant value for CompanyList the CATEGORY_ID set from response
         */
        public static final String CATEGORY_ID = "id";

        /**
         * Constant value for CompanyList the CATEGORY_NAME set from response
         */
        public static final String CATEGORY_NAME = "name";

        /**
         * Instantiates a new constants.
         */
        private CompanyList() {
            //Private constructor for prevent instance.
        }
    }

    /**
     * Constatn for company company registration
     */
    public static final class CompanyRegistration {
        /**
         * Constant value for CompanyRegistration the COMPANY_REGISTRATION_NAME
         */
        public static final String COMPANY_REGISTRATION_NAME = "name";

        /**
         * Constant value for COMPANY_CATEGORY_ID the CATEGORY_NAME
         */
        public static final String COMPANY_CATEGORY_ID = "company_category_id";

        /**
         * Constant value for COMPANY_LOCATION the CATEGORY_NAME
         */
        public static final String COMPANY_LOCATION = "company_location";

        /**
         * After complete for COMPANY_DETAILS get the response form server
         */
        public static final String COMPANY_DETAILS = "response";

        /**
         * Constant value for CompanyRegistration the COMPANY_DETAILS_ID
         */
        public static final String COMPANY_DETAILS_ID = "id";

        /**
         * Constant value for CompanyRegistration the COMPANY_NAME
         */
        public static final String COMPANY_NAME = "name";

        /**
         * Constant value for CompanyRegistration the SLUG
         */
        public static final String SLUG = "slug";

        /**
         * Instantiates a new constants.
         */
        private CompanyRegistration() {
            //Private constructor for prevent instance.
        }
    }


    /**
     * Constant for Employee Response
     */
    public static final class EmployeeResponse {

        /**
         * Constant value set for response
         */
        public static final String EMPLOYEE_DETAILS_RESPONSE = "Employee Details";

        /**
         * Constant value set for response
         */
        public static final String EMPLOYEE_ID = "id";

        /**
         * Constant value set for response
         */
        public static final String USER_ID = "user_id";

        /**
         * Constant value set for response
         */
        public static final String ADAHAR_CARD = "aadhar_card";

        /**
         * Constant value set for response
         */
        public static final String PAN_CARD = "pan_card";

        /**
         * Constant value set for response
         */
        public static final String REMEMBER_TOKEN = "rememberToken";


        /**
         * Instantiates a new constants.
         */
        private EmployeeResponse() {
            //Private constructor for prevent instance.
        }
    }

    /**
     * Constants for profile class
     */
    public static final class UserProfile {

        public static final String PROFILE_DETAILS_RESPONSE="response";

        /**
         * Constant value set from response
         */
        public static final String USERNAME="username";
        /***
         * Constant value set from response
         */
        public static final String TEAM_NAME="company_category_id";
        /**
         * Constant value set from response
         */
        public static final String USER_EMAIL_ID="email";
        /**
         * Constant value set from response
         */
        public static final String MOBILE="mobile";

        /***
         * Constant value set from response
         */
        public static final String ADDRESS="from_location";

        /***
         * Constant value set from response
         */
        public static final String USER_LOCATION="to_location";
        /***
         * Constant value set from response
         */
        public static final String PROFILE_IMAGE="profile_image";

        /***
         * Constant value set from response
         */
        public static final String VEHICLE_TYPE="to_location";

        /***
         * Constant value set from response
         */
        public static final String VEHICLE_NAME="to_location";

        /***
         * Constant value set from response
         */
        public static final String VEHICLE_NUMBER="to_location";

        /**
         * Instantiates a new constants.
         */
        private UserProfile() {
            //Private constructor for prevent instance.
        }
    }


    /**
     * Create the ride
     */
    public static final class CreateRide {
        /**
         * After create the ride get the response
         */
        public static final String CREATE_RIDE_RESPONSE = "RideDetails";

        /**
         * Constant value set for response
         */
        public static final String DEPARTURE_POINT = "departure_point";

        /**
         * Constant value set for response
         */
        public static final String ARRIVAL_POINT = "arrival_point";

        /**
         * Constant value set for response
         */
        public static final String DEPARTURE_TIME = "departure_time";

        /**
         * Constant value set for response
         */
        public static final String ARRIVAL_TIME = "arrival_time";

        /**
         * Constant value set for response
         */
        public static final String GENDER_PREFERENCE = "gender_preference";

        /**
         * Constant value set for response
         */
        public static final String DAYS_PREFERENCE = "days_preference";

        /**
         * Constant value set for response
         */
        public static final String SEATS = "seats";

        /**
         * Constant value set for response
         */

        public static final String VEHICLE_TYPE = "vehicle_type";
        /**
         * Constant value set for response
         */
        public static final String IS_EVERY_WEEEKS = "is_every_weeks";

        /**
         * Constant value set for response
         */
        public static final String TYPE = "type";

        /**
         * Constant value set for response
         */
        public static final String COST = "cost";

        /**
         * Constant value set for response
         */
        public static final String IS_ACTIVE = "is_active";

        /**
         * Instantiates a new constants.
         */
        private CreateRide() {
            //Private constructor for prevent instance.
        }
    }

    /**
     * Display the rides offered list
     */
    public static final class RidesOffered {
        /**
         * Constant value set for response
         */
        public static final String DEPARTURE_POINT = "departure_point";

        /**
         * Constant value set for response
         */
        public static final String ARRIVAL_POINT = "arrival_point";

        /**
         * Instantiates a new constants.
         */
        private RidesOffered() {
            //Private constructor for prevent instance.
        }
    }

    /**
     * Constants for api request
     */
    public static final class ApiRequest {

        /**
         * Constant value set for response
         */
        public static final String RESPONSE = "error";

        /**
         * Constant value set for error
         */
        public static final String ERROR = "error";

        /**
         * Constant value for status code
         */
        public static final String STATUS_CODE = "statuscode";

        /**
         * Constant value set for message
         */
        public static final String MESSAGE = "message";

        /**
         * Constants for user token
         */
        public static final String USER_TOKEN = "UserToken";

        /**
         * Instantiates a new constants.
         */
        private ApiRequest() {
            /**
             *  Private constructor for prevent instance.
             */
        }
    }

    /**
     * Change Password constants
     */
    public static final class ChangePassword{

        public static final String ERROR = "error";
        public static final String STATUS_CODE = "statuscode";
        public static final String MESSAGE = "message";
        public static final String RESPONSE = "response";

        public static final String ON_CLICK_CONTROLLER = "onClickController";
        public static final String OLD_PASSWORD ="departure_point";
        public static final String  NEW_PASSWORD ="arrival_point";
        public static final String CONFIRM_PASSWORD = "";
    }

}
