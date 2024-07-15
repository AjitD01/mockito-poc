package app;

import app.service.HttpClient;
import app.service.HttpClientImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "app.service")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public HttpClient httpClient() {
        return new HttpClientImpl("https://example.com"); // or return new HttpClientMock("https://example.com");
    }
}
