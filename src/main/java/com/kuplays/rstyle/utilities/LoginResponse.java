package com.kuplays.rstyle.utilities;

/*
Utility class to communicate
with front-end part on login
operations
 */
public class LoginResponse {
    private String responseToken;
    private String errorMessage;
    private boolean isAllowed;

    /*
    @param responseToken login token to set within
    session (just word token for demonstration)
    @param errorMessage sets up an error message to indicate
    incorrect input of username or password
    @param isAllowed boolean which tells if user has been allowed or not
     */
    public LoginResponse(String responseToken, String errorMessage, boolean isAllowed) {
        this.responseToken = responseToken;
        this.errorMessage = errorMessage;
        this.isAllowed = isAllowed;
    }

    public String getResponseToken() {
        return responseToken;
    }

    public void setResponseToken(String responseToken) {
        this.responseToken = responseToken;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isAllowed() {
        return isAllowed;
    }

    public void setAllowed(boolean allowed) {
        isAllowed = allowed;
    }
}
