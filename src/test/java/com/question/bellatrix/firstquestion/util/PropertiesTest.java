package com.question.bellatrix.firstquestion.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created on 26/01/2018.
 *
 * @author Hans H. Bravo
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class PropertiesTest {
    @Value("${config.path-file}")
    private String pathLogFile;

    @Test
    public void testGetProperty() throws Exception {
        assertEquals("D:\\temp\\log\\logFile.txt", pathLogFile);
    }

}
