package com.contus.carpooling.companyregistration.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;

/**
 * Model class is used to get and store the company category id, name and status
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class CompanyCategoryInfo extends BaseObservable {

    /**
     * Company category id
     */
    private String id;

    /**
     * Company category name
     */
    private String name;

    /**
     * Company category slug
     */
    private String slug;

    /**
     * Company category activation status
     */
    private String activationStatus;

    /**
     * Gets {@see #id}.
     *
     * @return {@link #id}
     */
    public String getId() {
        return id;
    }

    /**
     * Sets {@link #id}.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets {@see #name}.
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets {@link #name}.
     */
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.category);
    }

    /**
     * Gets {@see #slus}.
     *
     * @return {@link #slug}
     */
    public String getSlug() {
        return slug;
    }

    /**
     * Sets {@link #slug}.
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * Gets {@see #activationStatus}.
     *
     * @return {@link #activationStatus}
     */
    @Bindable
    public String getActivationStatus() {
        return activationStatus;
    }

    /**
     * Sets {@link #activationStatus}.
     */
    public void setActivationStatus(String activationStatus) {
        this.activationStatus = activationStatus;
    }
}
