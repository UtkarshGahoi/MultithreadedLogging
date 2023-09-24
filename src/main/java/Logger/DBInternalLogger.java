package Logger;

import model.WriteableMessages;

public class DBInternalLogger implements InternalLogger {
    private DBInternalLogger() {
        // Initiate connection to DB driver here
    }

    private static DBInternalLogger instance;

    public static DBInternalLogger getInstance() {
        if (instance == null) {
            synchronized (DBInternalLogger.class) {
                if (instance == null) {
                    instance = new DBInternalLogger();
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
