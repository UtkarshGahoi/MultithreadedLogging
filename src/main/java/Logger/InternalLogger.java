package Logger;

import model.WriteableMessages;

public interface InternalLogger {
    void log(WriteableMessages message);
}
