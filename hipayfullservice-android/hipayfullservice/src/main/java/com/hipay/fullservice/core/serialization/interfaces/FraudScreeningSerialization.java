package com.hipay.fullservice.core.serialization.interfaces;

import android.os.Bundle;

import com.hipay.fullservice.core.models.FraudScreening;
import com.hipay.fullservice.core.models.FraudScreeningReview;
import com.hipay.fullservice.core.utils.enums.FraudScreeningResult;

import java.util.Map;

/**
 * Created by nfillion on 07/09/16.
 */
public class FraudScreeningSerialization extends AbstractSerialization {

    public FraudScreeningSerialization(FraudScreening fraudScreening) {
        super(fraudScreening);
    }

    @Override
    public Map<String, String> getSerializedRequest() {
        return null;
    }

    @Override
    public String getQueryString() {
        return null;
    }

    @Override
    public Bundle getSerializedBundle() {

        super.getSerializedBundle();

        FraudScreening fraudScreening = (FraudScreening)this.getModel();

        this.putIntForKey("scoring", fraudScreening.getScoring());

        FraudScreeningResult result = fraudScreening.getResult();
        if (result != null) {
            this.putStringForKey("result", result.getValue());
        }

        FraudScreeningReview review = fraudScreening.getReview();
        if (review != null) {
            this.putStringForKey("review", review.getStringValue());
        }

        return this.getBundle();
    }
}
