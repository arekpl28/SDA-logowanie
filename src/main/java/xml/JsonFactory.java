package xml;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFactory {

    public String listToJSon(List list) {
        String json = new Gson().toJson(list);
        return json;

    }



    public void saveData(String jsonString) {
        File file = new File("C:\\Users\\RENT\\Desktop\\projekt\\SDA-logowanie\\src\\main\\resources\\ListOfProducts.dat");

        try {
            FileUtils.touch(file);
            FileUtils.writeStringToFile(file, jsonString, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
