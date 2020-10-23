package se.experis.saleh.hibernation.station.hibernation.Models.entity;

public class CommonResponse {
    private Object data;
    private String message;

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

