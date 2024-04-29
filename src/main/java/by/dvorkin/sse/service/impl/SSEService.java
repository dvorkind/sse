package by.dvorkin.sse.service.impl;

import by.dvorkin.sse.service.ISSEService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class SSEService implements ISSEService {

    private final ConcurrentMap<String, SseEmitter> emittersMap = new ConcurrentHashMap<>();

    @Override
    public void register(String login, SseEmitter emitter) {
        emittersMap.put(login, emitter);
        emitter.onCompletion(() -> emittersMap.remove(emitter));
        emitter.onTimeout(() -> emittersMap.remove(emitter));
    }

    @Override
    public void send(String login, String message) {
        try {
            emittersMap.get(login).send(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
