package com.question.bellatrix.firstquestion.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created on 26/01/2018.
 *
 * @author Hans H. Bravo
 */
@Entity
@Table(name = "LOG")
public class Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "message")
    private String message;

    @Column(name = "level")
    private Integer level;

    public Log() {

    }

    public Log(String message, Integer level) {
        this.message = message;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
