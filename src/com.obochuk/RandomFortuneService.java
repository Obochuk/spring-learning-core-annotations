package com.obochuk;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String data[] = {
            "Beware of the wolf on the sheep`s clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    @Override
    public String getFortune() {
        Random random = new Random();
        int index = random.nextInt(data.length);
        return data[index];
    }
}
