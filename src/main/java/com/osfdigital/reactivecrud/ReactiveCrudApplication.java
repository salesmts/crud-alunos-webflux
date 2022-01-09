package com.osfdigital.reactivecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class ReactiveCrudApplication {
    static {
        BlockHound.install();
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveCrudApplication.class, args);
    }

}
