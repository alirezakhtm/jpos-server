package ir.navaco.mcb.credit.card.parser.enums;

import java.util.Arrays;

/**
 * @author Behrooz Mohamadi <behroooz.mohamadi@gmail.com>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public enum TxProcessCodeType {

    /**
     * خرید کالا و خدمات
     */
    PURCHASE(0, 000000L, TxProcessCodeType.PURCHASE_CAPTION),
    /**
     * دریافت وجه نقد
     */
    CASH_RECEIVE(1, 10000L, TxProcessCodeType.CASH_RECEIVE_CAPTION),
    /**
     * کارمزد مانده گیری شتابی
     */
    SHETAB_REMAIN_CREDIT_WAGE(2, 100000L, TxProcessCodeType.SHETAB_REMAIN_CREDIT_WAGE_CAPTION),
    /**
     * ایجاد قبض برداشت بدون کارت
     */
    WITHDRAW_CREATION_WITHOUT_CARD(3, 120000L, TxProcessCodeType.WITHDRAW_CREATION_WITHOUT_CARD_CAPTION),
    /**
     * کسر وجه از کارت برای شارژ کیوا
     */
    MONEY_DEDUCTION_FROM_CARD_FOR_KIVA(4, 130000L, TxProcessCodeType.MONEY_DEDUCTION_FROM_CARD_FOR_KIVA_CAPTION),
    /**
     * ابطال قبض برداشت بدون کارت
     */
    WITHDRAW_REVOCATION_WITHOUT_CARD(5, 160000L, TxProcessCodeType.WITHDRAW_REVOCATION_WITHOUT_CARD_CAPTION),
    /**
     * برداشت از پایانه شعبه ای
     */
    MONY_WITHDRAW_BRANCH_TERMINAL(6, 170000L, TxProcessCodeType.MONY_WITHDRAW_BRANCH_TERMINAL_CAPTION),
    /**
     * واریز نقدی از طریق پایانه شعبه ای
     */
    DEPOSIT_CASH_BRANCH_TERMINAL(7, 180000L, TxProcessCodeType.DEPOSIT_CASH_BRANCH_TERMINAL_CAPTION),
    /**
     * برگشت از خرید
     */
    RETURN_FROM_PURCHASE(8, 200000L, TxProcessCodeType.RETURN_FROM_PURCHASE_CAPTION),
    /**
     * واریز وجه دشارژ شده کیوا به کارت
     */
    DEPOSIT_MONEY_DECHARGED_KIVA_TO_CARD(9, 276000L, TxProcessCodeType.DEPOSIT_MONEY_DECHARGED_KIVA_TO_CARD_CAPTION),
    /**
     * واریز وجه شارژ به کیوا
     */
    DEPOSIT_CASH_CHARGED_TO_KIVA(10, 280060L, TxProcessCodeType.DEPOSIT_CASH_CHARGED_TO_KIVA_CAPTION),
    /**
     * درخواست مانده حساب
     */
    REQUEST_REMAINING_ACCOUNT(11, 310000L, TxProcessCodeType.REQUEST_REMAINING_ACCOUNT_CAPTION),
    /**
     * درخواست بررسی حساب
     */
    REQUEST_CHECK_ACCOUNT(12, 320000L, TxProcessCodeType.REQUEST_CHECK_ACCOUNT_CAPTION),
    /**
     * درخواست بررسی کارت و حساب
     */
    REQUEST_CHECK_CARD_ACCOUNT(13, 330000L, TxProcessCodeType.REQUEST_CHECK_CARD_ACCOUNT_CAPTION),
    /**
     * درخواست بررسی کیوا
     */
    REQUEST_CHECK_KIVA(14, 336000L, TxProcessCodeType.REQUEST_CHECK_KIVA_CAPTION),
    /**
     * درخواست چکیده صورت حساب
     */
    REQUEST_BILLING_SUMMARY(15, 340000L, TxProcessCodeType.REQUEST_BILLING_SUMMARY_CAPTION),
    /**
     * انسداد کارت
     */
    CARD_BLOCKAGE(16, 350000L, TxProcessCodeType.CARD_BLOCKAGE_CAPTION),
    /**
     * تغییر حساب پیشفرض
     */
    CHANGE_DEFAULT_ACCOUNT(17, 360000L, TxProcessCodeType.CHANGE_DEFAULT_ACCOUNT_CAPTION),
    /**
     * صورتحساب جزئی
     */
    MINOR_REMAIN_REQUEST(18, 380000L, TxProcessCodeType.MINOR_REMAIN_REQUEST_CAPTION),
    /**
     * درخواست انتقال وجه بین دوکارت
     */
    REQUEST_TRANSFERRING_BETWEEN_CARDS(19, 400000L, TxProcessCodeType.REQUEST_TRANSFERRING_BETWEEN_CARDS_CAPTION),
    /**
     * انتقال شتابی پایانه شعبه ای
     */
    SHETAB_BRANCH_TERMINAL_TRANSFERRING(20, 410000L, TxProcessCodeType.SHETAB_BRANCH_TERMINAL_TRANSFERRING_CAPTION),
    /**
     * انتقال شتابی خودپرداز
     */
    SHETAB_ATM_TRANSFERRING(21, 420000L, TxProcessCodeType.SHETAB_ATM_TRANSFERRING_CAPTION),
    /**
     * انتقال وجه از
     */
    TRANSFERRING_FUND_FROM(22, 460000L, TxProcessCodeType.TRANSFERRING_FUND_FROM_CAPTION),
    /**
     * انتقال وجه به
     */
    TRANSFERRING_FUND_TO(23, 470000L, TxProcessCodeType.TRANSFERRING_FUND_TO_CAPTION),
    /**
     * پرداخت
     */
    PAYMENT(24, 500000L, TxProcessCodeType.PAYMENT_CAPTION),
    /**
     * خرید شارژ خودپرداز
     */
    CHARGE_PURCHASE_ATM(25, 520000L, TxProcessCodeType.CHARGE_PURCHASE_ATM_CAPTION),
    /**
     * خرید شارژ عوارض خودپرداز
     */
    CHARGE_PURCHASE_ETC_ATM(26, 530000L, TxProcessCodeType.CHARGE_PURCHASE_ETC_ATM_CAPTION),
    /**
     * خرید شارژ مستقیم خودپرداز
     */
    DIRECT_CHARGE_PURCHASE_ATM(27, 540000L, TxProcessCodeType.DIRECT_CHARGE_PURCHASE_ATM_CAPTION),
    /**
     * خرید شارژ - درگاههای مجاز
     */
    CHARGE_PURCHASE_AUTHORIZED_PORT(28, 550000L, TxProcessCodeType.CHARGE_PURCHASE_AUTHORIZED_PORT_CAPTION),
    /**
     * درخواست حواله ساتنا
     */
    SATNA_REMITTANCE_REQUEST(29, 580000L, TxProcessCodeType.SATNA_REMITTANCE_REQUEST_CAPTION),
    /**
     * درخواست حواله پایا
     */
    PAYA_REMITTANCE_REQUEST(30, 590000L, TxProcessCodeType.PAYA_REMITTANCE_REQUEST_CAPTION),
    /**
     * درخواست شارژ کیپا
     */
    REQUEST_CHARGE_KIPA(31, 600060L, TxProcessCodeType.REQUEST_CHARGE_KIPA_CAPTION),
    /**
     * درخواست تایید رمز کارت
     */
    REQUEST_CARD_CONFIRM_PASSWORD(32, 710000L, TxProcessCodeType.REQUEST_CARD_CONFIRM_PASSWORD_CAPTION),
    /**
     * رفع یا اصلاح مغایرت
     */
    FIX_MODIFY_RECONCILIATION(33, 900000L, TxProcessCodeType.FIX_MODIFY_RECONCILIATION_CAPTION),
    /**
     * صورتحساب یارانه
     */
    SUBSID_FACTURE(34, 970000L, TxProcessCodeType.SUBSID_FACTURE_CAPTION),

    VALIDITY_CODE_30 (35, 300000L, TxProcessCodeType.MESSAGE_1100_VALIDITY_CODE_30),
    VALIDITY_CODE_66 (38, 660000L, TxProcessCodeType.MESSAGE_1100_VALIDITY_CODE_66),
    VALIDITY_CODE_67 (39, 670000L, TxProcessCodeType.MESSAGE_1100_VALIDITY_CODE_67),
    VALIDITY_CODE_68 (40, 680000L, TxProcessCodeType.MESSAGE_1100_VALIDITY_CODE_68),
    VALIDITY_CODE_96 (41, 960000L, TxProcessCodeType.MESSAGE_1100_VALIDITY_CODE_96),

    VALIDITY_CODE_91 (47, 910000L, TxProcessCodeType.MESSAGE_1200_VALIDITY_CODE_91),
    VALIDITY_CODE_99 (48, 990000L, TxProcessCodeType.MESSAGE_1200_VALIDITY_CODE_99);


    TxProcessCodeType(Integer id, Long code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static TxProcessCodeType findByCode(Long code) {
        return Arrays.asList(values()).stream()
                .filter(txProcessCodeType -> txProcessCodeType.code.equals(code))
                .findFirst().orElse(null);
    }

    public static TxProcessCodeType findById(Integer id) {
        return Arrays.asList(values()).stream()
                .filter(txProcessCodeType -> txProcessCodeType.id.equals(id))
                .findFirst().orElse(null);
    }

    private static final String PURCHASE_CAPTION = "CC.TxProcessCodeType.PURCHASE";
    private static final String CASH_RECEIVE_CAPTION = "CC.TxProcessCodeType.CASH_RECEIVE";
    private static final String SHETAB_REMAIN_CREDIT_WAGE_CAPTION = "CC.TxProcessCodeType.SHETAB_REMAIN_CREDIT_WAGE";
    private static final String WITHDRAW_CREATION_WITHOUT_CARD_CAPTION = "CC.TxProcessCodeType.WITHDRAW_CREATION_WITHOUT_CARD";
    private static final String MONEY_DEDUCTION_FROM_CARD_FOR_KIVA_CAPTION = "CC.TxProcessCodeType.MONEY_DEDUCTION_FROM_CARD_FOR_KIVA";
    private static final String WITHDRAW_REVOCATION_WITHOUT_CARD_CAPTION = "CC.TxProcessCodeType.WITHDRAW_REVOCATION_WITHOUT_CARD";
    private static final String MONY_WITHDRAW_BRANCH_TERMINAL_CAPTION = "CC.TxProcessCodeType.MONY_WITHDRAW_BRANCH_TERMINAL";
    private static final String DEPOSIT_CASH_BRANCH_TERMINAL_CAPTION = "CC.TxProcessCodeType.DEPOSIT_CASH_BRANCH_TERMINAL";
    private static final String RETURN_FROM_PURCHASE_CAPTION = "CC.TxProcessCodeType.RETURN_FROM_PURCHASE";
    private static final String DEPOSIT_MONEY_DECHARGED_KIVA_TO_CARD_CAPTION = "CC.TxProcessCodeType.DEPOSIT_MONEY_DECHARGED_KIVA_TO_CARD";
    private static final String DEPOSIT_CASH_CHARGED_TO_KIVA_CAPTION = "CC.TxProcessCodeType.DEPOSIT_CASH_CHARGED_TO_KIVA";
    private static final String REQUEST_REMAINING_ACCOUNT_CAPTION = "CC.TxProcessCodeType.REQUEST_REMAINING_ACCOUNT";
    private static final String REQUEST_CHECK_ACCOUNT_CAPTION = "CC.TxProcessCodeType.REQUEST_CHECK_ACCOUNT";
    private static final String REQUEST_CHECK_CARD_ACCOUNT_CAPTION = "CC.TxProcessCodeType.REQUEST_CHECK_CARD_ACCOUNT";
    private static final String REQUEST_CHECK_KIVA_CAPTION = "CC.TxProcessCodeType.REQUEST_CHECK_KIVA";
    private static final String REQUEST_BILLING_SUMMARY_CAPTION = "CC.TxProcessCodeType.REQUEST_BILLING_SUMMARY";
    private static final String CARD_BLOCKAGE_CAPTION = "CC.TxProcessCodeType.CARD_BLOCKAGE";
    private static final String CHANGE_DEFAULT_ACCOUNT_CAPTION = "CC.TxProcessCodeType.CHANGE_DEFAULT_ACCOUNT";
    private static final String MINOR_REMAIN_REQUEST_CAPTION = "CC.TxProcessCodeType.MINOR_REMAIN_REQUEST";
    private static final String REQUEST_TRANSFERRING_BETWEEN_CARDS_CAPTION = "CC.TxProcessCodeType.REQUEST_TRANSFERRING_BETWEEN_CARDS";
    private static final String SHETAB_BRANCH_TERMINAL_TRANSFERRING_CAPTION = "CC.TxProcessCodeType.SHETAB_BRANCH_TERMINAL_TRANSFERRING";
    private static final String SHETAB_ATM_TRANSFERRING_CAPTION = "CC.TxProcessCodeType.SHETAB_ATM_TRANSFERRING";
    private static final String TRANSFERRING_FUND_FROM_CAPTION = "CC.TxProcessCodeType.TRANSFERRING_FUND_FROM";
    private static final String TRANSFERRING_FUND_TO_CAPTION = "CC.TxProcessCodeType.TRANSFERRING_FUND_TO";
    private static final String PAYMENT_CAPTION = "CC.TxProcessCodeType.PAYMENT";
    private static final String CHARGE_PURCHASE_ATM_CAPTION = "CC.TxProcessCodeType.CHARGE_PURCHASE_ATM";
    private static final String CHARGE_PURCHASE_ETC_ATM_CAPTION = "CC.TxProcessCodeType.CHARGE_PURCHASE_ETC_ATM";
    private static final String DIRECT_CHARGE_PURCHASE_ATM_CAPTION = "CC.TxProcessCodeType.DIRECT_CHARGE_PURCHASE_ATM";
    private static final String CHARGE_PURCHASE_AUTHORIZED_PORT_CAPTION = "CC.TxProcessCodeType.CHARGE_PURCHASE_AUTHORIZED_PORT";
    private static final String SATNA_REMITTANCE_REQUEST_CAPTION = "CC.TxProcessCodeType.SATNA_REMITTANCE_REQUEST";
    private static final String PAYA_REMITTANCE_REQUEST_CAPTION = "CC.TxProcessCodeType.PAYA_REMITTANCE_REQUEST";
    private static final String REQUEST_CHARGE_KIPA_CAPTION = "CC.TxProcessCodeType.REQUEST_CHARGE_KIPA";
    private static final String REQUEST_CARD_CONFIRM_PASSWORD_CAPTION = "CC.TxProcessCodeType.REQUEST_CARD_CONFIRM_PASSWORD";
    private static final String FIX_MODIFY_RECONCILIATION_CAPTION = "CC.TxProcessCodeType.FIX_MODIFY_RECONCILIATION";
    private static final String SUBSID_FACTURE_CAPTION = "CC.TxProcessCodeType.SUBSID_FACTURE";
    // these codes have been added to receive all validity code according to table
    // has been sent by Maskan Bank experts.
    private static final String MESSAGE_1100_VALIDITY_CODE_66 = "VC.TxProcessCodeType.66";
    private static final String MESSAGE_1100_VALIDITY_CODE_67 = "VC.TxProcessCodeType.67";
    private static final String MESSAGE_1100_VALIDITY_CODE_30 = "VC.TxProcessCodeType.30";
    private static final String MESSAGE_1100_VALIDITY_CODE_96 = "VC.TxProcessCodeType.96";
    private static final String MESSAGE_1100_VALIDITY_CODE_68 = "VC.TxProcessCodeType.68";
    private static final String MESSAGE_1200_VALIDITY_CODE_99 = "VC.TxProcessCodeType.99";
    private static final String MESSAGE_1200_VALIDITY_CODE_91 = "VC.TxProcessCodeType.91";
}
