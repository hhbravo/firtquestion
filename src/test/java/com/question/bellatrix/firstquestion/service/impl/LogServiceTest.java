package com.question.bellatrix.firstquestion.service.impl;
import com.question.bellatrix.firstquestion.enums.LevelEnum;
import com.question.bellatrix.firstquestion.service.ILogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created on 26/01/2018.
 *
 * @author Hans H. Bravo
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogServiceTest {

    @Autowired
    private ILogService service;

    @Test
    public void messageTest() {
        service.loadMessage("Test level Message", LevelEnum.MESSAGE.getLevel());
    }

    @Test
    public void warningTest() {
        service.loadMessage("Test level Message", LevelEnum.WARNING.getLevel());
    }

    @Test
    public void errorTest() {
        service.loadMessage("Test level Message", LevelEnum.ERROR.getLevel());
    }

    @Test
    public void messageEmptyTest() {
        service.loadMessage("", LevelEnum.WARNING.getLevel());
    }

    @Test
    public void messageNullTest() {
        service.loadMessage(null, LevelEnum.WARNING.getLevel());
    }
}