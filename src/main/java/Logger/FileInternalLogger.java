package Logger;

import model.WriteableMessages;

public class FileInternalLogger implements InternalLogger {
    private FileInternalLogger() {

    }

    private static FileInternalLogger instance;

    public static FileInternalLogger getInstance() {
        if (instance == null) {
            synchronized (FileInternalLogger.class) {
                if (instance == null) {
                    instance = new FileInternalLogger();
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
