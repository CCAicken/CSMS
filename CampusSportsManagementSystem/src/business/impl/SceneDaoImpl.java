package business.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import model.Scene;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.SceneDAO;

public class SceneDaoImpl implements SceneDAO {
	private BaseDao bdao = null;
	public SceneDaoImpl() {
		bdao = new BaseDaoImpl();
	}

	@Override
	public boolean insert(Scene scene) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Scene> seleScenes() {
		String sql = "select * from V_Scene";
		ResultSet rs = bdao.select(sql);
		if(rs!=null){
			List<Scene> list = Scene.toList(rs);
			return list;
		}
		else{
			return null;
		}
	}

	@Override
	public List<Scene> seleScenes(String userid) {
		String sql = "select * from V_Scene where userid=?";
		Object[] para = {userid};
		List<Scene> list = null;
		ResultSet rs = bdao.select(sql,para);
		list = Scene.toList(rs);
		return list;
	}
	
	@Override
	public List<Project> seleOtherScenes(String userid) {
		String sql = "SELECT proname from v_Match where userid=? except SELECT proname from V_Scene where userid=?";
		Object[] para = {userid,userid};
		ResultSet rs = bdao.select(sql,para);
		List<Project> list = new ArrayList<Project>();
		if(rs != null){
			try{
				while(rs.next()){
					Project project = new Project();
					project.setProname(rs.getString("proname"));
					list.add(project);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		SceneDAO sDao = new SceneDaoImpl();
		List<Project> list = sDao.seleOtherScenes("1001");
		System.out.print(list.size());
		if(list!=null){
			for(Project scene:list){
				System.out.println(scene.getProname());
			}
		}
	}
}
