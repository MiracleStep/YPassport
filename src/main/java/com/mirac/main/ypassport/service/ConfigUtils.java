package com.mirac.main.ypassport.service;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigDecimal;
import java.math.BigInteger;

/*web3j配置信息，包括消耗币数量，最大交易币量，睡眠时间，交互地址，合约地址，合约名字，输入信息*/
	public class ConfigUtils {
	public static  BigInteger GAS_PRICE = BigInteger.valueOf(10_000_000_000L);  //250 000 000 000
	public static  BigInteger GAS_LIMIT = BigInteger.valueOf(3_000_000L);
	public static  BigDecimal gwei = BigDecimal.valueOf(1_000_000_000L);
	public static  BigDecimal GAS_SHOW = BigDecimal.valueOf(10L);
	public static long SLEEP_TIME = 3000L;
	public static Web3j WEB3_J = Web3j.build(new HttpService("https://ropsten.infura.io/v3/1dbefd15875547c6bc151bf16713d26b"));// https://mainnet.infura.io/;
	public static Credentials USER_Credentials;
	public static String Recipel_Address = "0xE6B7aE553E8E783b7e60818232cF08cbF644A879";
	public static Recipel Recipel_Contract;
	public static int y_id;
	public static String y_name;
	public static int num;
	public static int p_id;
	public static String p_name;
	public static String c_name;
	public static String t_name;
	public static String fangyi;
	public static String point;


}

