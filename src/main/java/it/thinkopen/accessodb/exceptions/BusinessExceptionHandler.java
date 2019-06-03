package it.thinkopen.accessodb.exceptions;

import it.thinkopen.accessodb.request_response.ErrorResponse;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BusinessExceptionHandler {

    private final static Logger logger = Logger.getLogger(BusinessExceptionHandler.class);

//    @ExceptionHandler
//    private ResponseEntity<ErrorResponse> handleBusinessException(BusinessException businessException) {
//        logger.error("Errore: " + businessException.getMessage());
//        logger.info("------------------------");
//
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
//        errorResponse.setMessage(businessException.getMessage());
//        errorResponse.setTimestamp(System.currentTimeMillis());
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleOtherExceptions(Exception exception) {
        logger.error("Errore: " + exception.getMessage());
        logger.info("------------------------");

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
