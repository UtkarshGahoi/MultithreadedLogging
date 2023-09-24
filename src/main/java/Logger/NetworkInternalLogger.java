package Logger;

import model.WriteableMessages;

public class NetworkInternalLogger implements InternalLogger {
    private NetworkInternalLogger() {
        // Initiate connection to network driver / http connection which will
        // write to that particular logger
    }

    private static NetworkInternalLogger instance;

    public static NetworkInternalLogger getInstance() {
        if (instance == null) {
            synchronized (NetworkInternalLogger.class) {
                if (instance == null) {
                    instance = new NetworkInternalLogger();
                }
            }
        }

        return instance;
    }

    @Override
    public void log(WriteableMessages message) {
        System.out.println(message);
    }
}
