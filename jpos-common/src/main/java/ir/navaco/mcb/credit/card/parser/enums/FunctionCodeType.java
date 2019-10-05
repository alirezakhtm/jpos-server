package ir.navaco.mcb.credit.card.parser.enums;



public enum FunctionCodeType {
    CONFIRM_PURCHASE_REQUEST(1L, 100,FunctionCodeType.CONFIRM_PURCHASE_REQUEST_CAPTION),
    CONFIRM_PURCHASE_REPLACE_REQUEST(2L, 102,FunctionCodeType.CONFIRM_PURCHASE_REPLACE_REQUEST_CAPTION),
    CONFIRM_PURCHASE_SUPPLEMENT_REQUEST(3L, 106,FunctionCodeType.CONFIRM_PURCHASE_SUPPLEMENT_REQUEST_CAPTION),
    REMAIN_REQUEST(4L, 108,FunctionCodeType.REMAIN_REQUEST_CAPTION),
    ADDRESS_CHECK_REQUEST(5L, 109,FunctionCodeType.ADDRESS_CHECK_REQUEST_CAPTION),
    CHECK_REQUEST(6L, 113,FunctionCodeType.CHECK_REQUEST_CAPTION),
    PASSWORD_CONFIRM_REQUEST(7L, 180,FunctionCodeType.PASSWORD_CONFIRM_REQUEST_CAPTION),
    SHEBA_CHECK_REQUEST(8L, 181,FunctionCodeType.SHEBA_CHECK_REQUEST_CAPTION),
    CHECK_CARD_HOLDER_INFO_REQUEST(9L, 182,FunctionCodeType.CHECK_CARD_HOLDER_INFO_REQUEST_CAPTION),
    FINANCIAL_REQUEST(10L, 200,FunctionCodeType.FINANCIAL_REQUEST_CAPTION),
    EQUAL_AMOUNT_CONFIRMED_PURCHASE(11L, 201,FunctionCodeType.EQUAL_AMOUNT_CONFIRMED_PURCHASE_CAPTION),
    LESS_AMOUNT_CONFIRMED_PURCHASE(12L, 202,FunctionCodeType.LESS_AMOUNT_CONFIRMED_PURCHASE_CAPTION),
    FIN_COMPLETE_RETURN_TX(13L, 260,FunctionCodeType.FIN_COMPLETE_RETURN_TX_CAPTION),
    FIN_PARTIAL_RETURN_TX(14L, 261,FunctionCodeType.FIN_PARTIAL_RETURN_TX_CAPTION),
    FIN_WITHDRAW_FOR_RETURN_TX(15L, 262,FunctionCodeType.FIN_WITHDRAW_FOR_RETURN_TX_CAPTION),
    FIN_SHETAB_TX(16L, 270,FunctionCodeType.FIN_SHETAB_TX_CAPTION),
    FIN_PUBLIC_SERVICES_BILL(17L, 280,FunctionCodeType.FIN_PUBLIC_SERVICES_BILL_CAPTION),
    FIN_INSTALLMENT_TX(18L, 281,FunctionCodeType.FIN_INSTALLMENT_TX_CAPTION),
    FIN_CHARGE_CARD_PAYMENT(19L, 282,FunctionCodeType.FIN_CHARGE_CARD_PAYMENT_CAPTION),
    FIN_SPECIAL_BILL_TX(20L, 283,FunctionCodeType.FIN_SPECIAL_BILL_TX_CAPTION),
    FIN_CARD_TO_ACCOUNT_REQUEST(21L, 285,FunctionCodeType.FIN_CARD_TO_ACCOUNT_REQUEST_CAPTION),
    FIN_CARD_TO_ACCOUNT_TRANSFER_TX(22L, 286,FunctionCodeType.FIN_CARD_TO_ACCOUNT_TRANSFER_TX_CAPTION),
    FIN_TRANSFER_TO_ACCOUNT_TX(23L, 287,FunctionCodeType.FIN_TRANSFER_TO_ACCOUNT_TX_CAPTION),
    FIN_FIXING_DEPOSIT_TO_CARD(24L, 290,FunctionCodeType.FIN_FIXING_DEPOSIT_TO_CARD_CAPTION),
    FIN_FIXING_WITHDRAW_FROM_CARD(25L, 291,FunctionCodeType.FIN_FIXING_WITHDRAW_FROM_CARD_CAPTION),
    FIN_FIXING_DEPOSIT_TO_ACCOUNT(26L, 292,FunctionCodeType.FIN_FIXING_DEPOSIT_TO_ACCOUNT_CAPTION),
    FIN_FIXING_WITHDRAW_ACCOUNT(27L, 293,FunctionCodeType.FIN_FIXING_WITHDRAW_ACCOUNT_CAPTION),
    FIN_FIXING_DEPOSIT_TO_CARD_NOCHECK(28L, 294,FunctionCodeType.FIN_FIXING_DEPOSIT_TO_CARD_NOCHECK_CAPTION),
    FIN_FIXING_WITHDRAW_FROM_CARD_NOCHECK(29L, 295,FunctionCodeType.FIN_FIXING_WITHDRAW_FROM_CARD_NOCHECK_CAPTION),
    FIN_FIXING_DEPOSIT_TO_ACCOUNT_NOCHECK(30L, 296,FunctionCodeType.FIN_FIXING_DEPOSIT_TO_ACCOUNT_NOCHECK_CAPTION),
    FIN_FIXING_WITHDRAW_ACCOUNT_NOCHECK(31L, 297,FunctionCodeType.FIN_FIXING_WITHDRAW_ACCOUNT_NOCHECK_CAPTION),
    FIX_COMPLETE_AMOUNT(32L, 400,FunctionCodeType.FIX_COMPLETE_AMOUNT_CAPTION),
    FIX_PARTIAL_AMOUNT(33L, 401,FunctionCodeType.FIX_PARTIAL_AMOUNT_CAPTION),
    FIX_COMPLETE_WITHDRAW_ACCOUNT_TX(34L, 494,FunctionCodeType.FIX_COMPLETE_WITHDRAW_ACCOUNT_TX_CAPTION),
    FIX_COMPLETE_CARD_TO_ACCOUNT_TRANSFER_REQUEST(35L, 495,FunctionCodeType.FIX_COMPLETE_CARD_TO_ACCOUNT_TRANSFER_REQUEST_CAPTION),
    FIX_COMPLETE_CARD_TO_ACCOUNT_TRANSFER_TX(36L, 496,FunctionCodeType.FIX_COMPLETE_CARD_TO_ACCOUNT_TRANSFER_TX_CAPTION),
    FIX_COMPLETE_TO_ACCOUNT_TRANSFER_TX(37L, 497,FunctionCodeType.FIX_COMPLETE_TO_ACCOUNT_TRANSFER_TX_CAPTION),
    ACCOUNTS_CONFRONTING(38L, 500,FunctionCodeType.ACCOUNTS_CONFRONTING_CAPTION),
    SIGN_ON(39L, 801,FunctionCodeType.SIGN_ON_CAPTION),
    SIGN_OFF(40L, 802,FunctionCodeType.SIGN_OFF_CAPTION),
    SECURITY_ALERT(41L, 812,FunctionCodeType.SECURITY_ALERT_CAPTION),
    KEY_CHANGE(42L, 815,FunctionCodeType.KEY_CHANGE_CAPTION),
    END_OF_BUSINESS_DAY(43L, 821,FunctionCodeType.END_OF_BUSINESS_DAY_CAPTION),
    ECHO_TEST(44L, 831,FunctionCodeType.ECHO_TEST_CAPTION);

