package com.kodilla.patterns.singleton;

public final class Logger {
    private static Logger loggerInstance = null;
    private String lastLog = "";

    private Logger() {
    }

    public static Logger getInstance() {
        if (loggerInstance ==  null) {
            synchronized (Logger.class) {
                if (loggerInstance ==  null) {
                    loggerInstance = new Logger();
                }
            }
        }
        return loggerInstance;
    }

    public String getLastLog() {
        return lastLog;
    }

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }
}
