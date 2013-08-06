package ch.m;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tester {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("starting...");
		Contracts contracts = new Contracts();
		
		MySql conn = new MySql(41);
		try {
			ResultSet resSet = conn.readData();
			
			Integer counter = 0;
		     while (resSet.next()) {
		            Double shock_val = resSet.getDouble("shock_value");

		            contracts.add(counter, new Contract(counter, shock_val));
		            //System.out.println(counter + " added " + shock_val);
		            counter++;
		     }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (Integer id : contracts.getContractIds()) {			
			System.out.println("Nr" + id + "  -> " + contracts.getContract(id).getContractValue());
		}
		

		System.out.println("ending...");
	}

}
