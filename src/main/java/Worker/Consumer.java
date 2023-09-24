package Worker;

import Logger.InternalLogger;
import Logger.InternalLoggerSimpleFactory;
import Service.QueueService;
import model.WriteableMessages;


public class Consumer implements Runnable {
    private QueueService queueService;

    public Consumer(QueueService queueService) {
        this.queueService = queueService;

    }

    @Override
    public void run() {
        while (true) {
            try {
                WriteableMessages message = this.queueService.consume();
                InternalLogger logger = InternalLoggerSimpleFactory.getLoggerInstance(message.getMedium());
                logger.log(message);

                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
