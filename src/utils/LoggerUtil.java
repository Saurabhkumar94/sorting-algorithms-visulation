package utils;

import java.util.logging.*;

public class LoggerUtil {
    public static void setup() {
        Logger root = Logger.getLogger("");
        Handler[] handlers = root.getHandlers();
        for (Handler h : handlers) root.removeHandler(h);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        root.addHandler(ch);
        root.setLevel(Level.ALL);
    }
}
