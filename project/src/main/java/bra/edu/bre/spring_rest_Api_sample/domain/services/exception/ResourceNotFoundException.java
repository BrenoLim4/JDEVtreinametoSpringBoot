package bra.edu.bre.spring_rest_Api_sample.domain.services.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id =" + id);
    }
}
