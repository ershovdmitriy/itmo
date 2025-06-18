package lab6.common.service;

import java.io.Serializable;

public class CommandResponse implements Serializable {
    private boolean success;
    private String command;
    private String message;
    private Object data;

    public CommandResponse(boolean success, String command, String message) {
        this.success = success;
        this.message = message;
    }

    public CommandResponse(boolean success, String command, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getCommand() {
        return command;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}