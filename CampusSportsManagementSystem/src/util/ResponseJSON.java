package util;

/**
 * һ�����ڴ�������Ϣ��json���Ͷ���
 * @author zhang jin sheng
 *
 */
public class ResponseJSON {

	public static final int FLAG_SUCC = 10001;  //����ɹ�
    public static final int FLAG_FAIL = 10002;  //����ʧ��
    public static final int FLAG_UNKNOWN_ERORR = 10003;  //δ֪���쳣�����
    
    public int flag; //������״̬��
    public String msg;  //������������Ϣ
    public String result1; //�����ؽ����������һ����ת��Ϊjson��ʽ���ַ�
    public String result2;
    public String result3;
    
    public ResponseJSON(){
    	this.flag = FLAG_FAIL;
    	this.msg = null;
    	this.result1 = null;
    	this.result2 = null;
    	this.result3 = null;
    }
}
