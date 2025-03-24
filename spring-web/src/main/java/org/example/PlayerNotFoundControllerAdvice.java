package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlayerNotFoundControllerAdvice {
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<Void> handleGameNotFound(GameNotFoundException exception){
        return ResponseEntity.badRequest().build();
    }
}
