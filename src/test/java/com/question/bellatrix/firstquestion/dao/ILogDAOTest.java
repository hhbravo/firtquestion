package com.question.bellatrix.firstquestion.dao;

import com.question.bellatrix.firstquestion.DummyMock;
import com.question.bellatrix.firstquestion.entity.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

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
    public void insertLogTest() {
        Log input = dummyMock.buildLog();
        Log result = logDAO.save(input);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getId().intValue());
        Assert.assertEquals(input.getMessage(), result.getMessage());
        Assert.assertEquals(input.getLevel(), result.getLevel());
    }
}