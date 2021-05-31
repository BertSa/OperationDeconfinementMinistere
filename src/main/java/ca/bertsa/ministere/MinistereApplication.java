package ca.bertsa.ministere;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class MinistereApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinistereApplication.class, args);
    }


}
