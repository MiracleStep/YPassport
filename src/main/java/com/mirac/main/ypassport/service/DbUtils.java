package com.mirac.main.ypassport.service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*数据库快查*/
public class DbUtils {
	
	public static void freshPatients(JTable table){
		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from t_user where type='9'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No Patients!");
			}else{
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//model
				String[] columns={"ID","姓名","性别","年龄","手机号"};
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(e ->{
					createRecipelFrame(doctorFrame, ).setVisible(true);
    				doctorFrame.setVisible(false);
				});*/
				do{
					System.out.println("ID:" + result.getInt("ID"));
					System.out.println("姓名：" + result.getString("NAME"));
					System.out.println("性别：" + result.getString("SEX"));
					System.out.println("年龄：" + result.getInt("AGE"));
					System.out.println("卡号：" + result.getString("PN"));
					//System.out.println("地址：" + result.getString("ADDR"));
					String[] line = {result.getInt("ID")+"",result.getString("NAME"), result.getString("SEX"), result.getInt("AGE")+"",result.getString("PN")};
					model.addRow(line);
				}while(result.next());
				//table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void freshPerson(JTable table,int p_id){
		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from jiezhongren where p_id='"+p_id+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No Patients!");
			}else{
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//model
				String[] columns={"ID","姓名","性别","年龄","手机号","地址"};
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(e ->{
					createRecipelFrame(doctorFrame, ).setVisible(true);
    				doctorFrame.setVisible(false);
				});*/
				do{
					System.out.println("ID:" + result.getInt("p_id"));
					System.out.println("姓名：" + result.getString("p_name"));
					System.out.println("性别：" + result.getString("sex"));
					System.out.println("年龄：" + result.getInt("age"));
					System.out.println("手机号：" + result.getString("ph"));
					System.out.println("地址：" + result.getString("addr"));
					String[] line = {result.getInt("p_id")+"",result.getString("p_name"), result.getString("sex"), result.getInt("age")+"",result.getString("ph")+"",result.getString("addr")};
					model.addRow(line);
				}while(result.next());
				//table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void freshPerson(JTable table,String point){
		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from jiezhongren where point='"+point+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No Patients!");
			}else{
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//model
				String[] columns={"ID","姓名","性别","年龄","手机号","地址"};
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(e ->{
					createRecipelFrame(doctorFrame, ).setVisible(true);
    				doctorFrame.setVisible(false);
				});*/
				do{
					System.out.println("ID:" + result.getInt("p_id"));
					System.out.println("姓名：" + result.getString("p_name"));
					System.out.println("性别：" + result.getString("sex"));
					System.out.println("年龄：" + result.getInt("age"));
					System.out.println("手机号：" + result.getString("ph"));
					System.out.println("地址：" + result.getString("addr"));
					String[] line = {result.getInt("p_id")+"",result.getString("p_name"), result.getString("sex"), result.getInt("age")+"",result.getString("ph")+"",result.getString("addr")};
					model.addRow(line);
				}while(result.next());
				//table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void freshPerson2(JTable table,String p_id){
		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from jiezhongren where p_id='"+p_id+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No Patients!");
			}else{
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//model
				String[] columns={"ID","姓名","性别","年龄","手机号","地址"};
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(e ->{
					createRecipelFrame(doctorFrame, ).setVisible(true);
    				doctorFrame.setVisible(false);
				});*/
				do{
					System.out.println("ID:" + result.getInt("p_id"));
					System.out.println("姓名：" + result.getString("p_name"));
					System.out.println("性别：" + result.getString("sex"));
					System.out.println("年龄：" + result.getInt("age"));
					System.out.println("手机号：" + result.getString("ph"));
					System.out.println("地址：" + result.getString("addr"));
					String[] line = {result.getInt("p_id")+"",result.getString("p_name"), result.getString("sex"), result.getInt("age")+"",result.getString("ph")+"",result.getString("addr")};
					model.addRow(line);
				}while(result.next());
				//table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void freshPro(JTable table,int y_id){
		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from product where y_id='"+y_id+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No Patients!");
			}else{
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//model
				String[] columns={"疫苗id","疫苗类型","疫苗名称","疫苗数量","生产时间"};
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(e ->{
					createRecipelFrame(doctorFrame, ).setVisible(true);
    				doctorFrame.setVisible(false);
				});*/
				do{
					System.out.println("疫苗id:" + result.getInt("y_id"));
					System.out.println("疫苗类型：" + result.getString("y_type"));
					System.out.println("疫苗名称：" + result.getString("y_name"));
					System.out.println("疫苗数量：" + result.getInt("num"));
					System.out.println("生产时间：" + result.getString("p_time"));
					String[] line = {result.getInt("y_id")+"",result.getString("y_type"), result.getString("y_name"), result.getInt("num")+"",result.getString("p_time")};
					model.addRow(line);
				}while(result.next());
				//table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void freshPro2(JTable table,int y_id){
		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from product left join wuliu on y_id='"+y_id+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No Patients!");
			}else{
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//model
				String[] columns={"疫苗id","疫苗类型","疫苗名称","疫苗数量","生产时间"};
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(e ->{
					createRecipelFrame(doctorFrame, ).setVisible(true);
    				doctorFrame.setVisible(false);
				});*/
				do{
					System.out.println("疫苗id:" + result.getInt("y_id"));
					System.out.println("疫苗类型：" + result.getString("y_type"));
					System.out.println("疫苗名称：" + result.getString("y_name"));
					System.out.println("疫苗数量：" + result.getInt("num"));
					System.out.println("生产时间：" + result.getString("p_time"));
					String[] line = {result.getInt("y_id")+"",result.getString("y_type"), result.getString("y_name"), result.getInt("num")+"",result.getString("p_time")};
					model.addRow(line);
				}while(result.next());
				//table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void myHerbalists(JTable table){
		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from t_user where type='9' or type='1'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No Patients!");
			}else{
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//model
				String[] columns={"ID","姓名","性别","年龄","手机号"};

				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);
				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(e ->{
					createRecipelFrame(doctorFrame, ).setVisible(true);
    				doctorFrame.setVisible(false);
				});*/
				do{
					System.out.println("ID:" + result.getInt("ID"));
					System.out.println("姓名：" + result.getString("NAME"));
					System.out.println("性别：" + result.getString("SEX"));
					System.out.println("年龄：" + result.getInt("AGE"));
					System.out.println("手机号：" + result.getString("PN"));
//					System.out.println("地址：" + result.getString("ADDR"));
					String[] line = {result.getInt("ID")+"",result.getString("NAME"), result.getString("SEX"), result.getInt("AGE")+"",result.getString("PN")};
					model.addRow(line);
				}while(result.next());
//				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void myPatients(JTable table){
		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from t_user where type='1' or type='2' or addr='"+ ConfigUtils.USER_Credentials.getAddress()+"'" ;
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No Patients!");
			}else{
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//model
				String[] columns={"ID","姓名","性别","年龄","手机号"};
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);
				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(e ->{
					createRecipelFrame(doctorFrame, ).setVisible(true);
    				doctorFrame.setVisible(false);
				});*/
				do{
					System.out.println("ID:" + result.getInt("ID"));
					System.out.println("姓名：" + result.getString("NAME"));
					System.out.println("性别：" + result.getString("SEX"));
					System.out.println("年龄：" + result.getInt("AGE"));
					System.out.println("卡号：" + result.getString("PN"));
					//System.out.println("地址：" + result.getString("ADDR"));
					String[] line = {result.getInt("ID")+"",result.getString("NAME"), result.getString("SEX"), result.getInt("AGE")+"",result.getString("PN")};
					model.addRow(line);
				}while(result.next());
				//table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void refreshRx(JTable table,int p_id){

		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from jiezhongdian where p_id= "+p_id;
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No rx!");
			}else{
				String[] columns={"接种人id","疫苗id","接种点","所属防疫点","第一次接种时间","是否需要第二次接种","第二次接种时间"};

				//creat table mode
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);

				
				//TableModelListener TableModelListener = new TableModelListener();
				
				/*model.addTableModelListener(l ->{
					createRecipelFrame(recipelFrame).setVisible(true);
    				recipelFrame.setVisible(false);
				});*/
				
				/*rx_id
				version
				MI
				rx_status
				id_p
				id_h
				id_d
				Money*/
				
				do{
					System.out.println("接种人id:" + result.getInt("p_id"));
//					System.out.println("version:" + result.getInt("version"));
					System.out.println("疫苗id：" + result.getInt("y_id"));
					System.out.println("接种点：" + result.getString("j_compony"));
					System.out.println("所属防疫点：" + result.getString("fangyi"));
					System.out.println("第一次接种时间：" + result.getString("f_time"));

					System.out.println("是否需要第二次接种：" + result.getString("twice"));
					System.out.println("第二次接种时间：" + result.getString("t_time"));

					String[] line = {result.getInt("p_id")+"",result.getInt("y_id")+"",result.getString("j_compony")+"",result.getString("fangyi")+"",result.getString("f_time")+"", result.getString("twice")+"", result.getString("t_time")};
					model.addRow(line);
				}while(result.next());
				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void refreshRx3(JTable table,String fangyi){

		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from jiezhongdian where fangyi= "+"'"+fangyi+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No rx!");
			}else{
				String[] columns={"接种人id","疫苗id","接种点","第一次接种时间","是否需要第二次接种","第二次接种时间"};

				//creat table mode
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(l ->{
					createRecipelFrame(recipelFrame).setVisible(true);
    				recipelFrame.setVisible(false);
				});*/

				/*rx_id
				version
				MI
				rx_status
				id_p
				id_h
				id_d
				Money*/

				do{
					System.out.println("接种人id:" + result.getInt("p_id"));
//					System.out.println("version:" + result.getInt("version"));
					System.out.println("疫苗id：" + result.getInt("y_id"));
					System.out.println("接种点：" + result.getString("j_compony"));
					System.out.println("第一次接种时间：" + result.getString("f_time"));

					System.out.println("是否需要第二次接种：" + result.getString("twice"));
					System.out.println("第二次接种时间：" + result.getString("t_time"));

					String[] line = {result.getInt("p_id")+"",result.getInt("y_id")+"",result.getString("j_compony"),result.getString("f_time")+"", result.getString("twice")+"", result.getString("t_time")};
					model.addRow(line);
				}while(result.next());
				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void refreshRx4(JTable table,String point){

		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from jiezhongdian where point = "+"'"+point+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No rx!");
			}else{
				String[] columns={"接种人id","疫苗id","接种点","第一次接种时间","是否需要第二次接种","第二次接种时间"};

				//creat table mode
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(l ->{
					createRecipelFrame(recipelFrame).setVisible(true);
    				recipelFrame.setVisible(false);
				});*/

				/*rx_id
				version
				MI
				rx_status
				id_p
				id_h
				id_d
				Money*/

				do{
					System.out.println("接种人id:" + result.getInt("p_id"));
//					System.out.println("version:" + result.getInt("version"));
					System.out.println("疫苗id：" + result.getInt("y_id"));
					System.out.println("接种点：" + result.getString("j_compony"));
					System.out.println("第一次接种时间：" + result.getString("f_time"));

					System.out.println("是否需要第二次接种：" + result.getString("twice"));
					System.out.println("第二次接种时间：" + result.getString("t_time"));

					String[] line = {result.getInt("p_id")+"",result.getInt("y_id")+"",result.getString("j_compony"),result.getString("f_time")+"", result.getString("twice")+"", result.getString("t_time")};
					model.addRow(line);
				}while(result.next());
				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void refreshwl(JTable table,int y_id){

		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from wuliu where y_id= "+y_id;
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No rx!");
			}else{
				String[] columns={"托运生产单位信息","疫苗id","疫苗名称","疫苗数量","收货时间","送达时间"};

				//creat table mode
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(l ->{
					createRecipelFrame(recipelFrame).setVisible(true);
    				recipelFrame.setVisible(false);
				});*/

				/*rx_id
				version
				MI
				rx_status
				id_p
				id_h
				id_d
				Money*/

				do{
					System.out.println("托运生产单位信息:" + result.getString("t_point"));
//					System.out.println("version:" + result.getInt("version"));
					System.out.println("疫苗id：" + result.getInt("y_id"));
					System.out.println("疫苗名称：" + result.getString("y_name"));
					System.out.println("疫苗数量：" + result.getInt("y_num"));

					System.out.println("收货时间：" + result.getString("sh_time"));
					System.out.println("送达时间：" + result.getString("sd_time"));
					String[] line = {result.getString("t_point")+"",result.getInt("y_id")+"",result.getString("y_name"),result.getInt("y_num")+"", result.getString("sh_time")+"", result.getString("sd_time")};
					model.addRow(line);
				}while(result.next());
				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void refreshwl4(JTable table,String fangyi){

		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from wuliu where d_name= "+"'"+fangyi+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No rx!");
			}else{
				String[] columns={"托运生产单位信息","疫苗id","疫苗名称","疫苗数量","收货时间","送达时间"};

				//creat table mode
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(l ->{
					createRecipelFrame(recipelFrame).setVisible(true);
    				recipelFrame.setVisible(false);
				});*/

				/*rx_id
				version
				MI
				rx_status
				id_p
				id_h
				id_d
				Money*/

				do{
					System.out.println("托运生产单位信息:" + result.getString("t_point"));
//					System.out.println("version:" + result.getInt("version"));
					System.out.println("疫苗id：" + result.getInt("y_id"));
					System.out.println("疫苗名称：" + result.getString("y_name"));
					System.out.println("疫苗数量：" + result.getInt("y_num"));

					System.out.println("收货时间：" + result.getString("sh_time"));
					System.out.println("送达时间：" + result.getString("sd_time"));
					String[] line = {result.getString("t_point")+"",result.getInt("y_id")+"",result.getString("y_name"),result.getInt("y_num")+"", result.getString("sh_time")+"", result.getString("sd_time")};
					model.addRow(line);
				}while(result.next());
				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void refreshwl2(JTable table,String c_name){

		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from wuliu where c_name= "+"'"+c_name+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No rx!");
			}else{
				String[] columns={"托运生产单位信息","疫苗id","疫苗名称","疫苗数量","收货时间","送达时间","目的防疫点"};

				//creat table mode
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(l ->{
					createRecipelFrame(recipelFrame).setVisible(true);
    				recipelFrame.setVisible(false);
				});*/

				/*rx_id
				version
				MI
				rx_status
				id_p
				id_h
				id_d
				Money*/

				do{
					System.out.println("托运生产单位信息:" + result.getString("t_point"));
//					System.out.println("version:" + result.getInt("version"));
					System.out.println("疫苗id：" + result.getInt("y_id"));
					System.out.println("疫苗名称：" + result.getString("y_name"));
					System.out.println("疫苗数量：" + result.getInt("y_num"));

					System.out.println("收货时间：" + result.getString("sh_time"));
					System.out.println("送达时间：" + result.getString("sd_time"));
					System.out.println("目的防疫点" + result.getString("d_name"));
					String[] line = {result.getString("t_point")+"",result.getInt("y_id")+"",result.getString("y_name"),result.getInt("y_num")+"", result.getString("sh_time")+"", result.getString("sd_time")+"", result.getString("d_name")};
					model.addRow(line);
				}while(result.next());
				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void refreshpre(JTable table,int y_id){

		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from fangyi where y_id= "+y_id;
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No rx!");
			}else{
				String[] columns={"物流单位","疫苗id","疫苗名称","疫苗数量"};

				//creat table mode
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(l ->{
					createRecipelFrame(recipelFrame).setVisible(true);
    				recipelFrame.setVisible(false);
				});*/

				/*rx_id
				version
				MI
				rx_status
				id_p
				id_h
				id_d
				Money*/

				do{
					System.out.println("物流公司:" + result.getString("wuliuaddress"));
					System.out.println("疫苗溯源id：" + result.getInt("y_id"));
					System.out.println("疫苗名称：" + result.getString("y_name"));
					System.out.println("疫苗数量：" + result.getString("y_num"));

//					System.out.println("第二次接种时间：" + result.getString("t_time"));
					String[] line = {result.getString("wuliuaddress")+"",result.getInt("y_id")+"",result.getString("y_name"),result.getString("y_num")};
					model.addRow(line);
				}while(result.next());
				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void refreshpre(JTable table,String fangyi){

		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from fangyi where fangyi= "+"'"+fangyi+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No rx!");
			}else{
				String[] columns={"物流单位","疫苗id","疫苗名称","疫苗数量"};

				//creat table mode
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(l ->{
					createRecipelFrame(recipelFrame).setVisible(true);
    				recipelFrame.setVisible(false);
				});*/

				/*rx_id
				version
				MI
				rx_status
				id_p
				id_h
				id_d
				Money*/

				do{
					System.out.println("物流公司:" + result.getString("wuliuaddress"));
					System.out.println("疫苗溯源id：" + result.getInt("y_id"));
					System.out.println("疫苗名称：" + result.getString("y_name"));
					System.out.println("疫苗数量：" + result.getString("y_num"));

//					System.out.println("第二次接种时间：" + result.getString("t_time"));
					String[] line = {result.getString("wuliuaddress")+"",result.getInt("y_id")+"",result.getString("y_name"),result.getString("y_num")};
					model.addRow(line);
				}while(result.next());
				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void refreshwl3(JTable table,String t_name){

		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from wuliu where t_point= "+"'"+t_name+"'";
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No rx!");
			}else{
				String[] columns={"托运生产单位信息","疫苗id","疫苗名称","疫苗数量","收货时间","送达时间","生产厂家","目的防疫点"};

				//creat table mode
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);


				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(l ->{
					createRecipelFrame(recipelFrame).setVisible(true);
    				recipelFrame.setVisible(false);
				});*/

				/*rx_id
				version
				MI
				rx_status
				id_p
				id_h
				id_d
				Money*/

				do{
					System.out.println("托运生产单位信息:" + result.getString("t_point"));
//					System.out.println("version:" + result.getInt("version"));
					System.out.println("疫苗id：" + result.getInt("y_id"));
					System.out.println("疫苗名称：" + result.getString("y_name"));
					System.out.println("疫苗数量：" + result.getInt("y_num"));

					System.out.println("收货时间：" + result.getString("sh_time"));
					System.out.println("送达时间：" + result.getString("sd_time"));
					System.out.println("生产厂家：" + result.getString("c_name"));
					System.out.println("目的防疫点" + result.getString("d_name"));
					String[] line = {result.getString("t_point")+"",result.getInt("y_id")+"",result.getString("y_name"),result.getInt("y_num")+"", result.getString("sh_time")+"", result.getString("sd_time")+"", result.getString("c_name")+"", result.getString("d_name")};
					model.addRow(line);
				}while(result.next());
				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void refreshRx2(JTable table,String idP){

		Connection con;
		try {
			con = MySqlUtils.getConnection();
			Statement state = con.createStatement();
			String querySql = "select * from rx where id_p= "+idP;
			ResultSet result = state.executeQuery(querySql);
			//System.out.println(result.getRow());
			if(!result.next()){
				System.out.println("No rx!");
			}else{
				String[] columns={"ID","mi","status","id_h","id_d","Money"};

				//creat table mode
				DefaultTableModel model=new DefaultTableModel(columns, 0);
				table.setModel(model);

				//TableModelListener TableModelListener = new TableModelListener();

				/*model.addTableModelListener(l ->{
					createRecipelFrame(recipelFrame).setVisible(true);
    				recipelFrame.setVisible(false);
				});*/

				/*rx_id
				version
				MI
				rx_status
				id_p
				id_h
				id_d
				Money*/

				do{
					System.out.println("ID:" + result.getInt("rx_id"));
//					System.out.println("version:" + result.getInt("version"));
					System.out.println("mi：" + result.getString("MI"));
					System.out.println("status：" + result.getString("rx_status"));
					System.out.println("id_h：" + result.getInt("id_h"));
					System.out.println("id_d：" + result.getInt("id_d"));
					System.out.println("Money：" + result.getBigDecimal("Money"));
					String[] line = {result.getInt("rx_id")+"",result.getString("MI")+"",result.getString("rx_status"),result.getInt("id_h")+"", result.getInt("id_d")+"",result.getBigDecimal("Money").toString()};
					model.addRow(line);
				}while(result.next());
				table.removeEditor();
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
