package action.control;

public class getLogoutAction extends BaseAction {

	//�ɹ����ص�ҳ��
		private String requesturl;
		public String getRequesturl() {
			return requesturl;
		}
		public void setRequesturl(String requesturl) {
			this.requesturl = requesturl;
		}
		/**
		 * @return
		 */
		public String execute() {
			session.removeAttribute("loginuser");
			requesturl = (String)session.getAttribute("requesturl");
			if(requesturl==null||requesturl.equals("")){
				requesturl ="blogmain";
			}
			return SUCCESS;
		}
}