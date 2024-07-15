package app.service;

import okhttp3.Response;
import org.springframework.stereotype.Component;

@Component
public interface HttpClient {

  Response post(String path, Object payload);

}
