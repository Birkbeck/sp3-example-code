package own;

public class Demo {
    static void main() {
        Response<String> strResp = new Response<>("Message", 200);
        Response<Integer> integerResponse = new Response<>(12, 300);

        System.out.printf("Response (String): %s with code %d\n", strResp.getData(), strResp.getStatusCode());
        System.out.printf("Response (int): %d with code %d\n", integerResponse.getData(), integerResponse.getStatusCode());
    }
}
