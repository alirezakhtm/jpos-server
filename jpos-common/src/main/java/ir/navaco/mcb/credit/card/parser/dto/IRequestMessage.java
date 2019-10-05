package ir.navaco.mcb.credit.card.parser.dto;

import ir.navaco.mcb.credit.card.parser.enums.FunctionCodeType;

/**
 * For all request messages
 * @author sa.gholizadeh <sa.gholizadeh@yahoo.com>
 */
public interface IRequestMessage extends IMessage{
    public FunctionCodeType getFunctionCode();
}
