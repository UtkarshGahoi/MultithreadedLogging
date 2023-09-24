package Logger;

import Constant.SupportedLogMedium;

import static Constant.SupportedLogMedium.DB;
import static Constant.SupportedLogMedium.NETWORK;

public class InternalLoggerSimpleFactory {
    public static InternalLogger getLoggerInstance(SupportedLogMedium medium) {
        switch (medium) {
            case DB:
                return DBInternalLogger.getInstance();
            case FILE:
                return FileInternalLogger.getInstance();
            case NETWORK:
                return NetworkInternalLogger.getInstance();
            default:
                return null;
        }
    }
}
