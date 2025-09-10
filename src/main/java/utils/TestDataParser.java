package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JavaType;
import com.shaft.driver.SHAFT;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestDataParser {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // 🔹 Load a single object from SHAFT JSON
    public static <T> T loadObject(SHAFT.TestData.JSON testData, Class<T> clazz) {
        return loadObject(testData, "", clazz);
    }

    public static <T> T loadObject(SHAFT.TestData.JSON testData, String key, Class<T> clazz) {
        try {
            Map<String, Object> dataMap = (Map<String, Object>) testData.getTestDataAsMap(key);
            String json = objectMapper.writeValueAsString(dataMap);
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load object from test data", e);
        }
    }


    // 🔹 Load a list of objects from SHAFT JSON
    public static <T> List<T> loadArray(SHAFT.TestData.JSON testData, String key, Class<T> clazz) {
        try {
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) testData.getTestDataAsMap(key).get("list");
            String json = objectMapper.writeValueAsString(dataList);
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load array from test data", e);
        }
    }


    public static <T> T readJsonFromJsonDataPath(String filename,Class<T> tClass) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.readValue(new File(filename), tClass);
    }

}