    FunctionCodeType(Long id, Integer code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    private Long id;
    private Integer code;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public static FunctionCodeType findByCode(Integer code) {
        for (FunctionCodeType type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static FunctionCodeType findByTitle(String title) {
        for (FunctionCodeType type : values()) {
            if (type.getTitle().equals(title)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return code.toString();
    }

    /*@Override
    public Long getUniqueId() {
        return id;
    }*/

    //Shetab Doc V7.1 Table 36 for all transaction
    private static final String CONFIRM_PURCHASE_REQUEST_CAPTION = "CC.functionCodeType.CONFIRM_PURCHASE_REQUEST_CAPTION";
    private static final String CONFIRM_PURCHASE_REPLACE_REQUEST_CAPTION = "CC.functionCodeType.CONFIRM_PURCHASE_REPLACE_REQUEST_CAPTION";
    private static final String CONFIRM_PURCHASE_SUPPLEMENT_REQUEST_CAPTION = "CC.functionCodeType.CONFIRM_PURCHASE_SUPPLEMENT_REQUEST_CAPTION";
    private static final String REMAIN_REQUEST_CAPTION = "CC.functionCodeType.REMAIN_REQUEST_CAPTION";
    private static final String ADDRESS_CHECK_REQUEST_CAPTION = "CC.functionCodeType.ADDRESS_CHECK_REQUEST_CAPTION";
    private static final String CHECK_REQUEST_CAPTION = "CC.functionCodeType.CHECK_REQUEST_CAPTION";
    private static final String PASSWORD_CONFIRM_REQUEST_CAPTION = "CC.functionCodeType.PASSWORD_CONFIRM_REQUEST_CAPTION";
    private static final String SHEBA_CHECK_REQUEST_CAPTION = "CC.functionCodeType.SHEBA_CHECK_REQUEST_CAPTION";
    private static final String CHECK_CARD_HOLDER_INFO_REQUEST_CAPTION = "CC.functionCodeType.CHECK_CARD_HOLDER_INFO_REQUEST_CAPTION";
    private static final String FINANCIAL_REQUEST_CAPTION = "CC.functionCodeType.FINANCIAL_REQUEST_CAPTION";
    private static final String EQUAL_AMOUNT_CONFIRMED_PURCHASE_CAPTION = "CC.functionCodeType.EQUAL_AMOUNT_CONFIRMED_PURCHASE_CAPTION";
    private static final String LESS_AMOUNT_CONFIRMED_PURCHASE_CAPTION = "CC.functionCodeType.LESS_AMOUNT_CONFIRMED_PURCHASE_CAPTION";
    private static final String FIN_COMPLETE_RETURN_TX_CAPTION = "CC.functionCodeType.FIN_COMPLETE_RETURN_TX_CAPTION";
    private static final String FIN_PARTIAL_RETURN_TX_CAPTION = "CC.functionCodeType.FIN_PARTIAL_RETURN_TX_CAPTION";
    private static final String FIN_WITHDRAW_FOR_RETURN_TX_CAPTION = "CC.functionCodeType.FIN_WITHDRAW_FOR_RETURN_TX_CAPTION";
    private static final String FIN_SHETAB_TX_CAPTION = "CC.functionCodeType.FIN_SHETAB_TX_CAPTION";
    private static final String FIN_PUBLIC_SERVICES_BILL_CAPTION = "CC.functionCodeType.FIN_PUBLIC_SERVICES_BILL_CAPTION";
    private static final String FIN_INSTALLMENT_TX_CAPTION = "CC.functionCodeType.FIN_INSTALLMENT_TX_CAPTION";
    private static final String FIN_CHARGE_CARD_PAYMENT_CAPTION = "CC.functionCodeType.FIN_CHARGE_CARD_PAYMENT_CAPTION";
    private static final String FIN_SPECIAL_BILL_TX_CAPTION = "CC.functionCodeType.FIN_SPECIAL_BILL_TX_CAPTION";
    private static final String FIN_CARD_TO_ACCOUNT_REQUEST_CAPTION = "CC.functionCodeType.FIN_CARD_TO_ACCOUNT_REQUEST_CAPTION";
    private static final String FIN_CARD_TO_ACCOUNT_TRANSFER_TX_CAPTION = "CC.functionCodeType.FIN_CARD_TO_ACCOUNT_TRANSFER_TX_CAPTION";
    private static final String FIN_TRANSFER_TO_ACCOUNT_TX_CAPTION = "CC.functionCodeType.FIN_TRANSFER_TO_ACCOUNT_TX_CAPTION";
    private static final String FIN_FIXING_DEPOSIT_TO_CARD_CAPTION = "CC.functionCodeType.FIN_FIXING_DEPOSIT_TO_CARD_CAPTION";
    private static final String FIN_FIXING_WITHDRAW_FROM_CARD_CAPTION = "CC.functionCodeType.FIN_FIXING_WITHDRAW_FROM_CARD_CAPTION";
    private static final String FIN_FIXING_DEPOSIT_TO_ACCOUNT_CAPTION = "CC.functionCodeType.FIN_FIXING_DEPOSIT_TO_ACCOUNT_CAPTION";
    private static final String FIN_FIXING_WITHDRAW_ACCOUNT_CAPTION = "CC.functionCodeType.FIN_FIXING_WITHDRAW_ACCOUNT_CAPTION";
    private static final String FIN_FIXING_DEPOSIT_TO_CARD_NOCHECK_CAPTION = "CC.functionCodeType.FIN_FIXING_DEPOSIT_TO_CARD_NOCHECK_CAPTION";
    private static final String FIN_FIXING_WITHDRAW_FROM_CARD_NOCHECK_CAPTION = "CC.functionCodeType.FIN_FIXING_WITHDRAW_FROM_CARD_NOCHECK_CAPTION";
    private static final String FIN_FIXING_DEPOSIT_TO_ACCOUNT_NOCHECK_CAPTION = "CC.functionCodeType.FIN_FIXING_DEPOSIT_TO_ACCOUNT_NOCHECK_CAPTION";
    private static final String FIN_FIXING_WITHDRAW_ACCOUNT_NOCHECK_CAPTION = "CC.functionCodeType.FIN_FIXING_WITHDRAW_ACCOUNT_NOCHECK_CAPTION";
    private static final String FIX_COMPLETE_AMOUNT_CAPTION = "CC.functionCodeType.FIX_COMPLETE_AMOUNT_CAPTION";
    private static final String FIX_PARTIAL_AMOUNT_CAPTION = "CC.functionCodeType.FIX_PARTIAL_AMOUNT_CAPTION";
    private static final String FIX_COMPLETE_WITHDRAW_ACCOUNT_TX_CAPTION = "CC.functionCodeType.FIX_COMPLETE_WITHDRAW_ACCOUNT_TX_CAPTION";
    private static final String FIX_COMPLETE_CARD_TO_ACCOUNT_TRANSFER_REQUEST_CAPTION = "CC.functionCodeType.FIX_COMPLETE_CARD_TO_ACCOUNT_TRANSFER_REQUEST_CAPTION";
    private static final String FIX_COMPLETE_CARD_TO_ACCOUNT_TRANSFER_TX_CAPTION = "CC.functionCodeType.FIX_COMPLETE_CARD_TO_ACCOUNT_TRANSFER_TX_CAPTION";
    private static final String FIX_COMPLETE_TO_ACCOUNT_TRANSFER_TX_CAPTION = "CC.functionCodeType.FIX_COMPLETE_TO_ACCOUNT_TRANSFER_TX_CAPTION";
    private static final String ACCOUNTS_CONFRONTING_CAPTION = "CC.functionCodeType.ACCOUNTS_CONFRONTING_CAPTION";
    private static final String SIGN_ON_CAPTION = "CC.functionCodeType.SIGN_ON_CAPTION";
    private static final String SIGN_OFF_CAPTION = "CC.functionCodeType.SIGN_OFF_CAPTION";
    private static final String SECURITY_ALERT_CAPTION = "CC.functionCodeType.SECURITY_ALERT_CAPTION";
    private static final String KEY_CHANGE_CAPTION = "CC.functionCodeType.KEY_CHANGE_CAPTION";
    private static final String END_OF_BUSINESS_DAY_CAPTION = "CC.functionCodeType.END_OF_BUSINESS_DAY_CAPTION";
    private static final String ECHO_TEST_CAPTION = "CC.functionCodeType.ECHO_TEST_CAPTION";
}
