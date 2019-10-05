package ir.navaco.mcb.credit.card.parser.enums;

public enum TxProcessStatusType {
    TX_SUCCESSFUL(0, TxProcessStatusType.TX_SUCCESSFUL_CAPTION),
    TX_IGNORE(100, TxProcessStatusType.TX_IGNORE_CAPTION),
    CARD_EXPIRED(101, TxProcessStatusType.CARD_EXPIRED_CAPTION),
    FAKE_TX(102, TxProcessStatusType.FAKE_TX_CAPTION),
    CARD_LIMITED(104, TxProcessStatusType.CARD_LIMITED_CAPTION),
    OVER_TRY_PASS_COUNT(106, TxProcessStatusType.OVER_TRY_PASS_COUNT_CAPTION),
    INVALID_CARD_RECEIVER(109, TxProcessStatusType.INVALID_CARD_RECEIVER_CAPTION),
    INVALID_AMOUNT(110, TxProcessStatusType.INVALID_AMOUNT_CAPTION),
    WRONG_CARD_NUMBER(111, TxProcessStatusType.WRONG_CARD_NUMBER_CAPTION),
    PASS_INFO_NEEDED(112, TxProcessStatusType.PASS_INFO_NEEDED_CAPTION),
    INVALID_RECEIVER_FEE(113, TxProcessStatusType.INVALID_RECEIVER_FEE_CAPTION),
    ACCOUNT_NOT_FOUND(114, TxProcessStatusType.ACCOUNT_NOT_FOUND_CAPTION),
    FUNCTION_NOT_SUPPORTED(115, TxProcessStatusType.FUNCTION_NOT_SUPPORTED_CAPTION),
    NOT_ENOUGH_ACCOUNT_BALANCE(116, TxProcessStatusType.NOT_ENOUGH_ACCOUNT_BALANCE_CAPTION),
    WRONG_PASS(117, TxProcessStatusType.WRONG_PASS_CAPTION),
    CARD_INFO_NOT_FOUND(118, TxProcessStatusType.CARD_INFO_NOT_FOUND_CAPTION),
    CARD_OWNER_IS_NOT_ALLOWED(119, TxProcessStatusType.CARD_OWNER_IS_NOT_ALLOWED_CAPTION),
    TERMINAL_IS_NOT_ALLOWED(120, TxProcessStatusType.TERMINAL_IS_NOT_ALLOWED_CAPTION),
    AMOUNT_OVER_LIMIT(121, TxProcessStatusType.AMOUNT_OVER_LIMIT_CAPTION),
    SECURITY_VIOLATED(122, TxProcessStatusType.SECURITY_VIOLATED_CAPTION),
    TRY_COUNT_OVER_LIMITED(123, TxProcessStatusType.TRY_COUNT_OVER_LIMITED_CAPTION),
    RULES_IS_FAILED(124, TxProcessStatusType.RULES_IS_FAILED_CAPTION),
    CARD_IS_NOT_ACTIVE(125, TxProcessStatusType.CARD_IS_NOT_ACTIVE_CAPTION),
    INVALID_PIN_BLOCK(126, TxProcessStatusType.INVALID_PIN_BLOCK_CAPTION),
    INVALID_PASS_LENGTH(127, TxProcessStatusType.INVALID_PASS_LENGTH_CAPTION),
    INVALID_CARD_KEY(128, TxProcessStatusType.INVALID_CARD_KEY_CAPTION),
    CARD_MAYBE_FAKE(129, TxProcessStatusType.CARD_MAYBE_FAKE_CAPTION),
    CARD_RELATED_ACCOUNT_IS_CLOSED(135, TxProcessStatusType.CARD_RELATED_ACCOUNT_IS_CLOSED_CAPTION),
    INAPPROPRIATE_STATUS_ACCOUNT_OR_CARD_SOURCE(141, TxProcessStatusType.INAPPROPRIATE_STATUS_ACCOUNT_OR_CARD_SOURCE_CAPTION),
    INAPPROPRIATE_STATUS_ACCOUNT_OR_CARD_DESTINATION(142, TxProcessStatusType.INAPPROPRIATE_STATUS_ACCOUNT_OR_CARD_DESTINATION_CAPTION),
    CARD_CONFIRMATION_NOT_SUCCEED(145, TxProcessStatusType.CARD_CONFIRMATION_NOT_SUCCEED_CAPTION),
    TRANSACTION_IS_NOT_SUPPORTED_BY_CARD_ISSUER(161, TxProcessStatusType.TRANSACTION_IS_NOT_SUPPORTED_BY_CARD_ISSUER_CAPTION),
    ORIGINAL_TRANSACTION_HAS_NOT_BEEN_SUCCESSFUL(172, TxProcessStatusType.ORIGINAL_TRANSACTION_HAS_NOT_BEEN_SUCCESSFUL_CAPTION),
    OPERATION_TO_RESOLVE_THIS_TRANSACTION_HAS_ALREADY_BEEN_SUCCESSFUL(182, TxProcessStatusType.OPERATION_TO_RESOLVE_THIS_TRANSACTION_HAS_ALREADY_BEEN_SUCCESSFUL_CAPTION),

