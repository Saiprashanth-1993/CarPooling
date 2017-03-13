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
     * Constants API base URL
     */
    public static final String BASE_URL = "http://p105.dev.contus.us/p105-carpooling-web/public/api/";
//    public static final String BASE_URL = "http://192.168.1.152:8000/api/";

    /**
     * To get the device token from device by using fireBase
     */
    public static final String DEVICE_TOKEN="device_token";

    /**
     * Header type need to use that
     */
    public static final String REQUEST_TYPE_HEADER="X-REQUEST-TYPE";

    /**
     * Constants for device token header
     */
    public static final String ACCESS_TOKEN_HEADER="X-ACCESS-TOKEN";

    /**
     * Constants for access token header
     */
    public static final String DEVICE_TOKEN_HEADER="X-DEVICE-TOKEN";

    /**
     *
     */
    public static final String DEVICE_TOKEN_HEADER_VALUE="deviceToken";

    /**
     *
     */
    public static final String ACCESS_TOKEN_HEADER_VALUE="acesssToken";     /**
     * The constats for Shared Preference
     */
    public static final String DEVICE_TOKEN_PREF="deviceTokenPref";
    /**
     * Get the request type value
     */
    public static final String REQUEST_TYPE_VALUE="mobile";
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
    public static final String REG_EMAIL="email";
    /**
     * The Constant UserId
     */
    public static final String REG_USER_ID="id";
