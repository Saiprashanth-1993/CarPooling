/**
 * @category Car Pooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.homepage.model;

import android.databinding.BaseObservable;

/**
 * This is the model class for get the user profile details from the API response
 *
 * @author Contus Team <developers@contus.in>
 * @version 1
 */
public class UserProfile extends BaseObservable {

    /**
     * Get the username
     */
    private String username;

    /**
     * Get the position
     */
    private String position;

    /**
     * Source of the place
     */
    private String location;

    /**
     * Get the image what user have uploaded the profile pic
     */
    private String userImage;

    /**
     * Gets {@see #username}.
     *
     * @return {@link #username}
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets {@see #username}
     *
     * @param username (@link #username}
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets {@see #position}.
     *
     * @return {@link #position}
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets {@see #position}
     *
     * @param position (@link #position}
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Gets {@see #location}.
     *
     * @return {@link #location}
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets {@see #location}
     *
     * @param location (@link #location}
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets {@see #userImage}.
     *
     * @return {@link #userImage}
     */
    public String getUserImage() {
        return userImage;
    }

    /**
     * Sets {@see #userImage}
     *
     * @param userImage (@link #userImage}
     */
    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
