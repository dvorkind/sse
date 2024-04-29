package by.dvorkin.sse.service;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface ISSEService {

    void register(String login, SseEmitter emitter);

    void send(String login, String message);

}
