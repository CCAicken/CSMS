package action.control;

import java.io.IOException;

public class CompetitionEntry extends BaseAction {
	private int page;
	private int limit;
	private int proid;

	public void setProid(int proid) {
		this.proid = proid;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public String execute() throws IOException {

		return null;
	}
}