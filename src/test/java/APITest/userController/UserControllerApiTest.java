package APITest.userController;

import okhttp3.*;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertEquals;

public class UserControllerApiTest {

    private final String baseUrl = "https://freelance.lsrv.in.ua/api";
    @Test
    public void testGetUserById() throws IOException {
        OkHttpClient client = new OkHttpClient();

        int userId = 1;

        Request request = new Request.Builder()
                .url(baseUrl + "/user/" + userId)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertEquals(response.code(), 200);
            String responseBody = response.body().string();
            // Виведення вмісту тіла відповіді для перевірки
            System.out.println(responseBody);
        }
    }

    @Test
    public void testUpdateUser() throws IOException {
        OkHttpClient client = new OkHttpClient();

        int userId = 1;
        MediaType mediaType = MediaType.parse("application/json");
        String requestBody = "{ \"username\": \"updatedUser\", \"name\": \"John\", \"lastname\": \"Victor\", \"password\": \"testpassword\" }";
        RequestBody body = RequestBody.create(requestBody, mediaType);

        Request request = new Request.Builder()
                .url(baseUrl + "/user/" + "/update/")
                .put(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertEquals(response.code(), 200);
            String responseBody = response.body().string();
            // Виведення вмісту тіла відповіді для перевірки
            System.out.println(responseBody);
        }
    }
}

