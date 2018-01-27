package com.question.bellatrix.firstquestion.service.impl;


import com.question.bellatrix.firstquestion.dao.ILogDAO;
import com.question.bellatrix.firstquestion.entity.Log;
import com.question.bellatrix.firstquestion.enums.LevelEnum;
import com.question.bellatrix.firstquestion.service.ILogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 26/01/2018.
 *
 * @author Hans H. Bravo
 */
@Transactional
@Service
public class LogService implements ILogService {

    @Autowired
    private ILogDAO dao;

    @Value("${config.logToDatabaseParam}")
    private Integer logToDatabase;

    @Value("${config.logMessageParam}")
    private Integer logMessage;

    @Value("${config.logWarningParam}")
    private Integer logWarning;

    @Value("${config.path-file}")
    private String pathLogFile;

    @Value("${config.logErrorParam}")
    private Integer logError;

    @Value("${config.logToFileParam}")
    private Integer logToFile;

    @Value("${config.logToConsoleParam}")
    private Integer logToConsole;

    private FileHandler fileHandler;
    ConsoleHandler consoleHandler= new ConsoleHandler();
    private Logger logger = Logger.getLogger("MyLog");

    @Override
    public void loadMessage(final String message, final Integer level) {
        //if it is empty or null it ends the program
        if (StringUtils.isEmpty(message)) {
            return;
        }
        //it is validated if the level exists
        if (!validateLevel(level)) {
            return;
        }

        try {
            File logFile = new File(pathLogFile);
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            fileHandler = new FileHandler(pathLogFile);
        } catch (Exception e) {
        }


        if (1 == logToFile) {
            logger.addHandler(fileHandler);
        }

        if (1 == logToConsole) {
            logger.addHandler(consoleHandler);
        }

        buildFormatMessage(message.trim(), level);

    }


    private void buildFormatMessage(final String messageText, final Integer level) {
        String value;
        if (1 == level) {
            value = "message";
        } else if (2 == level) {
            value = "warning";
        } else {
            value = "error";
        }
        logFile(value.concat(" ").concat(DateFormat.getDateInstance(DateFormat.LONG).format(new Date())).concat(messageText), level);
    }

    private boolean validateLevel(Integer level) {
        if (1 == logMessage && 1 == level)
            return true;

        if (1 == logMessage && 2 == level)
            return true;

        if (1 == logMessage && 3 == level)
            return true;

        return false;
    }

    public void logFile(final String messageBuilder, final Integer level) {
        logger.log(getLevel(level), messageBuilder);
        if (1 == logToDatabase) {
            dao.save(new Log(messageBuilder, level));
        }
    }

    private Level getLevel(final Integer level) {
        switch (level) {
            case 1:
                return Level.INFO;

            case 2:
                return Level.WARNING;

            default:
                return Level.SEVERE;

        }
    }


}
