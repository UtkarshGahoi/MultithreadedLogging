package Service;

import Configuration.Config;
import model.WriteableMessages;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueServiceImpl implements QueueService {
    private ArrayBlockingQueue<WriteableMessages> blockingQueue;
    private int capacity;

    public QueueServiceImpl(int cap) {
        this.capacity = Math.max(cap, Config.DEFAULT_CAPACITY);
        this.blockingQueue = new ArrayBlockingQueue<>(this.capacity);
    }

    @Override
    public void publish(List<WriteableMessages> messages) throws InterruptedException {
        Objects.requireNonNull(messages);

        for (WriteableMessages message: messages) {
            this.blockingQueue.offer(message, Config.DEFAULT_PUBLISH_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public WriteableMessages consume() throws InterruptedException {
        return this.blockingQueue.poll(Config.DEFAULT_CONSUMPTION_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }
}
