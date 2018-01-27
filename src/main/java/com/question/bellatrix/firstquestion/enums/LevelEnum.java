package com.question.bellatrix.firstquestion.enums;

/**
 * Created on 26/01/2018.
 *
 * @author Hans H. Bravo
 */
public enum LevelEnum {

    MESSAGE(1), WARNING(2), ERROR(3);

    private Integer level;

    LevelEnum(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }
}
