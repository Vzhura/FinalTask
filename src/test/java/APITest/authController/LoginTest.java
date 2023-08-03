package APITest.authController;

import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTest {

    @Test
    public void testLoginSuccess() throws IOException {
        OkHttpClient client = new OkHttpClient();

        // URL ендпоінту для логіна
        String url = "https://freelance.lsrv.in.ua/api/auth/signin";

        // JSON-запит для логіна
        String jsonRequest = "{\"username\": \"testUser\", \"password\": \"testpassword\"}";

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonRequest);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            Assert.assertEquals(response.code(), 200);
        }
    }
}

