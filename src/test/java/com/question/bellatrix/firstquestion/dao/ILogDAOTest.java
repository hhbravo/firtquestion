package com.question.bellatrix.firstquestion.dao;

import com.question.bellatrix.firstquestion.DummyMock;
import com.question.bellatrix.firstquestion.entity.Log;
import com.question.bellatrix.firstquestion.enums.LevelEnum;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.text.DateFormat;
import java.util.Date;

import static com.question.bellatrix.firstquestion.enums.LevelEnum.ERROR;
import static com.question.bellatrix.firstquestion.enums.LevelEnum.MESSAGE;
import static com.sun.org.apache.xalan.internal.xslt.EnvironmentCheck.WARNING;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ILogDAOTest {

    @Autowired
    ILogDAO logDAO;
    private DummyMock dummyMock;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    public void insertLevelMessageLogTest() {
        Log input = dummyMock.buildLog();
        Log result = logDAO.save(input);

        Assert.assertNotNull(result);
        Assert.assertEquals(input.getMessage(), result.getMessage());
        Assert.assertEquals(input.getLevel(), result.getLevel());
    }

    @Test
    public void insertLevelErrorLogTest() {
        Log input = dummyMock.buildLog();
        input.setLevel(LevelEnum.ERROR.getLevel());
        Log result = logDAO.save(input);

        Assert.assertNotNull(result);
        Assert.assertEquals(input.getMessage(), result.getMessage());
        Assert.assertEquals(input.getLevel(), result.getLevel());
    }
}