    TX_SUCCESSFUL_REFORM(400, TxProcessStatusType.TX_SUCCESSFUL_REFORM_CAPTION),
    REFORM_NOT_ENOUGH_ACCOUNT_BALANCE(416, TxProcessStatusType.REFORM_NOT_ENOUGH_ACCOUNT_BALANCE_CAPTION),
    MAIN_TRANSACTION_FAILED(472, TxProcessStatusType.MAIN_TRANSACTION_FAILED_CAPTION),
    REFORM_DISREGARDED(480, TxProcessStatusType.REFORM_DISREGARDED_CAPTION),
    REFORM_ALREADY_SUCCEEDED(482, TxProcessStatusType.REFORM_ALREADY_SUCCEEDED_CAPTION),

    ERROR_IN_TRANSACTION_FIELDS(902,TxProcessStatusType.ERROR_IN_TRANSACTION_FIELDS_CAPTION),
    REPEAT_TRANSACTION(903,TxProcessStatusType.REPEAT_TRANSACTION_CAPTION),
    ACCEPTOR_NOT_SUPPORTED(905,TxProcessStatusType.ACCEPTOR_NOT_SUPPORTED_CAPTION),
    END_OF_DAY_OPERATION(906,TxProcessStatusType.END_OF_DAY_OPERATION_CAPTION),
    INACTIVE_DESTINATION_SWITCH(907,TxProcessStatusType.INACTIVE_DESTINATION_SWITCH_CAPTION),
    ROUTE_NOT_FOUNDED(908,TxProcessStatusType.ROUTE_NOT_FOUNDED_CAPTION),
    SYSTEM_ERROR(909,TxProcessStatusType.SYSTEM_ERROR_CAPTION),
    DESTINATION_SIGNED_OFF(910,TxProcessStatusType.DESTINATION_SIGNED_OFF_CAPTION),
    DESTINATION_RESPONSE_TIMEOUT(911,TxProcessStatusType.DESTINATION_RESPONSE_TIMEOUT_CAPTION),
    HOST_DOWN(912,TxProcessStatusType.HOST_DOWN_CAPTION),
    REPETITIOUS_TRANSACTION(913,TxProcessStatusType.REPETITIOUS_TRANSACTION_CAPTION),
    MAIN_TRANSACTION_NOT_FOUND(914,TxProcessStatusType.MAIN_TRANSACTION_NOT_FOUND_CAPTION),
    INVALID_FISCAL_DAY(915,TxProcessStatusType.INVALID_FISCAL_DAY_CAPTION),
    INVALID_MAC(916,TxProcessStatusType.INVALID_MAC_CAPTION),
    INVALID_MAC_KEY(917,TxProcessStatusType.INVALID_MAC_KEY_CAPTION),
    KEY_CHANGE_PROCESS(919,TxProcessStatusType.KEY_CHANGE_PROCESS_CAPTION),
    REQUEST_IN_PROCESS(923,TxProcessStatusType.REQUEST_IN_PROCESS_CAPTION),
    DATABASE_FAILURE(925,TxProcessStatusType.DATABASE_FAILURE_CAPTION),
    INVALID_MESSAGE(928,TxProcessStatusType.INVALID_MESSAGE_CAPTION),
    TRANSACTION_REJECTION_BY_BUSINESS(935,TxProcessStatusType.TRANSACTION_REJECTION_BY_BUSINESS_CAPTION),
    TX_FAILED(980,TxProcessStatusType.TX_FAILED_CAPTION),
    SENDER_SIGNED_OFF(983,TxProcessStatusType.SENDER_SIGNED_OFF_CAPTION),
    SHETAB_SIGNED_OFF(986,TxProcessStatusType.SHETAB_SIGNED_OFF_CAPTION),
    UNKNOWN_ERROR(999,TxProcessStatusType.UNKNOWN_ERROR_CAPTION);

