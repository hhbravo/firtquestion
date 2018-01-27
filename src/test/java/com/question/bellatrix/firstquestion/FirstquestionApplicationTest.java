package com.question.bellatrix.firstquestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/**
 * Created on 26/01/2018.
 *
 * @author Hans H. Bravo
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FirstquestionApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(FirstquestionApplicationTest.class, args);
    }

}