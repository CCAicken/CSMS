package util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
/**
 * @title 公共json数据格式转换
 * @author 
 */
public class ConvertJsonUtils {
 
    public ConvertJsonUtils() {
        super();
    }
 
    /**
     * 功能：将泛型集合转换成分页json数据
     * 
     * @param list
     *            泛型集合
     * @param countList
     *            数据集合的总行数
     * @return 分页json数据
     */
    public static String ConvertListToPageJson(List<?> list, int countList) {
        // 新建一个json数组
        JSONArray jsonArray = new JSONArray();
        // 新建一个json对象
        JSONObject jsonObject = null;
        // 遍历泛型集合
        for (Object object : list) {
            jsonObject = new JSONObject(object);
            jsonArray.put(jsonObject);
        }
        // 转换数据格式
        String json = jsonArray.toString();
        // 拼接字符串
        StringBuffer sb = new StringBuffer();
        sb.append("{\"totalCount\":");
        sb.append(countList);
        sb.append(",\"rows\":");
        sb.append(json);
        sb.append("}");
        String jsonString = sb.toString();
        return jsonString;
    }
    /**
     * 功能：将泛型集合转换成分页json数据
     * 
     * @param list
     *            泛型集合
     * @param countList
     *            数据集合的总行数
     * @return 分页json数据
     */
    public static String ConvertListToPageJson(List<?> list){
        // 新建一个json数组
        JSONArray jsonArray = new JSONArray();
        // 新建一个json对象
        JSONObject jsonObject = null;
        // 遍历泛型集合
        for (Object object : list) {
            jsonObject = new JSONObject(object);
            jsonArray.put(jsonObject);
        }
        // 转换数据格式
        String json = jsonArray.toString();
        // 拼接字符串
        JSONObject jn = new JSONObject();
        try {
            jn.put("records", jsonArray);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jn.toString();
    }
 
}
