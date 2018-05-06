package thor.app.api.retrofit;

import retrofit2.Response;

public class ApiError {
    private Type type;
    private int statusCode;
    private String message;

    public enum Type {
        NETWORK, TIMEOUT, OTHER
    }

    private ApiError(Builder builder) {
        setType(builder.type);
        setStatusCode(builder.statusCode);
        setMessage(builder.message);
    }

    public ApiError(Response response) {
        this.type = Type.NETWORK;
        this.statusCode = response.code();
        this.message = response.message();

        try {
            this.message += "\n" + response.errorBody().string();
        } catch (Exception e) { }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static final class Builder {
        private Type type;
        private int statusCode;
        private String message;

        public Builder() {
        }

        public Builder type(Type val) {
            type = val;
            return this;
        }

        public Builder statusCode(int val) {
            statusCode = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public ApiError build() {
            return new ApiError(this);
        }
    }
}
