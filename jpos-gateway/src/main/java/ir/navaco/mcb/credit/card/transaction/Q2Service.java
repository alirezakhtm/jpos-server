package ir.navaco.mcb.credit.card.transaction;

import org.jpos.q2.Q2;
import java.io.File;

public class Q2Service
{
    Q2 q2;
    String deployDir;

    public Q2Service(String deployDir)
    {
        this.deployDir = deployDir;
    }

    public Q2 getQ2()
    {
        return q2;
    }

    public void start() throws Exception
    {
        try
        {
            if (deployDir != null) {
                String[] xargs = new String[]{"-r", "-d", new File(deployDir).getAbsolutePath()};
                q2 = new Q2(xargs);
                q2.start();
            }else {
                q2 = new Q2();
                q2.start();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    public void stop() throws Exception
    {
        try
        {
            if (q2 != null)
            {
                q2.shutdown(true);
            }
        }
        catch (Exception ignored)
        {
        }
        finally
        {
            q2 = null;
        }
    }
}