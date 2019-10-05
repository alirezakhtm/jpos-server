package ir.navaco.mcb.credit.card.transaction.channel;

import java.io.IOException;

import org.jpos.iso.BaseChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;

public class CustomChannel extends BaseChannel {

    public CustomChannel(String host, Integer port, ISOPackager packager) {
        super(host, port, packager);
    }

    public CustomChannel() {
        super();
    }

    public CustomChannel(ISOPackager packager) throws IOException {
        super(packager);
    }

    @Override
    protected int getMessageLength() throws IOException, ISOException {
        int length = 0;
        int messageLength = 0;
        byte[] b = new byte[2];
        while (length == 0) {
            serverIn.readFully(b, 0, 2);
            messageLength = (Integer.parseInt(ISOUtil.hexString(b, 0, 1), 16) * 256)
                    + (Integer.parseInt(ISOUtil.hexString(b, 1, 1), 16));
            try {
                if ((length = messageLength) == 0) {
                    serverOut.write(b);
                    serverOut.flush();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new ISOException("Invalid message length " + new String(b) + "length=" + length);
            }
        }
        return length;
    }

    @Override
    protected void sendMessageLength(int len) throws IOException {
        int b0 = len / 256;
        int b1 = len % 256;
        byte[] b = new byte[2];
        b[0] = ISOUtil.hex2byte(Integer.toHexString(b0))[0];
        b[1] = ISOUtil.hex2byte(Integer.toHexString(b1))[0];
        serverOut.write(b);
    }

}