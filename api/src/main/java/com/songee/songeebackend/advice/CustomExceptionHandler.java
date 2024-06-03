package com.songee.songeebackend.advice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ProblemDetail handleSecurityException(Exception ex){
        ProblemDetail error = null;

        if (ex instanceof BadCredentialsException){
            error=ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), ex.getMessage());
            error.setProperty("error", "BAD_CREDENCIALS");
        }

        if (ex instanceof ExpiredJwtException){
            error=ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), ex.getMessage());
            error.setProperty("error", "NOT_VALID_TOKEN");
        }

        if (ex instanceof SignatureException){
            error=ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), ex.getMessage());
            error.setProperty("error", "NOT_VALID_TOKEN");
        }

        if (ex instanceof MalformedJwtException){
            error=ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), ex.getMessage());
            error.setProperty("error", "NO_TOKEN");
        }

        return error;
    }


}
