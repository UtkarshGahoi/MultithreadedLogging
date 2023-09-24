package model;

import Constant.LogLevel;
import Constant.SupportedLogMedium;

public class WriteableMessages {
    private ApplicationAwareMessage applicationAwareMessage;
    private LogLevel logLevel;
    private SupportedLogMedium medium;

    public WriteableMessages(ApplicationAwareMessage applicationAwareMessage, LogLevel logLevel, SupportedLogMedium medium) {
        this.applicationAwareMessage = applicationAwareMessage;
        this.logLevel = logLevel;
        this.medium = medium;
    }

    public SupportedLogMedium getMedium() {
        return this.medium;
    }

    @Override
    public String toString() {
        return "Log Level = " + logLevel
                + " Thread - " + applicationAwareMessage.getThread().getName()
                + " timestamp = " + applicationAwareMessage.getTime().toString()
                + " message = " + applicationAwareMessage.getMsg();
    }
}
