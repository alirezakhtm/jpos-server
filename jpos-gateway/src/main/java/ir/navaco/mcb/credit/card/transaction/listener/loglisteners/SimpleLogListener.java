package ir.navaco.mcb.credit.card.transaction.listener.loglisteners;

import org.jpos.util.LogEvent;
import org.jpos.util.LogListener;
import java.io.PrintStream;

public class SimpleLogListener implements LogListener {
    PrintStream p;

    public SimpleLogListener() {
        this.p = System.out;
    }

    public SimpleLogListener(PrintStream p) {
        this();
        this.setPrintStream(p);
    }

    public synchronized void setPrintStream(PrintStream p) {
        this.p = p;
    }

    public synchronized void close() {
        if (this.p != null) {
            this.p.close();
            this.p = null;
        }

    }

    public synchronized LogEvent log(LogEvent ev) {
        if (this.p != null) {
            ev.dump(this.p, "");
            this.p.flush();
        }

        return ev;
    }
}