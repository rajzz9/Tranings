package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ErrorMessage {
    public static Map<String, String> errorMessages = new HashMap<String, String>();

    static {
        errorMessages.put("PNR-TRADEAPI-ACCT-SEC-001", "PNR-TRADE-ACCT-SEC-001|Issue in Account and Security reference: ");
        errorMessages.put("PNR-TRADEAPI-TRADE-001", "PNR-TRADEAPI-TRADE-001|While saving Trade entity getting Issue, Please check insertTrade(accRef, secRef, tradeMessage.getTrade()) method ");
        errorMessages.put("PNR-TRADEAPI-REFID-001", "PNR-TRADEAPI-REFID-001|While saving RefernceId entity getting Issue, Please check insertRefernceId(Trade trade, Header header) method ");
        errorMessages.put("PNR-TRADEAPI-MNY-001", "PNR-TRADEAPI-MNY-001|While saving Money entity getting Issue, Please check insertMoney(Trade trade, Figuration figuration) method ");
        errorMessages.put("PNR-TRADEAPI-TRAILER-001", "PNR-TRADEAPI-TRAILER-001|While saving Trailer Input and Output entity getting Issue, Please check insertTrailer(Trade trade, Trailer trailer) method ");
    }
}
