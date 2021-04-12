package test.w2m.jfvTest.config.controller;

import test.w2m.jfvTest.confi.errors.SuperHeroAppError;
import test.w2m.jfvTest.exceptions.NonExistingSuperHeroException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ConditionalOnProperty(name = "test.w2m.jfvTest.config.controller", havingValue = "false")
public class SuperHeroControllerAdvice {

    @Value("${superheroes.sendreport.uri}")
    private String sendReportUri;
    @Value("${superheroes.api.version}")
    private String currentApiVersion;

    @ExceptionHandler(NonExistingSuperHeroException.class)
    public ResponseEntity<SuperHeroAppError> handleNonExistingHero(HttpServletRequest request,
                                                                   NonExistingSuperHeroException ex) {
        final SuperHeroAppError error = new SuperHeroAppError(
                currentApiVersion,
                ex.getErrorCode(),
                "This superhero is hiding",
                "superhero-exceptions",
                "You can't find this superhero right now. Try later.",
                "Saving someone",
                sendReportUri
        );
        return  new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
