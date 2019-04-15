package util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
/**
 * @title ����json���ݸ�ʽת��
 * @author 
 */
public class ConvertJsonUtils {
 
    public ConvertJsonUtils() {
        super();
    }
 
    /**
     * ���ܣ������ͼ���ת���ɷ�ҳjson����
     * 
     * @param list
     *            ���ͼ���
     * @param countList
     *            ���ݼ��ϵ�������
     * @return ��ҳjson����
     */
    public static String ConvertListToPageJson(List<?> list, int countList) {
        // �½�һ��json����
        JSONArray jsonArray = new JSONArray();
        // �½�һ��json����
        JSONObject jsonObject = null;
        // �������ͼ���
        for (Object object : list) {
            jsonObject = new JSONObject(object);
            jsonArray.put(jsonObject);
        }
        // ת�����ݸ�ʽ
        String json = jsonArray.toString();
        // ƴ���ַ���
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
     * ���ܣ������ͼ���ת���ɷ�ҳjson����
     * 
     * @param list
     *            ���ͼ���
     * @param countList
     *            ���ݼ��ϵ�������
     * @return ��ҳjson����
     */
    public static String ConvertListToPageJson(List<?> list){
        // �½�һ��json����
        JSONArray jsonArray = new JSONArray();
        // �½�һ��json����
        JSONObject jsonObject = null;
        // �������ͼ���
        for (Object object : list) {
            jsonObject = new JSONObject(object);
            jsonArray.put(jsonObject);
        }
        // ת�����ݸ�ʽ
        String json = jsonArray.toString();
        // ƴ���ַ���
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
