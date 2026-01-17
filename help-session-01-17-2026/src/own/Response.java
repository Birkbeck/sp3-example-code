package own;

public class Response<T> {
    private T data;
    private int statusCode;

    public Response(T data, int statusCode){
        this.data = data;
        this.statusCode = statusCode;
    }

    public T getData() { return data; }
    public int getStatusCode() { return statusCode; }
}
