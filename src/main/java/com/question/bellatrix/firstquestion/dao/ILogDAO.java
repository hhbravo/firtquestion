package com.question.bellatrix.firstquestion.dao;

import com.question.bellatrix.firstquestion.entity.Log;
import org.springframework.data.repository.CrudRepository;

public interface ILogDAO extends CrudRepository<Log, Integer> {
}
