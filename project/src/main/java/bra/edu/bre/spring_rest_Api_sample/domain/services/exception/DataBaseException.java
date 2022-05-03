package bra.edu.bre.spring_rest_Api_sample.domain.services.exception;

public class DataBaseException extends RuntimeException{

    public DataBaseException(String message) {
        super(message);
    }
}
