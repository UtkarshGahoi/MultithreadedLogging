package Logger;

import model.ApplicationAwareMessage;

public interface ApplicationAwareLogger {
    void info(ApplicationAwareMessage applicationAwareMessage) throws InterruptedException;
    void debug(ApplicationAwareMessage applicationAwareMessage) throws InterruptedException;
    void warn(ApplicationAwareMessage applicationAwareMessage) throws InterruptedException;
    void error(ApplicationAwareMessage applicationAwareMessage) throws InterruptedException;
}
