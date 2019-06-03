package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

/**
 * �ڷ������е�servlet��ʹ�ã���ȡ�ͻ��˵�IP��ַ
 * @author Administrator
 * @version 2019-3-19
 */
public class IPAddrUtil {
	
	public static String getIpAddress(HttpServletRequest request){
        
        String ipAddress = request.getHeader("x-forwarded-for");
         
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknow".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
             
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //����������ȡ�������õ�IP��ַ
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
             	ipAddress = inetAddress.getHostAddress();
            }
        }
        
        //����ͨ�����������������һ��IPΪ�ͻ�����ʵ��IP��ַ�����IP����','�ָ�
        if(null != ipAddress && ipAddress.length() > 15){
            //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",") > 0){
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
             }
         }
         
         return ipAddress;
	}
}
