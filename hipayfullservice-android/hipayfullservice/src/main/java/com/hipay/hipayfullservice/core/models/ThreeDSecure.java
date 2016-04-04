package com.hipay.hipayfullservice.core.models;

import com.hipay.hipayfullservice.core.mapper.AbstractMapper;
import com.hipay.hipayfullservice.core.mapper.interfaces.MapMapper;

import org.json.JSONObject;

/**
 * Created by nfillion on 25/01/16.
 */
public class ThreeDSecure extends AbstractModel {

    protected ThreeDSecureEnrollmentStatus enrollmentStatus;
    protected String enrollmentMessage;

    protected ThreeDSecureAuthenticationStatus authenticationStatus;
    protected String authenticationMessage;
    protected String authenticationToken;
    protected String xid;

    public ThreeDSecure() {
    }

    public enum ThreeDSecureEnrollmentStatus {

        ThreeDSecureEnrollmentStatusUnknown (' '),
        ThreeDSecureEnrollmentStatusAuthenticationAvailable ('Y'),
        ThreeDSecureEnrollmentStatusCardholderNotEnrolled ('N'),
        ThreeDSecureEnrollmentStatusUnableToAuthenticate ('U'),
        ThreeDSecureEnrollmentStatusOtherError ('E');

        protected final char status;
        ThreeDSecureEnrollmentStatus(char status) {

            this.status = status;
        }

        public static ThreeDSecureEnrollmentStatus fromStringValue(String value) {

            if (value == null) return null;

            char c = value.charAt(0);

            if (c == ThreeDSecureEnrollmentStatusAuthenticationAvailable.getCharValue()) {
                return ThreeDSecureEnrollmentStatusAuthenticationAvailable;
            }

            if (c == ThreeDSecureEnrollmentStatusCardholderNotEnrolled.getCharValue()) {
                return ThreeDSecureEnrollmentStatusCardholderNotEnrolled;
            }

            if (c == ThreeDSecureEnrollmentStatusUnableToAuthenticate.getCharValue()) {
                return ThreeDSecureEnrollmentStatusUnableToAuthenticate;
            }

            if (c == ThreeDSecureEnrollmentStatusOtherError.getCharValue()) {
                return ThreeDSecureEnrollmentStatusOtherError;
            }

            return null;
        }

        public char getCharValue() {
            return this.status;
        }
    }

    public enum ThreeDSecureAuthenticationStatus {

        ThreeDSecureAuthenticationStatusUnknown (' '),
        ThreeDSecureAuthenticationStatusSuccessful ('Y'),
        ThreeDSecureAuthenticationStatusAttempted ('A'),
        ThreeDSecureAuthenticationStatusCouldNotBePerformed ('U'),
        ThreeDSecureAuthenticationStatusAuthenticationFailed ('N'),
        ThreeDSecureAuthenticationStatusOther ('E');

        protected final char status;
        ThreeDSecureAuthenticationStatus(char status) {
            this.status = status;
        }

        public char getCharValue() {
            return this.status;
        }

        public static ThreeDSecureAuthenticationStatus fromStringValue(String value) {

            if (value == null) return null;

            char c = value.charAt(0);

            if (c == ThreeDSecureAuthenticationStatusSuccessful.getCharValue()) {
                return ThreeDSecureAuthenticationStatusSuccessful;
            }

            if (c == ThreeDSecureAuthenticationStatusAttempted.getCharValue()) {
                return ThreeDSecureAuthenticationStatusAttempted;
            }

            if (c == ThreeDSecureAuthenticationStatusCouldNotBePerformed.getCharValue()) {
                return ThreeDSecureAuthenticationStatusCouldNotBePerformed;
            }

            if (c == ThreeDSecureAuthenticationStatusAuthenticationFailed.getCharValue()) {
                return ThreeDSecureAuthenticationStatusAuthenticationFailed;
            }

            if (c == ThreeDSecureAuthenticationStatusOther.getCharValue()) {
                return ThreeDSecureAuthenticationStatusOther;
            }

            return null;
        }

    }


    public ThreeDSecureEnrollmentStatus getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(ThreeDSecureEnrollmentStatus enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public String getEnrollmentMessage() {
        return enrollmentMessage;
    }

    public void setEnrollmentMessage(String enrollmentMessage) {
        this.enrollmentMessage = enrollmentMessage;
    }

    public ThreeDSecureAuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(ThreeDSecureAuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public String getAuthenticationMessage() {
        return authenticationMessage;
    }

    public void setAuthenticationMessage(String authenticationMessage) {
        this.authenticationMessage = authenticationMessage;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }


    public static class ThreeDSecureMapper extends AbstractMapper {
        public ThreeDSecureMapper(JSONObject jsonObject) {
            super(jsonObject);
        }

        @Override
        protected boolean isValid() {

            if (this.getBehaviour() instanceof MapMapper) {

                if (this.getStringForKey("enrollmentStatus") != null) return true;
            }

            return false;
        }

        protected Object mappedObject() {

            ThreeDSecure object = new ThreeDSecure();

            object.setEnrollmentMessage(this.getStringForKey("enrollmentMessage"));

            String enrollmentStatus = this.getEnumCharForKey("enrollmentStatus");
            ThreeDSecureEnrollmentStatus status = ThreeDSecureEnrollmentStatus.fromStringValue(enrollmentStatus);
            if (status == null) {
                status = ThreeDSecureEnrollmentStatus.ThreeDSecureEnrollmentStatusUnknown;
            }
            object.setEnrollmentStatus(status);

            String authenticationStatus = this.getEnumCharForKey("authenticationStatus");
            ThreeDSecureAuthenticationStatus authStatus = ThreeDSecureAuthenticationStatus.fromStringValue(authenticationStatus);
            if (authStatus == null) {
                authStatus = ThreeDSecureAuthenticationStatus.ThreeDSecureAuthenticationStatusUnknown;
            }
            object.setAuthenticationStatus(authStatus);

            object.setAuthenticationMessage(this.getStringForKey("authenticationMessage"));
            object.setAuthenticationToken(this.getStringForKey("authenticationToken"));
            object.setXid(this.getStringForKey("xid"));

            return object;

        }

        @Override
        protected Object mappedObjectFromBundle() {
            return null;
        }
    }

}
