package model;

import Constant.SupportedLogMedium;

import java.time.Instant;
import java.util.List;

public class ApplicationAwareMessage {
    private String msg;
    private Instant time;
    private List<SupportedLogMedium> mediums;
    private Thread thread;

    public ApplicationAwareMessage(String msg, List<SupportedLogMedium> mediums) {
        this.msg = msg;
        this.mediums = mediums;
        this.time = Instant.now();
        this.thread = Thread.currentThread();
    }

    public String getMsg() {
        return msg;
    }

    public Instant getTime() {
        return time;
    }

    public List<SupportedLogMedium> getMediums() {
        return mediums;
    }

    public Thread getThread() {
        return thread;
    }

}
