package com.example.starterweb;

import com.example.starterweb.service.SimpleService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StarterwebApplicationTests {

    @Autowired
    private SimpleService simpleService;

    @Test
    void contextLoads() {
        simpleService.test(8);
        simpleService.core(7);
        simpleService.work(9);
    }

}
