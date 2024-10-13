package cn.edu.zucc.reactive;

import cn.edu.zucc.reactive.entity.ReactiveUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class ReactiveUserHandler {
    /**
     * 获取用户id
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> getUserId(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(Mono.just("4201"), String.class);
    }

    /**
     * 获取用户姓名
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> getUserName(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(Mono.just("lrl"), String.class);
    }

    /**
     * 通知新用户（SSE Server Send Event）
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> notifyNewUser(ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.interval(Duration.ofSeconds(1)).
                        map(s -> new ReactiveUser(System.currentTimeMillis() + s, "message" + s)), ReactiveUser.class);
    }
}
