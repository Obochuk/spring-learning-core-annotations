package com.obochuk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneServiceWithProperties implements FortuneService {

    @Value("${fortune.factory.instances}")
    private String data[];

    @Override
    public String getFortune() {
        Random random = new Random();
        int index = random.nextInt(data.length);
        return data[index];
    }
}
