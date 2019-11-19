package ir.navaco.mcb.credit.card.parser.enums;

import java.util.Arrays;

/**
 * انواع پیام
 *
 * @author n.ranjbaran
 * @author sa.gholizadeh
 */
public enum MessageType {
    /**
     * درخواست تاییدیه و بررسی
     */
    MTI_1100(0, 1100, MessageType.messageType1100),
    /**
     * پاسخ به درخواست تاییدیه و بررسی
     */
    MTI_1110(1, 1110, MessageType.messageType1110),
    /**
     * درخواست انجام تراکنش مالی
     */
    MTI_1200(2, 1200, MessageType.messageType1200),
    /**
     * پاسخ به درخواست انجام تراکنش مالی
     */
    MTI_1210(3, 1210, MessageType.messageType1210),
    /**
     * تایید انجام تراکنش مالی
     */
    MTI_1220(4, 1220, MessageType.messageType1220),
    /**
     * پاسخ به تایید انجام تراکنش مالی
     */
    MTI_1230(5, 1230, MessageType.messageType1230),
    /**
     * درخواست اصلاحیه تراکنش مالی
     */
    MTI_1420(6, 1420, MessageType.messageType1420),
    /**
     * پاسخ به درخواست اصلاحیه تراکنش مالی
     */
    MTI_1430(7, 1430, MessageType.messageType1430),
    /**
     * درخواست تاییدیه و بررسی
     */
    MTI_1604(8, 1604, MessageType.messageType1604),
    /**
     * پاسخ به درخواست تاییدیه و بررسی
     */
    MTI_1614(9, 1614, MessageType.messageType1614),
    /**
     * تراکنش مدیریت شبکه
     */
    MTI_1804(10, 1804, MessageType.messageType1804),
    /**
     * پاسخ تراکنش مدیریت شبکه
     */
    MTI_1814(11, 1814, MessageType.messageType1814);


    MessageType(Integer id, Integer code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    private Integer id;
    private Integer code;
    private String title;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
//        return MessageSourceUtils.getMessage(title);
        return null;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static MessageType findById(Integer id) {
        return Arrays
                .stream(values())
                .filter(mt -> mt.id.equals(id))
                .findFirst().orElse(null);
    }

    public static MessageType findByCode(Integer code) {
        return Arrays
                .stream(values())
                .filter(mt -> mt.code.equals(code))
                .findFirst().orElse(null);
    }

    public static MessageType findByTitle(String title) {
        return Arrays
                .stream(values())
                .filter(mt -> mt.getTitle().equals(title))
                .findFirst().orElse(null);
    }

    /*@Override
    public Long getUniqueId() {
        return id.longValue();
    }*/

    private static final String messageType1100 = "CC.MessageType.messageType1100";
    private static final String messageType1110 = "CC.MessageType.messageType1110";
    private static final String messageType1200 = "CC.MessageType.messageType1200";
    private static final String messageType1210 = "CC.MessageType.messageType1210";
    private static final String messageType1220 = "CC.MessageType.messageType1220";
    private static final String messageType1230 = "CC.MessageType.messageType1230";
    private static final String messageType1420 = "CC.MessageType.messageType1420";
    private static final String messageType1430 = "CC.MessageType.messageType1430";
    private static final String messageType1604 = "CC.MessageType.messageType1604";
    private static final String messageType1614 = "CC.MessageType.messageType1614";
    private static final String messageType1804 = "CC.MessageType.messageType1804";
    private static final String messageType1814 = "CC.MessageType.messageType1814";
}
