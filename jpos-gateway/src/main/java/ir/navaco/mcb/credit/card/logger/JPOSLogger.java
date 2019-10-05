package ir.navaco.mcb.credit.card.logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;

public class JPOSLogger {

    private final String tag;
    private static boolean firstRun = false;

    public JPOSLogger(String tag) {
        if (!firstRun) {
            firstRun = true;
            BasicConfigurator.configure();
        }
        this.tag = tag;
    }

    public void info(String message) {
        this.log(Level.INFO, tag, message);
    }

    public void warn(String message) {
        this.log(Level.WARN, tag, message);
    }

    public void error(String message) {
        this.log(Level.ERROR, tag, message);
    }

    private void log(Level level, String TAG, String message) {
        Logger logger = Logger.getLogger(TAG);
        logger.log(level, message);
    }

}
