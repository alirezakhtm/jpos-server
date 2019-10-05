package ir.navaco.mcb.credit.card.transaction.listener.loglisteners;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.FileWatchdog;
import org.apache.log4j.xml.DOMConfigurator;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.util.LogEvent;
import org.jpos.util.LogListener;

public class ServerLogListener implements LogListener, Configurable {
    private Level level;
    private String logName;

    public ServerLogListener() {
        setLevel(Level.DEBUG_INT);
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public void setLevel(int level) {
        this.level = Level.toLevel(level);
    }

    public void setLevel(String level) {
        this.level = Level.toLevel(level);
    }

    public void close() {
    }

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        String config = cfg.get("config");
        long watch = cfg.getLong("delay");
        this.logName = cfg.get("log-name");
        if (watch == 0)
            watch = FileWatchdog.DEFAULT_DELAY;
        if ((config != null) && (!config.trim().equals(""))) {
            DOMConfigurator.configureAndWatch(config, watch);
        }
        setLevel(cfg.get("priority"));
    }

    @Override
    public synchronized LogEvent log(LogEvent ev) {
        Logger logger = Logger.getLogger(this.logName);
        if (logger.isEnabledFor(level)) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                PrintStream p = new PrintStream(baos);
                ev.dump(p, "");
                logger.log(level, baos.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ev;
    }
}