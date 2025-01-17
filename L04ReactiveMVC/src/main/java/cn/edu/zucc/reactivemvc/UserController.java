package cn.edu.zucc.reactivemvc;

import cn.edu.zucc.reactivemvc.entity.MVCUser;
import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author longzhonghua
 * @data 2/19/2019 8:25 PM
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {
    Map<Long, MVCUser> users = new HashMap<>();

    @PostConstruct//依赖关系注入完成之后，执行初始化
    public void init() throws Exception {
        users.put(Long.valueOf(1), new MVCUser(1, "longzhonghua", 28));
        users.put(Long.valueOf(2), new MVCUser(2, "longzhiran", 2));
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @GetMapping("/list")
    public Flux<MVCUser> getAll() {
        return Flux.fromIterable(users.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList()));
    }

    /**
     * 获取单个用户
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Mono<MVCUser> getUser(@PathVariable Long id) {
        return Mono.justOrEmpty(users.get(id));
    }

    /**
     * 创建用户
     *
     * @param
     * @return
     */
    @PostMapping("")
    public Mono<ResponseEntity<String>> addUser(MVCUser user) {
        users.put(user.getId(), user);
        return Mono.just(new ResponseEntity<>("添加成功", HttpStatus.CREATED));
    }

    /**
     * 修改用户
     *
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<MVCUser>> putUser(@PathVariable Long id, MVCUser user) {
        user.setId(id);
        users.put(id, user);
        return Mono.just(new ResponseEntity<>(user, HttpStatus.CREATED));
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable Long id) {
        users.remove(id);
        return Mono.just(new ResponseEntity<>("删除成功", HttpStatus.ACCEPTED));
    }
}