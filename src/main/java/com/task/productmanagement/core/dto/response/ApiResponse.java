package com.task.productmanagement.core.dto.response;

public class ApiResponse {
    private String message;
    private int httpStatus;
    private Object data;

    public ApiResponse(String message, int httpStatus, Object data) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
