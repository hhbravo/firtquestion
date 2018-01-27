package com.question.bellatrix.firstquestion;

import com.question.bellatrix.firstquestion.entity.Log;
import com.question.bellatrix.firstquestion.enums.LevelEnum;

public class DummyMock {

    public Log buildLog() {
        Log log = new Log();
        log.setLevel(LevelEnum.MESSAGE.getLevel());
        log.setMessage("Test insert");
        return log;
    }
}
