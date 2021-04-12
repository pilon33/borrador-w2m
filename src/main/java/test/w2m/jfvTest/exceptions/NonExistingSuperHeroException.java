package test.w2m.jfvTest.exceptions;

import test.w2m.jfvTest.confi.errors.ErrorCode;

/**
 * This exception is thrown when the SuperHero can't be found in the application if searching by ID.
 */
public class NonExistingSuperHeroException extends RuntimeException implements ErrorCode {

    public NonExistingSuperHeroException(final String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "TEST NE-001";
    }
}