/**
     *
     */
    public static  String REG_TOKEN_PREF="";
    /**
     *
     */
    public static  String REG_ACCESS_TOKEN_PREF="";

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
         * Constant for get the Login API response and store intp adminUser model
         */
        public static final String ADMIN_USER="adminusers";
        /**
         * Constant value set from response
         */
        public static final String USER_PD = "password";

        /**
         * Constant value set from response
         */
        public static final String LOGIN_ID="id";
        /**
         *Constant value set from response
         */
        public static final String USER_ROLE_ID="userRoleId";
        /**
         *Constant value set from response
         */
        public static final String LOGIN_NAME="name";
        /**
         * Constant value set from response
         */
        public static final String USER_EMAIL_ID="email";
        /**
         * Constant value set from response
         */
        public static final String USERNAME="username";
        /**
         * Constant value set from response
         */
        public static final String MOBILE="mobile";
        /***
         * Constant value set from response
         */
        public static final String GENDER="gender";
        /***
         * Constant value set from response
         */
        public static final String FROM_LOCATION="from_location";
        /***
         * Constant value set from response
         */
        public static final String To_LOCATION="to_location";
        /***
         * Constant value set from response
         */
        public static final String AGE="age";
        /***
         * Constant value set from response
         */
        public static final String PROFILE_IMAGE="profile_image";
        /***
         * Constant value set from response
         */
        public static final String COMPANY_ID="company_id";
        /***
         * Constant value set from response
         */
        public static final String COMPANY_CATEGORY_ID="company_category_id";
        /***
         * Constant value set from response
         */
        public static final String COMPANY_LOCATION="company_location";
        /***
         * Constant value set from response
         */
        public static final String DEVICE_TYPE="device_type";
        /***
         * Constant value set from response
         */
        public static final String DEVICE_TOKEN="device_token";
        /***
         * Constant value set from response
         */
        public static final String EMPLOYEE_ID="employee_id";
        /***
         * Constant value set from response
         */
        public static final String IS_ACTIVE="isActive";


        /**
         * Instantiates a new constants.
         */
        private Login() {
            //Private constructor for prevent instance.
        }
    }

    /**
     * Constants for profile class
     */
    public static final class Profile {

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
        public static final String ADDRESS="company_location";

        /***
         * Constant value set from response
         */
        public static final String USER_LOCATION="from_location";
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
        private Profile() {
            //Private constructor for prevent instance.
        }
    }

    /**
     * Constants fro Register class
     */
    public static final class Register {

        /**
         * Get the response from API after register the user details
         */
        public static final String USER_DETAILS="UserDetails";

        /**
         * Get the id from API response  after register the user details
         */
        public static final String ID="id";

        /**
         * Constant value for post the name and set the error
         */
        public static final String USER_NAME = "username";

        /**
         * constant value for post the email and set the error
         */
        public static final String USER_EMAIL = "email";
        /**
         * constant value for register the userMobileNumber
         */
        public static final String USER_MOBILE_NUMBER = "mobile";
        /**
         * constant value for register the userGender and set the error
         */
        public static final String USER_GENDER = "gender";

        /**
         * Constant value for register the userFromLocation and set the error
         */
        public static final String USER_FROM_LOCATION = "from_location";
        /**
         * constant value for register the userToLocation and set the error
         */
        public static final String USER_TO_LOCATION = "to_location";
        /**
         * constant value for register the userPassword and set the error
         */
        public static final String USER_REG_PD = "password";



        /**
         * constant value for register token
         */
        public static final String  REGISTER_DEVICE_TOKEN="device_token";


    }

    /**
     * Constants for company name and company category
     */
  public static final class CompanyList{
      public static final String COMPANY_DATA="data";
      public static final String COMPANY="company";
      public static final String CATEGORY ="sector";
      public static final String  COMPANY_NAME_ID="id";
      public static final String  COMPANY_NAME="name";
      public static final String  CATEGORY_ID="id";
      public static final String  CATEGORY_NAME="name";
    }

    /**
     * Constatn for company company registration
      */
  public static final class CompanyRegistration
    {
       public static final String COMPANY_REGISTRATION_NAME="name";
       public static final String COMPANY_CATEGORY_ID = "company_category_id";
       public static final String COMPANY_LOCATION="company_location";
        /**
         * After complete the Company Registration get the response form server
         */
        public static final String COMPANY_DETAILS="response";
        public static final String COMPANY_DETAILS_ID="id";
        public static final String COMPANY_NAME="name";
        public static final String SLUG="slug";
    }


    /**
     * Constant for Employee Response
     */
    public static final class EmployeeResponse{
        public static final String EMPLOYEE_DETAILS_RESPONSE="Employee Details";
        public static final String EMPLOYEE_ID="id";
        public static final String USER_ID="user_id";
        public static final String ADAHAR_CARD="aadhar_card";
        public static final String PAN_CARD="pan_card";
        public static final String REMEMBER_TOKEN="rememberToken";
    }


    /**
     * Create the ride
     */
    public static final class CreateRide{
        /**
         * After create the ride get the response
         */
        public static final String CREATE_RIDE_RESPONSE="RideDetails";

        public static final String  DEPARTURE_POINT="departure_point";
        public static final String  ARRIVAL_POINT="arrival_point";
        public static final String  DEPARTURE_TIME="departure_time";
        public static final String  ARRIVAL_TIME="arrival_time";
        public static final String  GENDER_PREFERENCE="gender_preference";
        public static final String  DAYS_PREFERENCE="days_preference";
        public static final String  SEATS="seats";
        public static final String  VEHICLE_TYPE="vehicle_type";
        public static final String  IS_EVERY_WEEEKS="is_every_weeks";
        public static final String  TYPE="type";
        public static final String  COST="cost";
        public static final String  IS_ACTIVE="is_active";

    }

    /**
     * Display the rides offered list
     */
    public static final class RidesOffered{
        public static final String DEPARTURE_POINT="departure_point";
        public static final String  ARRIVAL_POINT="arrival_point";
    }

    public static final class profile{
        public static final String USER_NAME="name";
        public static final String  USER_EMAIL="email";
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
        public static final String  USER_TOKEN="UserToken";


        /**
         * Instantiates a new constants.
         */
        private ApiRequest() {
            //Private constructor for prevent instance.
        }
    }
}
