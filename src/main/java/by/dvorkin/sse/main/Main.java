package by.dvorkin.sse.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "by.dvorkin.*")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
