package com.question.bellatrix.firstquestion.enums;

public enum LevelEnum {

    MESSAGE(1), WARNING(2), ERROR(3);

    private int level;

    LevelEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
