package by.dvorkin.sse.web.controller;

import by.dvorkin.sse.service.ISSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MainController implements ErrorController {

    @Autowired
    private ISSEService isseService;

    @GetMapping(value = { "/main", "/", "/index" })
    public String mainPage() {
        return "index";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/send")
    public void send() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                isseService.send("123", "Hello World");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }

}
