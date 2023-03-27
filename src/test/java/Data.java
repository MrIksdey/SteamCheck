import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Data {

    private JSONParser parser = new JSONParser();

    public String config (String key) throws IOException, ParseException {

        Object obj = parser.parse(new FileReader("config.json"));
        JSONObject jsonObject = (JSONObject) obj;
        String data = (String) jsonObject.get(key);

        return data;
    }
    public String steamData1 (String key) throws IOException, ParseException {

        Object obj = parser.parse(new FileReader("dataSteam1.json"));
        JSONObject jsonObject = (JSONObject) obj;
        String data = (String) jsonObject.get(key);

        return data;
    }

    public String steamData2 (String key) throws IOException, ParseException {

        Object obj = parser.parse(new FileReader("dataSteam2.json"));
        JSONObject jsonObject = (JSONObject) obj;
        String data = (String) jsonObject.get(key);

        return data;
    }

}
