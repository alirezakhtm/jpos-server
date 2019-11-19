package ir.navaco.mcb.jpos.db;

import com.google.gson.GsonBuilder;
import ir.navaco.mcb.credit.card.database.HandleDB;
import ir.navaco.mcb.credit.card.database.dto.MessagePolicy;
import org.junit.Test;

import java.util.Map;

public class DatabaseTest {

    @Test
    public void policiesList(){
        HandleDB db = new HandleDB();
        Map<Integer, MessagePolicy> map = db.getAllPolicy();
        for(Integer mti : map.keySet()){
            System.out.println(
                    String.format(new GsonBuilder().create().toJson(map.get(mti), MessagePolicy.class))
            );
        }
    }


}
