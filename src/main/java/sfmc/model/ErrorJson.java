package sfmc.model;

public class ErrorJson {

    public Integer status;
    public String message;
    public Exception exception;

    public ErrorJson(int status, String message, Exception exception) {
        this.status = status;
        this.message = message;
        this.exception = exception;
    }

}
