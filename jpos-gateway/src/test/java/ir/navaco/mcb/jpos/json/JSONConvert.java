package ir.navaco.mcb.jpos.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

class Test{
    String[] strArray = new String[]{"a", "b", "c"};

    public String[] getStrArray() {
        return strArray;
    }

    public void setStrArray(String[] strArray) {
        this.strArray = strArray;
    }
}

class Test02{
    List<String> lst = new ArrayList<>();
    public Test02(){
        lst.add("a");
        lst.add("b");
        lst.add("c");
    }

    public List<String> getLst() {
        return lst;
    }

    public void setLst(List<String> lst) {
        this.lst = lst;
    }
}

class Test03 extends Test02{
    private long id = 1L;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

public class JSONConvert {

    public static void main(String[] args) throws JsonProcessingException {
        Test test = new Test();
        String json = new GsonBuilder().create().toJson(test, Test.class);
        System.out.println(json);

        Test02 test02 = new Test02();
        json = new GsonBuilder().create().toJson(test02, Test02.class);
        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        json = mapper.writeValueAsString(test);
        System.out.println("jackson ::: " + json);

        Test03 test03 = new Test03();
        json = mapper.writeValueAsString(test03);
        System.out.println("jackson ::: " + json);
    }

}
