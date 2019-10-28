package ir.navaco.mcb.credit.card.database.dto;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class MessagePolicy {
    private long id;
    private int mti;
    private String[] ProcessCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMti() {
        return mti;
    }

    public void setMti(int mti) {
        this.mti = mti;
    }

    public String[] getProcessCode() {
        return ProcessCode;
    }

    public void setProcessCode(String[] jsonProcessCode) {
        this.ProcessCode = jsonProcessCode;
    }
}
