package one.digitalinnovation.gof.infra;

import org.springframework.http.HttpStatus;

public class JsonExceptionConfig {

    private HttpStatus httpStatus;
    private Integer statusCode;
    private String message;

    public JsonExceptionConfig(HttpStatus httpStatus, Integer statusCode, String message) {
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
