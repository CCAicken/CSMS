package business.dao;

import model.TForumContent;

public interface ContentDAO {
	/**
	 * 添加博客文章的一条内容信息
	 * @param TForumContent对象
	 * @return 添加成功的文章编号，如<=0则表示添加失败
	 */
	public int addContent(TForumContent fcontent);
	
	/**
	 * 删除一个博客文章内容信息
	 * @param 内容编号
	 * @return 受影响的行数
	 */
	public boolean deleteContent(int id);
	/**
	 * 修改一个博客文章内容信息
	 * @param 文章内容对象
	 * @return 受影响的行数
	 */
	public boolean updateForumContent(TForumContent fcontent);

	/**
	 * 通过内容编号检索一条文章内容记录
	 * @param 内容编号
	 * @return VForumContent对象
	 */
	//public VForumContent getContnentById(int id);
	
	/**
	 * 通过内容编号检索一条文章内容记录
	 * @param 内容编号
	 * @return TForumContent对象
	 */
	public TForumContent getTContnentById(int id);
}
