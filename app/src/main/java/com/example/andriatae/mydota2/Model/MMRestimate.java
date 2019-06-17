package com.example.andriatae.mydota2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Andria TAE on 13/03/2018.
 */

public class MMRestimate extends RealmObject {

    @SerializedName("estimate")
    @Expose
    private Integer estimate;

    public Integer getEstimate() {
        return estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("estimate", estimate).toString();
    }

}
