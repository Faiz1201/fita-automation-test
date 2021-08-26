package utilities.readers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReaderWriter {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("data/loginUsers.json"))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray loginDataList = (JSONArray) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void getLoginUsersDetail(JSONObject loginUser) {
        JSONObject loginUsersObject = (JSONObject) loginUser.get("valid_user_number");

        String switch_number = (String) loginUsersObject.get("username");
    }
}
