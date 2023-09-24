package Worker;

import Constant.SupportedLogMedium;
import Logger.ApplicationAwareLogImplementation;
import Logger.ApplicationAwareLogger;
import Service.QueueService;
import model.ApplicationAwareMessage;

import java.util.Arrays;
import java.util.Random;

public class Producer implements Runnable {
    private QueueService queueService;

    public Producer(QueueService queueService) {
        this.queueService = queueService;
    }

    @Override
    public void run() {
        while (true) {
            ApplicationAwareLogger logger = new ApplicationAwareLogImplementation(this.queueService);

            for (int i = 0; i < 100; i++) {
                try {
                    logger.info(new ApplicationAwareMessage("info - " + new Random().nextInt(10000),
                            Arrays.asList(SupportedLogMedium.DB.FILE, SupportedLogMedium.DB)));
                    logger.debug(new ApplicationAwareMessage("debug - " + new Random().nextInt(10000),
                            Arrays.asList(SupportedLogMedium.FILE, SupportedLogMedium.DB)));
                    logger.warn(new ApplicationAwareMessage("warn - " + new Random().nextInt(10000),
                            Arrays.asList(SupportedLogMedium.FILE, SupportedLogMedium.DB)));
                    logger.error(new ApplicationAwareMessage("error - " + new Random().nextInt(10000),
                            Arrays.asList(SupportedLogMedium.FILE, SupportedLogMedium.DB)));

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
