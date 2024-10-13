package cn.edu.zucc.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * code from https://zhuanlan.zhihu.com/p/143614001
 */
@Configuration
public class ReactiveRouter {
    @Autowired
    private ReactiveUserHandler userHandler;
    @Bean
    public RouterFunction<ServerResponse> userRouter() {
        return RouterFunctions.nest(
                //相当于controller下的 request mapping
                path("/reactive"),

                //各个路由节点
                RouterFunctions
                        .route(GET("/getuserid"), userHandler::getUserId)
                        .andRoute(GET("/getusername"), userHandler::getUserName)
                        .andRoute(GET("/notify"), userHandler::notifyNewUser)
        );
    }
}
