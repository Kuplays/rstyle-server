package com.kuplays.rstyle.utilities;

/*
Utility class to send message
to front-end part via http responses
 */
public class BookOperationResponse {
    private String type;
    private String message;

    /*
    @param type type of the operation
    @param message additional message to the user
     */
    public BookOperationResponse(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
