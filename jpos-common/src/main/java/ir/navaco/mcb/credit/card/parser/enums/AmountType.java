package ir.navaco.mcb.credit.card.parser.enums;

import java.util.Arrays;

/**
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public enum AmountType {

    /**
     * مانده واقعی
     */
    REAL_BALANCE(1L, AmountType.realBalance),
    /**
     * مانده در دسترس
     */
    AVAILABLE_BALANCE(2L, AmountType.AvailableBalance),
    /**
     * مانده اعتبار در دسترس
     */
    AVAILABLE_CREDIT(5L, AmountType.availableCredit),
    /**
     * سقف اعتبار
     */
    CREDIT_LIMIT(9L, AmountType.creditLimit),
    /**
     * مانده باقی از سقف عملیات
     */
    REMAIN_CREDIT_OF_LIMIT(20L, AmountType.remainCreditOfLimit);

    AmountType(Long code, String title) {
        this.code = code;
        this.title = title;
    }

    private Long code;
    private String title;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String code) {
        this.title = code;
    }

    public static AmountType findByCode(Long code) {
        return Arrays.asList(values()).stream()
                .filter(type -> type.getCode().equals(code))
                .findFirst().orElse(null);
    }

    public static AmountType findByTitle(String title) {
        return Arrays.asList(values()).stream()
                .filter(type -> type.getTitle().equals(title))
                .findFirst().orElse(null);
    }

    private static final String realBalance = "CC.AmountType.realBalance";
    private static final String AvailableBalance = "CC.AmountType.AvailableBalance";
    private static final String availableCredit = "CC.AmountType.availableCredit";
    private static final String creditLimit = "CC.AmountType.creditLimit";
    private static final String remainCreditOfLimit = "CC.AmountType.remainCreditOfLimit";
}
