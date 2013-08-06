package ch.m;

public class Contract {
	
	Integer id;
	String name;
	String device;
	Double shock_value;
		
	public Contract (Integer id, Double shock_value){
		this.id = id;
		this.shock_value = shock_value;
	}

	public Integer getContractId(){
		return id;
	}
	
	public Double getContractValue(){
		return shock_value;
	}
}
