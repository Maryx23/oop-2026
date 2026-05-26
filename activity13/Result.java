public class Result<T> {
    private T data;
    private String message;
    private boolean isSuccess;

    public Result(T data, String message, boolean isSuccess) {
        this.data = data;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void display() {
        System.out.println("Success: " + isSuccess);
        System.out.println("Message: " + message);
        System.out.println("Data: " + (data != null ? data.toString() : "null"));
    }
}