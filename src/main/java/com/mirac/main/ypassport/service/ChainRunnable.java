package com.mirac.main.ypassport.service;

import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*区块流水记录*/
public class ChainRunnable implements Runnable {
	
	
	private boolean flag;
	private int id;
	private String price;
	private String recipel;
	String wuliu;
	String name;
	int num;
	String fangyi;
	
	
	public ChainRunnable(String wuliu, String id, String name,String num,String fangyi){
		this.wuliu = wuliu;
		Integer id1 = new Integer(id);
		this.id = id1.intValue();
		this.name = name;
		Integer num1 = new Integer(num);
		this.num = num1.intValue();
		this.fangyi = fangyi;
		
	}

	@Override
	public void run() {
		try {
			if(flag){
				TransactionReceipt txReceipt= ConfigUtils.Recipel_Contract.createRx(BigInteger.valueOf(id), new BigInteger(price), StringHexUtils.convertStringToUTF8(recipel)).send();
				
				String txHash = txReceipt.getTransactionHash();
				String insertSql = " insert into chain_record (CR_Time, from_addr, to_addr, tx_hash, version, rx_id, tx_status) values('"
						+ DateUtils.getStringDate()+"', '"+ ConfigUtils.USER_Credentials.getAddress()+"', '"
						+ ConfigUtils.Recipel_Contract.getContractAddress()+"', '"+ txHash +"', 0, "+id
						+", '00')";
				Connection con;
				try {
					con = MySqlUtils.getConnection();
					Statement state = con.createStatement();
					boolean result = state.execute(insertSql);
					//System.out.println(result.getRow());
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				
				//update
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
