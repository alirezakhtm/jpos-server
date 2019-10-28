package ir.navaco.mcb.credit.card.database.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
@Entity
@Table(name = "tbl_policy", schema = "dbjpos", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "MTI_NUMBER")
})
public class MessagePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private long id;
    @Column(name = "MTI_NUMBER", unique = true, nullable = false)
    private int mti;
    // this parameter contains a list as json format
    @Column(name = "PROCESS_CODE", unique = false, nullable = false)
    private String jsonProcessCode;

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

    public String getJsonProcessCode() {
        return jsonProcessCode;
    }

    public void setJsonProcessCode(String jsonProcessCode) {
        this.jsonProcessCode = jsonProcessCode;
    }
}
