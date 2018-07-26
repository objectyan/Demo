package com.indooratlas.android.sdk.resources;

public class IAResult<R> {
    /* renamed from: a */
    static final /* synthetic */ boolean f24627a = (!IAResult.class.desiredAssertionStatus());
    /* renamed from: b */
    private final R f24628b;
    /* renamed from: c */
    private final Error f24629c;
    /* renamed from: d */
    private final boolean f24630d;

    public static class Error {
        public final Category category;
        public final Throwable cause;
        public final int code;
        public final String message;

        public enum Category {
            NETWORK,
            HTTP,
            CONVERSION
        }

        private Error(Category category, int code, String message, Throwable cause) {
            this.category = category;
            this.code = code;
            this.cause = cause;
            this.message = message;
        }

        public static Error networkError(Throwable cause) {
            return new Error(Category.NETWORK, -1, cause.getMessage(), cause);
        }

        public static Error httpError(int errorCode, String message) {
            return new Error(Category.HTTP, errorCode, message, null);
        }

        public static Error conversionError(Throwable cause) {
            return new Error(Category.CONVERSION, -1, cause.getMessage(), cause);
        }

        public String toString() {
            return "Error{code=" + this.code + ", cause=" + this.cause + ", category=" + this.category + ", message='" + this.message + '\'' + '}';
        }
    }

    private IAResult(boolean success, Error error, R result) {
        this.f24630d = success;
        this.f24628b = result;
        this.f24629c = error;
    }

    public static <R> IAResult<R> success(R result) {
        if (f24627a || result != null) {
            return new IAResult(true, null, result);
        }
        throw new AssertionError("result cannot be null for success");
    }

    public static <R> IAResult<R> failure(Error error) {
        if (f24627a || error != null) {
            return new IAResult(false, error, null);
        }
        throw new AssertionError("errorInfo cannot be null for failure");
    }

    public boolean isSuccess() {
        return this.f24630d;
    }

    public R getResult() {
        return this.f24628b;
    }

    public Error getError() {
        return this.f24629c;
    }

    public String toString() {
        return "IAResult{mResult=" + this.f24628b + ", mError=" + this.f24629c + '}';
    }
}
