package by.dvorkin.sse.web.controller;

import by.dvorkin.sse.service.ISSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SSEController {

    @Autowired
    private ISSEService sseService;

    @GetMapping(path = "/sse/verification/result", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        sseService.register("123", emitter);
        return emitter;
    }

}
