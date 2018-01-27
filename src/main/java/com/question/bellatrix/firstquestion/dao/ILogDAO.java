package com.question.bellatrix.firstquestion.dao;

import com.question.bellatrix.firstquestion.entity.Log;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on 26/01/2018.
 *
 * @author Hans H. Bravo
 */
public interface ILogDAO extends CrudRepository<Log, Integer> {
}
