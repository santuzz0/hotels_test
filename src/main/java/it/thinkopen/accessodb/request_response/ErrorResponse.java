package it.thinkopen.accessodb.request_response;

import java.sql.Timestamp;

public class ErrorResponse {
    private String status;
    private String message;
    private long timestamp;

    public ErrorResponse() {
    }

    public ErrorResponse(String status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
