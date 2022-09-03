package xyz.icefery.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/*")
    public Map<String, String> any(HttpServletRequest request) {
        return Map.of("url", String.format("%s://%s%s%s", request.getScheme(), request.getHeader("Host"), request.getRequestURI(), request.getQueryString() == null ? "" : "?" + request.getQueryString()));
    }
}
