package APITest.authController;

import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class FailureLoginTest {

    @Test
    public void testLoginFailure() throws IOException {
        OkHttpClient client = new OkHttpClient();

        // URL ендпоінту для логіна
        String url = "https://freelance.lsrv.in.ua/api/auth/signin";

        // JSON-запит для невдалого логіну
        String jsonRequest = "{\"username\": \"wrong_username\", \"password\": \"wrong_password\"}";

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonRequest);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            Assert.assertEquals(response.code(), 401);
        }
    }
}

