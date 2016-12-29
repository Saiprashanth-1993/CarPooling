/**
 * @category CarPooling
 * @package com.contus.carpooling.employeedetails.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.model;

/**
 * Model class is used to get and store the employee details
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class EmployeeInfo {

    /**
     * Image selected type as front.
     */
    private String imageSelectedType;

    /**
     * Gets {@see #location}.
     *
     * @return {@link #imageSelectedType}
     */
    public String getImageSelectedType() {
        return imageSelectedType;
    }

    /**
     * Sets {@link #imageSelectedType}.
     */
    public void getImageSelectedType(String imageSelectedType) {
        this.imageSelectedType = imageSelectedType;
    }
}
