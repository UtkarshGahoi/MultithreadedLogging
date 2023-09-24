package Logger;

import Constant.LogLevel;
import Constant.SupportedLogMedium;
import Service.QueueService;
import model.ApplicationAwareMessage;
import model.WriteableMessages;

import java.util.ArrayList;
import java.util.List;

public class ApplicationAwareLogImplementation implements ApplicationAwareLogger {
    QueueService queueService;

    public ApplicationAwareLogImplementation(QueueService queueService) {
        this.queueService = queueService;

    }
    @Override
    public void info(ApplicationAwareMessage applicationAwareMessage) throws InterruptedException {
        this.queueService.publish(getWritableMessages(applicationAwareMessage, LogLevel.INFO));

    }

    @Override
    public void debug(ApplicationAwareMessage applicationAwareMessage) throws InterruptedException {
        this.queueService.publish(getWritableMessages(applicationAwareMessage, LogLevel.DEBUG));

    }

    @Override
    public void warn(ApplicationAwareMessage applicationAwareMessage) throws InterruptedException {
        this.queueService.publish(getWritableMessages(applicationAwareMessage, LogLevel.WARN));

    }

    @Override
    public void error(ApplicationAwareMessage applicationAwareMessage) throws InterruptedException {
        this.queueService.publish(getWritableMessages(applicationAwareMessage, LogLevel.ERROR));
    }

    private List<WriteableMessages> getWritableMessages(ApplicationAwareMessage applicationAwareMessage, LogLevel logLevel) {
        List<WriteableMessages> writableMessages = new ArrayList<>();
        for (SupportedLogMedium supportedLogMedium : applicationAwareMessage.getMediums()) {
            writableMessages.add(new WriteableMessages(applicationAwareMessage, logLevel, supportedLogMedium));
        }
        return writableMessages;

    }

}