package ir.navaco.mcb.credit.card.general;

import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;

import java.util.List;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class CommonFunction {

    private static final String TAG = "CommonFunction";
    private static JPOSLogger logger = new JPOSLogger(TAG);

    /**
     * @return if message is valid, true is returned otherwise false is returned
     * */
    public static boolean filterMessage(TxProcessCodeType processCodeType,
                                        List<String> lstValidProcessCode){
        if(lstValidProcessCode.size() == 0) return true;
        if(processCodeType == null){
            return false;
        }else{
            String strProcessCode = processCodeType.getCode().toString();
            logger.info(String.format("ProcessCodeType: %s", strProcessCode));
            String processCode = strProcessCode.length() > 1 ? strProcessCode.substring(0, 2) : strProcessCode;
            if(lstValidProcessCode.stream().filter(s -> s.equals(processCode)).count() == 0){
                return false;
            }
        }

        return true;
    }

}
