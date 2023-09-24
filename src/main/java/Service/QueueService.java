package Service;

import model.WriteableMessages;

import java.util.List;

public interface QueueService {
    void publish(List<WriteableMessages> message) throws InterruptedException;
    WriteableMessages consume() throws InterruptedException;
}
