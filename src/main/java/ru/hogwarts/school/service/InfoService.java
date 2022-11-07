package ru.hogwarts.school.service;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@Service
public class InfoService {

    @Value("${server.port}")
    private String port;

    public String getPort(){
        return port;
    }

    public int getSum(){
        int sum =
                Stream.iterate(1, a -> a +1)
                        .limit(1_000_000)
                        .reduce(0, (a, b) -> a + b );
        return sum;
    }
}
