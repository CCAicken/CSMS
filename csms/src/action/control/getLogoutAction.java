package action.control;

public class getLogoutAction extends BaseAction {

	
		/**
		 * @return
		 */
		public String execute() {
			session.removeAttribute("loginuser");
			
			return SUCCESS;
		}
}