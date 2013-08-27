package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOGeneric {

	private java.sql.Connection conexao;

	private void connect() throws SQLException{
			conexao = DaoFactory.getConnection();
	}
	
	public int countProjectsInProgress() {
		int c = 0;
		try{
			connect();
			PreparedStatement pst = conexao.prepareStatement("select count(project_id) from dotp_projects where project_status = ?");
			pst.setString(1, "3");
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				c =  rs.getInt(1);
			conexao.close();
		}	catch (SQLException e){ e.printStackTrace();}
		return c;
	}
	
	public Object[] getProjectsInProgress() {
		List<Integer>  l = new LinkedList<Integer>();
		try{
			connect();
			PreparedStatement pst = conexao.prepareStatement("select project_id from dotp_projects where project_status = ?");
			pst.setString(1, "3");
			ResultSet rs = pst.executeQuery();
			while (rs.next())						
				l.add(rs.getInt(1));
			conexao.close();
		}	catch (SQLException e){ e.printStackTrace();}
		return l.toArray();
	}
	
	public double getCust(int id) {
		double d = 0;
		try{
			connect();
			PreparedStatement pst = conexao.prepareStatement("select project_target_budget from dotp_projects where project_id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next())						
				d = rs.getDouble(1);
			conexao.close();
		}	catch (SQLException e){ e.printStackTrace();}
		return d;
	}
	
}
