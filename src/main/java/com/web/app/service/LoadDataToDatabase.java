package com.web.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoadDataToDatabase {

    public void run() {

        log.info("Load data to database process started...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Load data to database process completed...");
    }
}
