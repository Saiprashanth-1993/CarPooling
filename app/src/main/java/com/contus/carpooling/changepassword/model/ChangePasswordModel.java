/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.changepassword.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Model class for set the fields to UI layout
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class ChangePasswordModel extends BaseObservable {

    /**
     * Current password of the user
     */
    private String currentPassword;

    /**
     * New password of the user
     */
    private String newPassword;

    /**
     * Confirm password of the user
     */
    private String confirmPassword;

    /**
     * Gets {@see #currentPassword}.
     *
     * @return {@link #currentPassword}
     */
    @Bindable
    public String getCurrentPassword() {
        return currentPassword;
    }

    /**
     * Sets {@link #currentPassword}.
     */
    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    /**
     * Gets {@see #newPassword}.
     *
     * @return {@link #newPassword}
     */
    @Bindable
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets {@link #newPassword}.
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * Gets {@see #confirmPassword}.
     *
     * @return {@link #confirmPassword}
     */
    @Bindable
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Sets {@link #confirmPassword}.
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
