package dao;

public class SqlStatements {
	public static String cmdInsert(String tableName,int qtdValues){
		
		StringBuffer ins = new StringBuffer("insert into "+ tableName+" values(");
		
		for (int i = 0 ; i < qtdValues ; i++){
			ins.append("?,");
		}
		ins.delete(ins.length()-1, ins.length());
		ins.append(")");
		
		/*O comando SQL: exemplo: 
		 * 				 insert into TBComputer values (?, ? , ?);
		 */
		return ins.toString();
	}
	
	private static String sqlWhere (String whereClausFull){
		if (whereClausFull != null){
			if (whereClausFull.startsWith(" where "))
				return whereClausFull;
			else
				return " where " + whereClausFull;
		}
		return " ";
	}
	
	private static String sqlWhere (String[] whereClaus){
		if (whereClaus.length > 0){
			StringBuffer sb = new StringBuffer();
			sb.append(" where " );
			for (int i = 0 ; i < whereClaus.length ; i++){
				sb.append(whereClaus[i] + " and ");
			}
			sb.delete(sb.length()-5, sb.length());
			return sb.toString();	
		}
		return " ";		
	}
	
	public static String cmdRemove(String tableName, String whereClausFull){
		/* O Comando SQL:
		 * 					delete from TBComputer where id = 10 and 
		 * 										   memSecundaria > 512; 
		 */		
		return "delete from " + tableName + sqlWhere(whereClausFull);
	}
	
	public static String cmdRemove(String tableName, String[] whereClaus){
		/* O Comando SQL:
		 * 					delete from TBComputer where id = 10 and memSecundaria > 512; 
		 */		
		return cmdRemove(tableName, sqlWhere(whereClaus));
	}
	
	public static String cmdUpdate (String tableName, String fields[], String whereClausFull){
		/*
		 * O Comando SQL:
		 * 		Update TBComputer set vNome = 'XXXXX', vProcessador = 'YYYYY'
		 * 		where iId = 10;
		 */
		StringBuffer sb = new StringBuffer();
		sb.append("Update " + tableName + " set ");
		for (int i = 0; i < fields.length; i++)
			sb.append(fields[i] + " = ?," );
		sb.delete(sb.length()-1, sb.length());
		sb.append(sqlWhere(whereClausFull));	
		return sb.toString();
	}
	
	public static String cmdUpdate (String tableName, String fields[], String[] whereClaus){
		/*
		 * O Comando SQL:
		 * 		Update TBComputer set vNome = 'XXXXX', vProcessador = 'YYYYY'
		 * 		where iId = 10;
		 */
		return cmdUpdate(tableName, fields, sqlWhere(whereClaus));
	}
	
	public static String cmdSelect (String tableName, String whereClausFull){
		return "Select * from " + tableName + sqlWhere(whereClausFull);		
	}
	
	public static String cmdSelect (String tableName, String[] whereClaus){
		return cmdSelect(tableName, sqlWhere(whereClaus));
	}
}
