package com.upwork.foreigner.guide;

import com.upwork.foreigner.guide.controller.PlaceController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ForeignerGuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForeignerGuideApplication.class, args);
    }

}
