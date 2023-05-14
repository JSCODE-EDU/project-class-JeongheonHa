package com.bulletinboard.utils;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiUtils {

    public static<T> ResponseEntity<ApiResult<T>> success(T response, HttpStatus status) {
        return new ResponseEntity<>(new ApiResult<>(true, status, response, null), status);
    }

    public static ResponseEntity<ApiResult<?>> error(Throwable throwable, HttpStatus status) {
        return new ResponseEntity<>(new ApiResult<>(false, status, null, new ApiError(throwable)), status);
    }

    public static ResponseEntity<ApiResult<?>> error(String message, HttpStatus status) {
        return new ResponseEntity<>(new ApiResult<>(false, status, null, new ApiError(message)), status);
    }

    @Getter
    public static class ApiError {
        private final String message;

        ApiError(Throwable throwable) {
            this(throwable.getMessage());
        }

        ApiError(String message) {
            this.message = message;
        }
    }

    @Getter
    public static class ApiResult<T> {
        private final boolean success;
        private final HttpStatus status;
        private final int code;
        private final T response;
        private final ApiError error;

        private ApiResult(boolean success, HttpStatus status, T response, ApiError error) {
            this.success = success;
            this.status = status;
            this.code = status.value();
            this.response = response;
            this.error = error;
        }

        public boolean isSuccess() {
            return success;
        }
    }
}