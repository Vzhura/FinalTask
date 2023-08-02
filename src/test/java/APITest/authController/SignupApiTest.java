package APITest.authController;

import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class SignupApiTest {

    private final String baseUrl = "https://freelance.lsrv.in.ua/api/auth/signup";

    @Test
    public void testSignupSuccess() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String requestBody = "{ \"username\": \"testUser\", \"name\": \"John\", \"lastname\": \"Victor\", \"password\": \"testpassword\", \"confirmpassword\": \"testpassword\" }";
        RequestBody body = RequestBody.create(requestBody, mediaType);

        Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertEquals(response.code(), 200);
            String responseBody = response.body().string();
            System.out.println(responseBody);
        }
    }

    @Test
    public void testSignupFailureUsernameExists() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String requestBody = "{ \"username\": \"testUser\", \"name\": \"John\", \"lastname\": \"Victor\", \"password\": \"testpassword\", \"confirmpassword\": \"testpassword\" }";
        RequestBody body = RequestBody.create(requestBody, mediaType);

        Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertEquals(response.code(), 400);
            String responseBody = response.body().string();
            System.out.println(responseBody);
        }
    }

    @Test
    public void testSignupFailurePasswordMismatch() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String requestBody = "{ \"username\": \"newUser\", \"name\": \"John\", \"lastname\": \"Doe\", \"password\": \"testpassword\", \"confirmpassword\": \"wrongpassword\" }";
        RequestBody body = RequestBody.create(requestBody, mediaType);

        Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertEquals(response.code(), 400);
            String responseBody = response.body().string();
            System.out.println(responseBody);
        }
    }
}