    TxProcessStatusType(Integer code, String title) {
        this.code = code;
        this.title = title;
    }

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

    public static TxProcessStatusType findByCode(Integer code) {
        for (TxProcessStatusType type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static TxProcessStatusType findByTitle(String title) {
        for (TxProcessStatusType type : values()) {
            if (type.getTitle().equals(title)) {
                return type;
            }
        }
        return null;
    }

    /*@Override
    public Long getUniqueId() {
        return code.longValue();
    }*/
    //Shetab Doc Table 40, 11xx, 12xx responses
    private static final String TX_SUCCESSFUL_CAPTION = "CC.TxProcessStatusType.TX_SUCCESSFUL";
    private static final String TX_IGNORE_CAPTION = "CC.TxProcessStatusType.TX_IGNORE";
    private static final String CARD_EXPIRED_CAPTION = "CC.TxProcessStatusType.CARD_EXPIRED";
    private static final String FAKE_TX_CAPTION = "CC.TxProcessStatusType.FAKE_TX";
    private static final String CARD_LIMITED_CAPTION = "CC.TxProcessStatusType.CARD_LIMITED";
    private static final String OVER_TRY_PASS_COUNT_CAPTION = "CC.TxProcessStatusType.OVER_TRY_PASS_COUNT";
    private static final String INVALID_CARD_RECEIVER_CAPTION = "CC.TxProcessStatusType.INVALID_CARD_RECEIVER";
    private static final String INVALID_AMOUNT_CAPTION = "CC.TxProcessStatusType.INVALID_AMOUNT";
    private static final String WRONG_CARD_NUMBER_CAPTION = "CC.TxProcessStatusType.WRONG_CARD_NUMBER";
    private static final String PASS_INFO_NEEDED_CAPTION = "CC.TxProcessStatusType.PASS_INFO_NEEDED";
    private static final String INVALID_RECEIVER_FEE_CAPTION = "CC.TxProcessStatusType.INVALID_RECEIVER_FEE";
    private static final String ACCOUNT_NOT_FOUND_CAPTION = "CC.TxProcessStatusType.ACCOUNT_NOT_FOUND";
    private static final String FUNCTION_NOT_SUPPORTED_CAPTION = "CC.TxProcessStatusType.FUNCTION_NOT_SUPPORTED";
    private static final String NOT_ENOUGH_ACCOUNT_BALANCE_CAPTION = "CC.TxProcessStatusType.NOT_ENOUGH_ACCOUNT_BALANCE";
    private static final String WRONG_PASS_CAPTION = "CC.TxProcessStatusType.WRONG_PASS";
    private static final String CARD_INFO_NOT_FOUND_CAPTION = "CC.TxProcessStatusType.CARD_INFO_NOT_FOUND";
    private static final String CARD_OWNER_IS_NOT_ALLOWED_CAPTION = "CC.TxProcessStatusType.CARD_OWNER_IS_NOT_ALLOWED";
    private static final String TERMINAL_IS_NOT_ALLOWED_CAPTION = "CC.TxProcessStatusType.TERMINAL_IS_NOT_ALLOWED";
    private static final String AMOUNT_OVER_LIMIT_CAPTION = "CC.TxProcessStatusType.AMOUNT_OVER_LIMIT";
    private static final String SECURITY_VIOLATED_CAPTION = "CC.TxProcessStatusType.SECURITY_VIOLATED";
    private static final String TRY_COUNT_OVER_LIMITED_CAPTION = "CC.TxProcessStatusType.TRY_COUNT_OVER_LIMITED";
    private static final String RULES_IS_FAILED_CAPTION = "CC.TxProcessStatusType.RULES_IS_FAILED";
    private static final String CARD_IS_NOT_ACTIVE_CAPTION = "CC.TxProcessStatusType.CARD_IS_NOT_ACTIVE";
    private static final String INVALID_PIN_BLOCK_CAPTION = "CC.TxProcessStatusType.INVALID_PIN_BLOCK";
    private static final String INVALID_PASS_LENGTH_CAPTION = "CC.TxProcessStatusType.INVALID_PASS_LENGTH";
    private static final String INVALID_CARD_KEY_CAPTION = "CC.TxProcessStatusType.INVALID_CARD_KEY";
    private static final String CARD_MAYBE_FAKE_CAPTION = "CC.TxProcessStatusType.CARD_MAYBE_FAKE";
    private static final String CARD_RELATED_ACCOUNT_IS_CLOSED_CAPTION = "CC.TxProcessStatusType.CARD_RELATED_ACCOUNT_IS_CLOSED";
    private static final String INAPPROPRIATE_STATUS_ACCOUNT_OR_CARD_SOURCE_CAPTION = "CC.TxProcessStatusType.INAPPROPRIATE_STATUS_ACCOUNT_OR_CARD_SOURCE";
    private static final String INAPPROPRIATE_STATUS_ACCOUNT_OR_CARD_DESTINATION_CAPTION = "CC.TxProcessStatusType.INAPPROPRIATE_STATUS_ACCOUNT_OR_CARD_DESTINATION";
    private static final String CARD_CONFIRMATION_NOT_SUCCEED_CAPTION = "CC.TxProcessStatusType.CARD_CONFIRMATION_NOT_SUCCEED";
    private static final String TRANSACTION_IS_NOT_SUPPORTED_BY_CARD_ISSUER_CAPTION = "CC.TxProcessStatusType.TRANSACTION_IS_NOT_SUPPORTED_BY_CARD_ISSUER";
    private static final String ORIGINAL_TRANSACTION_HAS_NOT_BEEN_SUCCESSFUL_CAPTION = "CC.TxProcessStatusType.ORIGINAL_TRANSACTION_HAS_NOT_BEEN_SUCCESSFUL";
    private static final String OPERATION_TO_RESOLVE_THIS_TRANSACTION_HAS_ALREADY_BEEN_SUCCESSFUL_CAPTION = "CC.TxProcessStatusType.OPERATION_TO_RESOLVE_THIS_TRANSACTION_HAS_ALREADY_BEEN_SUCCESSFUL";
    //Shetab Doc Table 43, 14xx responses
    private static final String TX_SUCCESSFUL_REFORM_CAPTION = "CC.TxProcessStatusType.TX_SUCCESSFUL_REFORM";
    private static final String REFORM_NOT_ENOUGH_ACCOUNT_BALANCE_CAPTION = "CC.TxProcessStatusType.REFORM_NOT_ENOUGH_ACCOUNT_BALANCE";
    private static final String MAIN_TRANSACTION_FAILED_CAPTION = "CC.TxProcessStatusType.MAIN_TRANSACTION_FAILED";
    private static final String REFORM_DISREGARDED_CAPTION = "CC.TxProcessStatusType.REFORM_DISREGARDED";
    private static final String REFORM_ALREADY_SUCCEEDED_CAPTION = "CC.TxProcessStatusType.REFORM_ALREADY_SUCCEEDED";
    //Shetab Doc Table 46 for all transaction
    private static final String ERROR_IN_TRANSACTION_FIELDS_CAPTION = "CC.TxProcessStatusType.ERROR_IN_TRANSACTION_FIELDS_CAPTION";
    private static final String REPEAT_TRANSACTION_CAPTION = "CC.TxProcessStatusType.REPEAT_TRANSACTION_CAPTION";
    private static final String ACCEPTOR_NOT_SUPPORTED_CAPTION = "CC.TxProcessStatusType.ACCEPTOR_NOT_SUPPORTED_CAPTION";
    private static final String END_OF_DAY_OPERATION_CAPTION = "CC.TxProcessStatusType.END_OF_DAY_OPERATION_CAPTION";
    private static final String INACTIVE_DESTINATION_SWITCH_CAPTION = "CC.TxProcessStatusType.INACTIVE_DESTINATION_SWITCH_CAPTION";
    private static final String ROUTE_NOT_FOUNDED_CAPTION = "CC.TxProcessStatusType.ROUTE_NOT_FOUNDED_CAPTION";
    private static final String SYSTEM_ERROR_CAPTION = "CC.TxProcessStatusType.SYSTEM_ERROR_CAPTION";
    private static final String DESTINATION_SIGNED_OFF_CAPTION = "CC.TxProcessStatusType.DESTINATION_SIGNED_OFF_CAPTION";
    private static final String DESTINATION_RESPONSE_TIMEOUT_CAPTION = "CC.TxProcessStatusType.DESTINATION_RESPONSE_TIMEOUT_CAPTION";
    private static final String HOST_DOWN_CAPTION = "CC.TxProcessStatusType.HOST_DOWN_CAPTION";
    private static final String REPETITIOUS_TRANSACTION_CAPTION = "CC.TxProcessStatusType.REPETITIOUS_TRANSACTION_CAPTION";
    private static final String MAIN_TRANSACTION_NOT_FOUND_CAPTION = "CC.TxProcessStatusType.MAIN_TRANSACTION_NOT_FOUND_CAPTION";
    private static final String INVALID_FISCAL_DAY_CAPTION = "CC.TxProcessStatusType.INVALID_FISCAL_DAY_CAPTION";
    private static final String INVALID_MAC_CAPTION = "CC.TxProcessStatusType.INVALID_MAC_CAPTION";
    private static final String INVALID_MAC_KEY_CAPTION = "CC.TxProcessStatusType.INVALID_MAC_KEY_CAPTION";
    private static final String KEY_CHANGE_PROCESS_CAPTION = "CC.TxProcessStatusType.KEY_CHANGE_PROCESS_CAPTION";
    private static final String REQUEST_IN_PROCESS_CAPTION = "CC.TxProcessStatusType.REQUEST_IN_PROCESS_CAPTION";
    private static final String DATABASE_FAILURE_CAPTION = "CC.TxProcessStatusType.DATABASE_FAILURE_CAPTION";
    private static final String INVALID_MESSAGE_CAPTION = "CC.TxProcessStatusType.INVALID_MESSAGE_CAPTION";
    private static final String TRANSACTION_REJECTION_BY_BUSINESS_CAPTION = "CC.TxProcessStatusType.TRANSACTION_REJECTION_BY_BUSINESS_CAPTION";
    private static final String TX_FAILED_CAPTION = "CC.TxProcessStatusType.TX_FAILED_CAPTION";
    private static final String SENDER_SIGNED_OFF_CAPTION = "CC.TxProcessStatusType.SENDER_SIGNED_OFF_CAPTION";
    private static final String SHETAB_SIGNED_OFF_CAPTION = "CC.TxProcessStatusType.SHETAB_SIGNED_OFF_CAPTION";
    private static final String UNKNOWN_ERROR_CAPTION = "CC.TxProcessStatusType.UNKNOWN_ERROR_CAPTION";
}
