package ch.m;

import java.util.HashMap;
import java.util.Set;

public class Contracts{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HashMap<Integer, Contract> contracts;
	
	
	public Contracts(){
		contracts = new HashMap<Integer, Contract>();
	}
	
	public void add(Integer contract_id, Contract contract){
		if (contracts.containsKey(contract_id)){
			//System.out.println("Overwriting contract " + contract_id);	
		}
		contracts.put(contract_id, contract);
	}
	
	public Contract getContract(Integer contract_id){
		if (! contracts.containsKey(contract_id)){
			System.out.println("contract " + contract_id + " not found");		
		}
		return contracts.get(contract_id);
	}
	
	public Set<Integer> getContractIds(){
		return contracts.keySet();
		
	}
	
}
