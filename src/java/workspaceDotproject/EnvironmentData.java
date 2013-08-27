// CArtAgO artifact code for project prj_AMud

package workspaceDotproject;

import cartago.Artifact;
import cartago.OPERATION;
import cartago.OpFeedbackParam;
import dao.DAOGeneric;

public class EnvironmentData extends Artifact {
	
	private DAOGeneric dao = new DAOGeneric();
	
	private Object updateVal(){
		return dao.countProjectsInProgress();
	}
	
	private Object updateList(){
		return dao.getProjectsInProgress();
	}
	
	void init() {    //chamado quando o ambiente é criado
		//obter as credenciais para conectar o banco		
		defineObsProperty("countProjectsActive", updateVal());   //buscar o valor diretamente do banco de dados		 
		defineObsProperty("listOfProjectsActive", updateList());   //buscar o valor diretamente do banco de dados
	}
	
	@OPERATION
	void check(){         //checar as alterações promovidas
		getObsProperty("countProjectsActive").updateValue(updateVal());
		getObsProperty("listOfProjectsActive").updateValue(updateList());
	}
	
	@OPERATION
	void checkCust(int id, OpFeedbackParam <Double> cust){
				cust.set(dao.getCust(id));
	}
	
}

