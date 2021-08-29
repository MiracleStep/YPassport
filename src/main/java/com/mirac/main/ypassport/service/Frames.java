package com.mirac.main.ypassport.service;

import org.web3j.crypto.Credentials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*swing界面代码1*/
public class Frames {
	static String privatkey;
	//https://mainnet.infura.io/v3/cd782eac6d9d4730a682ad3bc4df7bcd
	
	
	//public static  ExecutorService executorService;
	
	public static JFrame createMainFrame() {
		 // 创建 JFrame 实例
        JFrame mainFrame = new JFrame("基于区块链智能合约的医疗用药监控系统");
        // Setting the width and height of frame
        mainFrame.setBounds(0,0,1843,1080);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();    
        // 添加面板
        mainFrame.add(panel);
		
        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建登录按钮
		JLabel privateKeyLabel2 = new JLabel("疫苗护照");
		privateKeyLabel2.setFont(new Font("宋体", Font.BOLD,50));
		privateKeyLabel2.setBounds(820, 200, 240, 50);
		panel.add(privateKeyLabel2);


        JLabel privateKeyLabel = new JLabel("请输入私钥: ");
		privateKeyLabel.setFont(new Font("宋体", Font.BOLD,20));
        privateKeyLabel.setBounds(870, 300, 240, 50);
        panel.add(privateKeyLabel);


        JTextField privateKeyText = new JTextField(20);
		privateKeyText.setFont(new Font("宋体", Font.BOLD,20));
        privateKeyText.setBounds(500,350,850,50);
        panel.add(privateKeyText);
        
        JButton button1 = new JButton("登录");
		button1.setFont(new Font("宋体", Font.BOLD,20));
        button1.setBounds(800, 440, 240, 50);
        panel.add(button1);
        
        
        button1.addActionListener(al -> {
        	button1.setEnabled(false);
        	privatkey = privateKeyText.getText().trim();
        	System.out.println(privatkey);
//        	executorService = Executors.newFixedThreadPool(new Integer(threadText.getText().trim()));
        	
        	//transfer privateKey to address then identify user's role
         	ConfigUtils.USER_Credentials = Credentials.create(privateKeyText.getText().trim());
//        	System.out.println(ConfigUtils.USER_Credentials.getAddress());
        	Connection con;
        	try {
        		con = MySqlUtils.getConnection();
        		if(con==null){
					System.out.println("连接失败");
				}
        		System.out.println("连接成功");
        		Statement state = con.createStatement();

//        		String querySql = "select * from t_user where addr='"+ ConfigUtils.USER_Credentials.getAddress()+"'";
				String querySql = "select * from point where id='"+privatkey+"'";
        		ResultSet result = state.executeQuery(querySql);

        		if(!result.next()){
        			System.out.println("wrong key no user!");
        		}
        		else{
//        			System.out.println("疫苗ID:" + result.getInt("y_id"));
//					System.out.println("疫苗类型"+result.getString("y_type"));
//        			System.out.println("疫苗名称：" + result.getString("y_name"));
//        			System.out.println("数量：" + result.getInt("num"));
//        			System.out.println("生产时间：" + result.getString("p_time"));
        			/*while(result.next()) {
							System.out.println("ID:" + result.getInt("ID"));
							System.out.println("姓名：" + result.getString("NAME"));
							System.out.println("性别：" + result.getString("SEX"));
							System.out.println("年龄：" + result.getInt("AGE"));
							System.out.println("卡号：" + result.getString("PN"));
							System.out.println("类型：" + result.getString("TPYE"));
							System.out.println("地址：" + result.getString("ADDR"));
							System.out.println();
							
						}*/
        			
        			String type = result.getString("type");
        			ConfigUtils.y_name =  result.getString("y_name");
        			ConfigUtils.y_id= result.getInt("y_id");
        			ConfigUtils.p_id = result.getInt("p_id");
					ConfigUtils.p_name = result.getString("p_name");
					ConfigUtils.c_name = result.getString("c_name");
					ConfigUtils.t_name = result.getString("t_name");
					ConfigUtils.fangyi = result.getString("fangyi");
					ConfigUtils.point = result.getString("point");

					System.out.println(ConfigUtils.WEB3_J);
        			switch (type) {
        			case "1": //生产单位
        				ConfigUtils.Recipel_Contract = new Recipel(ConfigUtils.Recipel_Address, ConfigUtils.WEB3_J, ConfigUtils.USER_Credentials, ConfigUtils.GAS_PRICE, ConfigUtils.GAS_LIMIT);
        				createProductFrame(mainFrame).setVisible(true);
        				mainFrame.setVisible(false);
        				break;
        				
        			case "2": //物流单位
							ConfigUtils.Recipel_Contract = new Recipel(ConfigUtils.Recipel_Address, ConfigUtils.WEB3_J, ConfigUtils.USER_Credentials, ConfigUtils.GAS_PRICE, ConfigUtils.GAS_LIMIT);
							createWuLiuFrame(mainFrame).setVisible(true);
							mainFrame.setVisible(false);
							break;
        				
        			case "3": //防疫单位
						ConfigUtils.Recipel_Contract = new Recipel(ConfigUtils.Recipel_Address, ConfigUtils.WEB3_J, ConfigUtils.USER_Credentials, ConfigUtils.GAS_PRICE, ConfigUtils.GAS_LIMIT);
						createPreventFrame(mainFrame).setVisible(true);
						mainFrame.setVisible(false);
        				break;

					case "4": //疫苗接种点
						ConfigUtils.Recipel_Contract = new Recipel(ConfigUtils.Recipel_Address, ConfigUtils.WEB3_J, ConfigUtils.USER_Credentials, ConfigUtils.GAS_PRICE, ConfigUtils.GAS_LIMIT);
						createPointFrame(mainFrame).setVisible(true);
						mainFrame.setVisible(false);
						break;

					case "5": //疫苗接种人员
						ConfigUtils.Recipel_Contract = new Recipel(ConfigUtils.Recipel_Address, ConfigUtils.WEB3_J, ConfigUtils.USER_Credentials, ConfigUtils.GAS_PRICE, ConfigUtils.GAS_LIMIT);
						createPersonFrame(mainFrame).setVisible(true);
						mainFrame.setVisible(false);
						break;
        				
        			default:
        				break;
        			}
        			
        			
        		}
        		con.close();
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		System.out.println("something wrong!");
        	}
        	button1.setEnabled(true);
        });
        return mainFrame;
    }
	
	private static JFrame createProductFrame(JFrame mainFrame) {
		JFrame doctorFrame = new JFrame("欢迎使用本系统！" );
		doctorFrame.setBounds(mainFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();    
		
		panel.setLayout(null);

		JTable pTable=getProductTable();
		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DbUtils.freshPro(pTable,ConfigUtils.y_id);

		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(800, 650, 200, 50);
		panel.add(addButton);
        JButton returnButton = new JButton("return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(450, 650, 200, 50);
		panel.add(returnButton);

		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doctorFrame.setVisible(false);
				mainFrame.setBounds(doctorFrame.getBounds());
				mainFrame.setVisible(true);
			}
		});
		JButton wuLiuButton = new JButton("查看此厂家物流");
		wuLiuButton.setFont(new Font("宋体", Font.BOLD,20));
		wuLiuButton.setBounds(1150, 650, 200, 50);
		panel.add(wuLiuButton);

		wuLiuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame wuliuFrame = createWuLiuFrame2(doctorFrame,pTable);
				wuliuFrame.setVisible(true);
				doctorFrame.setVisible(false);
				mainFrame.setBounds(doctorFrame.getBounds());
			}
		});
        JScrollPane jsp = new JScrollPane(pTable);
        jsp.setBounds(450, 100, 900, 540);
        panel.add(jsp);
        
        doctorFrame.add(panel);
        return doctorFrame;
    }

	private static JFrame createWuLiuFrame(JFrame mainFrame) {
		JFrame herbalistFrame = new JFrame("欢迎使用本系统！" );
		herbalistFrame.setBounds(mainFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		herbalistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();

		panel.setLayout(null);

		JTable pTable=getWuLiuTable();
		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DbUtils.refreshwl3(pTable,ConfigUtils.t_name);

		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(550, 650, 200, 50);
		panel.add(addButton);
		JButton returnButton = new JButton("return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(990, 650, 200, 50);
		panel.add(returnButton);

		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				herbalistFrame.setVisible(false);
				mainFrame.setBounds(herbalistFrame.getBounds());
				mainFrame.setVisible(true);
			}
		});

		JScrollPane jsp = new JScrollPane(pTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		herbalistFrame.add(panel);
		return herbalistFrame;
	}

	private static JFrame createPreventFrame(JFrame mainFrame) {
		JFrame doctorFrame = new JFrame("欢迎使用本系统！" );
		doctorFrame.setBounds(mainFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();

		panel.setLayout(null);

		JTable pTable=getProductTable();
		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DbUtils.refreshpre(pTable,ConfigUtils.fangyi);

		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(400, 650, 200, 50);
		panel.add(addButton);
		addButton.addActionListener(l -> {
			//新增
			createSaveRecipelFrame3(doctorFrame,pTable,ConfigUtils.fangyi,null).setVisible(true);
			doctorFrame.setVisible(false);
		});
		JButton returnButton = new JButton("return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(650, 650, 200, 50);
		panel.add(returnButton);

		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doctorFrame.setVisible(false);
				mainFrame.setBounds(doctorFrame.getBounds());
				mainFrame.setVisible(true);
			}
		});
		JButton wuLiuButton = new JButton("查看此防疫点物流");
		wuLiuButton.setFont(new Font("宋体", Font.BOLD,20));
		wuLiuButton.setBounds(880, 650, 250, 50);
		panel.add(wuLiuButton);

		wuLiuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame wuliuFrame = createWuLiuFrame3(doctorFrame,pTable);
				wuliuFrame.setVisible(true);
				doctorFrame.setVisible(false);
				mainFrame.setBounds(doctorFrame.getBounds());
			}
		});
		JButton pointButton = new JButton("查看此防疫点内接种点");
		pointButton.setFont(new Font("宋体", Font.BOLD,20));
		pointButton.setBounds(1150, 650, 250, 50);
		panel.add(pointButton);
		pointButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame pointFrame = createPointFrame2(doctorFrame,pTable);
				pointFrame.setVisible(true);
				doctorFrame.setVisible(false);
				mainFrame.setBounds(doctorFrame.getBounds());
			}
		});
		JScrollPane jsp = new JScrollPane(pTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		doctorFrame.add(panel);
		return doctorFrame;
	}

	private static JFrame createPointFrame(JFrame personFrame,JTable pTable) {
		JFrame pointFrame = new JFrame("接种点信息" );
		pointFrame.setBounds(personFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		pointFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JTable rTable=getPointTable();
		rTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//recipelFrame.listene
		DbUtils.refreshRx(rTable,ConfigUtils.p_id);


		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(700, 650, 200, 50);
		panel.add(returnButton);


		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pointFrame.setVisible(false);
				personFrame.setBounds(pointFrame.getBounds());
				DbUtils.freshPatients(pTable);
				personFrame.setVisible(true);
			}
		});

		JScrollPane jsp = new JScrollPane(rTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		pointFrame.add(panel);
		return pointFrame;
	}
	private static JFrame createPointFrame2(JFrame personFrame,JTable pTable) {
		JFrame pointFrame = new JFrame("接种点信息" );
		pointFrame.setBounds(personFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		pointFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JTable rTable=getPointTable();
		rTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//recipelFrame.listene
		DbUtils.refreshRx3(rTable,ConfigUtils.fangyi);

		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(691, 650, 200, 50);
		panel.add(addButton);

//		addButton.addActionListener(l -> {
//
//			//新增
//			createSaveRecipelFrame(PointFrame,rTable,idP,null).setVisible(true);
//			PointFrame.setVisible(false);
//		});


		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(891, 650, 200, 50);
		panel.add(returnButton);


		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pointFrame.setVisible(false);
				personFrame.setBounds(pointFrame.getBounds());
				DbUtils.freshPatients(pTable);
				personFrame.setVisible(true);
			}
		});

		JScrollPane jsp = new JScrollPane(rTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		pointFrame.add(panel);
		return pointFrame;
	}
	private static JFrame createPreventFrame(JFrame pointFrame,JTable pTable) {
		JFrame preventFrame = new JFrame("防疫信息" );
		preventFrame.setBounds(pointFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		preventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JTable rTable=getPreventTable();
		rTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		//recipelFrame.listene
		DbUtils.refreshpre(rTable,ConfigUtils.y_id);

		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(691, 650, 200, 50);
		panel.add(addButton);

//		addButton.addActionListener(l -> {
//
//			//新增
//			createSaveRecipelFrame(PointFrame,rTable,idP,null).setVisible(true);
//			PointFrame.setVisible(false);
//		});


		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(891, 650, 200, 50);
		panel.add(returnButton);


		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				preventFrame.setVisible(false);
				pointFrame.setBounds(pointFrame.getBounds());
				DbUtils.freshPatients(pTable);
				pointFrame.setVisible(true);
			}
		});

		JScrollPane jsp = new JScrollPane(rTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		preventFrame.add(panel);
		return preventFrame;
	}
	private static JFrame createPreventFrame2(JFrame pointFrame,JTable pTable) {
		JFrame preventFrame = new JFrame("防疫信息" );
		preventFrame.setBounds(pointFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		preventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JTable rTable=getPreventTable();
		rTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		//recipelFrame.listene
		DbUtils.refreshpre(rTable,ConfigUtils.fangyi);

		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(891, 650, 200, 50);
		panel.add(returnButton);


		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				preventFrame.setVisible(false);
				pointFrame.setBounds(pointFrame.getBounds());
				DbUtils.freshPatients(pTable);
				pointFrame.setVisible(true);
			}
		});

		JScrollPane jsp = new JScrollPane(rTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		preventFrame.add(panel);
		return preventFrame;
	}
	private static JFrame createWuLiuFrame(JFrame preventFrame,JTable pTable) {
		JFrame wuliuFrame = new JFrame("防疫信息" );
		wuliuFrame.setBounds(preventFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		wuliuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JTable rTable=getPreventTable();
		rTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rTable.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//do something
				// System.out.println("2222222222222222");
				//table.getSelectedRow();
				createProductFrame(wuliuFrame,rTable).setVisible(true);
				wuliuFrame.setVisible(false);
			}
		});


		//recipelFrame.listene
		DbUtils.refreshwl(rTable,ConfigUtils.y_id);

		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(691, 650, 200, 50);
		panel.add(addButton);

//		addButton.addActionListener(l -> {
//
//			//新增
//			createSaveRecipelFrame(PointFrame,rTable,idP,null).setVisible(true);
//			PointFrame.setVisible(false);
//		});


		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(891, 650, 200, 50);
		panel.add(returnButton);


		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wuliuFrame.setVisible(false);
				preventFrame.setBounds(wuliuFrame.getBounds());
				DbUtils.freshPatients(pTable);
				preventFrame.setVisible(true);
			}
		});

		JScrollPane jsp = new JScrollPane(rTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		wuliuFrame.add(panel);
		return wuliuFrame;
	}
	private static JFrame createWuLiuFrame2(JFrame preventFrame,JTable pTable) {
		JFrame wuliuFrame = new JFrame("物流信息" );
		wuliuFrame.setBounds(preventFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		wuliuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JTable rTable=getPreventTable();
		rTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DbUtils.refreshwl2(rTable,ConfigUtils.c_name);
		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(691, 650, 200, 50);
		panel.add(addButton);

//		addButton.addActionListener(l -> {
//
//			//新增
//			createSaveRecipelFrame(PointFrame,rTable,idP,null).setVisible(true);
//			PointFrame.setVisible(false);
//		});


		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(891, 650, 200, 50);
		panel.add(returnButton);


		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wuliuFrame.setVisible(false);
				preventFrame.setBounds(wuliuFrame.getBounds());
				DbUtils.freshPatients(pTable);
				preventFrame.setVisible(true);
			}
		});

		JScrollPane jsp = new JScrollPane(rTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		wuliuFrame.add(panel);
		return wuliuFrame;
	}
	private static JFrame createWuLiuFrame3(JFrame preventFrame,JTable pTable) {
		JFrame wuliuFrame = new JFrame("物流信息" );
		wuliuFrame.setBounds(preventFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		wuliuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JTable rTable=getPreventTable();
		rTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DbUtils.refreshwl4(rTable,ConfigUtils.fangyi);
		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(691, 650, 200, 50);
		panel.add(addButton);

//		addButton.addActionListener(l -> {
//
//			//新增
//			createSaveRecipelFrame(PointFrame,rTable,idP,null).setVisible(true);
//			PointFrame.setVisible(false);
//		});


		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(891, 650, 200, 50);
		panel.add(returnButton);


		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wuliuFrame.setVisible(false);
				preventFrame.setBounds(wuliuFrame.getBounds());
				DbUtils.freshPatients(pTable);
				preventFrame.setVisible(true);
			}
		});

		JScrollPane jsp = new JScrollPane(rTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		wuliuFrame.add(panel);
		return wuliuFrame;
	}
	private static JFrame createProductFrame(JFrame pointFrame,JTable pTable) {
		JFrame productFrame = new JFrame("用药信息" );
		productFrame.setBounds(pointFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		productFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JTable rTable=getPointTable();
		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//recipelFrame.listene
		DbUtils.freshPro(rTable,ConfigUtils.y_id);

		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(691, 650, 200, 50);
		panel.add(addButton);

//		addButton.addActionListener(l -> {
//
//			//新增
//			createSaveRecipelFrame(PointFrame,rTable,idP,null).setVisible(true);
//			PointFrame.setVisible(false);
//		});


		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(891, 650, 200, 50);
		panel.add(returnButton);


		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productFrame.setVisible(false);
				pointFrame.setBounds(productFrame.getBounds());
				DbUtils.freshPatients(pTable);
				pointFrame.setVisible(true);
			}
		});


		JScrollPane jsp = new JScrollPane(rTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		productFrame.add(panel);
		return productFrame;
	}
	private static JFrame createPersonFrame(JFrame pointFrame,JTable pTable,String p_id) {
		JFrame productFrame = new JFrame("" );
		productFrame.setBounds(pointFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		productFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JTable rTable=getPointTable();
		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//recipelFrame.listene
		DbUtils.freshPerson2(rTable,p_id);

		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(691, 650, 200, 50);
		panel.add(addButton);

		addButton.addActionListener(l -> {

			//新增
			createSaveRecipelFrame4(productFrame,rTable,p_id,null).setVisible(true);
			productFrame.setVisible(false);
		});


		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(891, 650, 200, 50);
		panel.add(returnButton);


		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productFrame.setVisible(false);
				pointFrame.setBounds(productFrame.getBounds());
				DbUtils.freshPatients(pTable);
				pointFrame.setVisible(true);
			}
		});


		JScrollPane jsp = new JScrollPane(rTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		productFrame.add(panel);
		return productFrame;
	}



	private static JFrame createPointFrame(JFrame mainFrame) {
		JFrame doctorFrame = new JFrame("欢迎使用本系统！" );
		doctorFrame.setBounds(mainFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();

		panel.setLayout(null);

		JTable pTable=getProductTable();
		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pTable.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//do something
				// System.out.println("2222222222222222");
				//table.getSelectedRow();
				String p_id = (String) pTable.getValueAt(pTable.getSelectedRow(), 0);
				createPersonFrame(doctorFrame,pTable,p_id).setVisible(true);
				doctorFrame.setVisible(false);
			}
		});
		DbUtils.refreshRx4(pTable,ConfigUtils.point);

		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(450, 650, 200, 50);
		panel.add(addButton);
		addButton.addActionListener(l -> {

			//新增
			createSaveRecipelFrame4(doctorFrame,pTable,ConfigUtils.fangyi,null).setVisible(true);
			doctorFrame.setVisible(false);
		});
		JButton returnButton = new JButton("return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(770, 650, 200, 50);
		panel.add(returnButton);

		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doctorFrame.setVisible(false);
				mainFrame.setBounds(doctorFrame.getBounds());
				mainFrame.setVisible(true);
			}
		});
		JButton wuLiuButton = new JButton("查看此接种点所属");
		wuLiuButton.setFont(new Font("宋体", Font.BOLD,20));
		wuLiuButton.setBounds(1100, 650, 250, 50);
		panel.add(wuLiuButton);

		wuLiuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame preventFrame = createPreventFrame(doctorFrame,pTable);
				preventFrame.setVisible(true);
				doctorFrame.setVisible(false);
				mainFrame.setBounds(doctorFrame.getBounds());
			}
		});

		JScrollPane jsp = new JScrollPane(pTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		doctorFrame.add(panel);
		return doctorFrame;
	}
	private static JFrame createPersonFrame(JFrame mainFrame) {
		JFrame personFrame = new JFrame("欢迎使用本系统！" );
		personFrame.setBounds(mainFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		personFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();

		panel.setLayout(null);

		JTable pTable=getPersonTable();
		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pTable.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//do something
				// System.out.println("2222222222222222");
				//table.getSelectedRow();
				createPointFrame(personFrame,pTable).setVisible(true);
				personFrame.setVisible(false);
			}
		});
		DbUtils.freshPerson(pTable,ConfigUtils.p_id);

		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("宋体", Font.BOLD,20));
		addButton.setBounds(550, 650, 200, 50);
		panel.add(addButton);
		JButton returnButton = new JButton("return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(1000, 650, 200, 50);
		panel.add(returnButton);

		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				personFrame.setVisible(false);
				mainFrame.setBounds(personFrame.getBounds());
				mainFrame.setVisible(true);
			}
		});

		JScrollPane jsp = new JScrollPane(pTable);
		jsp.setBounds(450, 100, 900, 540);
		panel.add(jsp);

		personFrame.add(panel);
		return personFrame;
	}
	private static JFrame createSaveRecipelFrame3(JFrame recipelFrame,JTable rTable, String fangyi, String[] rxDetail) {
		JFrame saveRecipelFrame = new JFrame("添加信息" );
		saveRecipelFrame.setBounds(recipelFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		saveRecipelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);

		boolean flag = false;

		JLabel miLab = new JLabel("物流单位：");
		miLab.setFont(new Font("宋体", Font.BOLD,20));
		miLab.setBounds(600, 300, 120, 50);
		panel.add(miLab);
		JTextField wuliuText = new JTextField(20);
		wuliuText.setFont(new Font("宋体", Font.BOLD,20));
		wuliuText.setBounds(700,300,500,50);
		panel.add(wuliuText);

		JLabel moneyLab = new JLabel("疫苗名称：");
		moneyLab.setFont(new Font("宋体", Font.BOLD,20));
		moneyLab.setBounds(600,350,120,50);
		panel.add(moneyLab);
		JTextField moneyText = new JTextField(20);
		moneyText.setFont(new Font("宋体", Font.BOLD,20));
		moneyText.setBounds(700,350,500,50);
		panel.add(moneyText);
		JLabel yimiaoId = new JLabel("疫苗id：");
		yimiaoId.setFont(new Font("宋体", Font.BOLD,20));
		yimiaoId.setBounds(600,400,120,50);
		panel.add(yimiaoId);
		JTextField idText = new JTextField(20);
		idText.setFont(new Font("宋体", Font.BOLD,20));
		idText.setBounds(700,400,500,50);
		panel.add(idText);
		JLabel y_num = new JLabel("疫苗数量：");
		y_num.setFont(new Font("宋体", Font.BOLD,20));
		y_num.setBounds(600,450,120,50);
		panel.add(y_num);
		JTextField yimiaoText = new JTextField(20);
		yimiaoText.setFont(new Font("宋体", Font.BOLD,20));
		yimiaoText.setBounds(700,450,500,50);
		panel.add(yimiaoText);

		if(rxDetail == null){
			flag = true;
		}else{

		}
		final boolean insertFlag = flag;
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("宋体", Font.BOLD,20));
		saveButton.setBounds(760, 500, 100, 50);
		panel.add(saveButton);

		saveButton.addActionListener(l -> {
			String querySql = "";
			//createSaveRecipelFrame(saveRecipelFrame, null).setVisible(true);
			//saveRecipelFrame.setEnabled(false);
			if(insertFlag){
				int id = 0;
				Connection con;
//				try {
//					con = MySqlUtils.getConnection();
//					Statement state = con.createStatement();
//					ResultSet result = state.executeQuery("select max(rx_id) as max_id from rx");
//					if(result.next()){
//						//System.out.println(result.getRow());
//						id = result.getInt("max_id");
//						con.close();
//					}
//
//				} catch (SQLException e1) {
//					 TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

				querySql= "INSERT INTO fangyi "
						+ "VALUES ("+ "'"+wuliuText.getText() +"'" +","+idText.getText()+", "+"'"+moneyText.getText()+"'"+", "+ yimiaoText.getText()+", "+"'"+ ConfigUtils.fangyi+"'" + ")";
				new Thread(new ChainRunnable(wuliuText.getText(), idText.getText(), moneyText.getText(), yimiaoText.getText(),ConfigUtils.fangyi)).start();

			}
//			else{
//				querySql ="update rx set version = version+1, MI="+ miText.getText().trim() +" where ";
//			}


			Connection con;
			try {
				con = MySqlUtils.getConnection();
				Statement state = con.createStatement();
				boolean result = state.execute(querySql);
				//System.out.println(result.getRow());
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println(querySql);
			//todo sql insert update
			saveRecipelFrame.setVisible(false);
			DbUtils.refreshpre(rTable,ConfigUtils.fangyi);
			recipelFrame.setVisible(true);
		});


		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(1000, 500, 100, 50);
		panel.add(returnButton);

		returnButton.addActionListener(l -> {
			saveRecipelFrame.setVisible(false);
			recipelFrame.setBounds(saveRecipelFrame.getBounds());
			recipelFrame.setVisible(true);
		});

		saveRecipelFrame.add(panel);
		return saveRecipelFrame;
	}
	private static JFrame createSaveRecipelFrame4(JFrame recipelFrame,JTable rTable, String fangyi, String[] rxDetail) {
		JFrame saveRecipelFrame = new JFrame("添加信息" );
		saveRecipelFrame.setBounds(recipelFrame.getBounds());
		//frame.setLayout(new BorderLayout());
		saveRecipelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);

		boolean flag = false;

		JLabel miLab = new JLabel("疫苗id：");
		miLab.setFont(new Font("宋体", Font.BOLD,20));
		miLab.setBounds(600, 300, 120, 50);
		panel.add(miLab);
		JTextField wuliuText = new JTextField(20);
		wuliuText.setFont(new Font("宋体", Font.BOLD,20));
		wuliuText.setBounds(700,300,500,50);
		panel.add(wuliuText);
		JLabel addressLab = new JLabel("接种人籍贯：");
		addressLab.setFont(new Font("宋体", Font.BOLD,20));
		addressLab.setBounds(600,350,150,50);
		panel.add(addressLab);
		JTextField addressText = new JTextField(20);
		addressText.setFont(new Font("宋体", Font.BOLD,20));
		addressText.setBounds(730,350,500,50);
		panel.add(addressText);
		JLabel moneyLab = new JLabel("第一次接种时间：");
		moneyLab.setFont(new Font("宋体", Font.BOLD,20));
		moneyLab.setBounds(600,400,210,50);
		panel.add(moneyLab);
		JTextField moneyText = new JTextField(20);
		moneyText.setFont(new Font("宋体", Font.BOLD,20));
		moneyText.setBounds(790,400,500,50);
		panel.add(moneyText);
		JLabel yimiaoId = new JLabel("是否接种第二次：");
		yimiaoId.setFont(new Font("宋体", Font.BOLD,20));
		yimiaoId.setBounds(600,450,210,50);
		panel.add(yimiaoId);
		JTextField idText = new JTextField(20);
		idText.setFont(new Font("宋体", Font.BOLD,20));
		idText.setBounds(790,450,500,50);
		panel.add(idText);
		JLabel y_num = new JLabel("第二次接种时间：");
		y_num.setFont(new Font("宋体", Font.BOLD,20));
		y_num.setBounds(600,500,210,50);
		panel.add(y_num);
		JTextField yimiaoText = new JTextField(20);
		yimiaoText.setFont(new Font("宋体", Font.BOLD,20));
		yimiaoText.setBounds(790,500,500,50);
		panel.add(yimiaoText);
		JLabel compony = new JLabel("接种机构：");
		compony.setFont(new Font("宋体", Font.BOLD,20));
		compony.setBounds(600,550,120,50);
		panel.add(compony);
		JTextField componyText = new JTextField(20);
		componyText.setFont(new Font("宋体", Font.BOLD,20));
		componyText.setBounds(700,500,500,50);
		panel.add(componyText);

		if(rxDetail == null){
			flag = true;
		}else{

		}
		final boolean insertFlag = flag;
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("宋体", Font.BOLD,20));
		saveButton.setBounds(760, 500, 100, 50);
		panel.add(saveButton);

		saveButton.addActionListener(l -> {
			String querySql = "";

			if(insertFlag){
				int id = 0;
				Connection con;


				querySql= "INSERT INTO jiezhongdian(y_id,jiezhong,f_time,j_compony,twice,t_time) "
						+ "VALUES ("+ "'"+wuliuText.getText() +"'" +","+idText.getText()+", "+"'"+moneyText.getText()+"'"+", "+ yimiaoText.getText()+", "+"'"+ ConfigUtils.fangyi+"'" + ")";
				new Thread(new ChainRunnable(wuliuText.getText(), idText.getText(), moneyText.getText(), yimiaoText.getText(),ConfigUtils.fangyi)).start();

			}
//			else{
//				querySql ="update rx set version = version+1, MI="+ miText.getText().trim() +" where ";
//			}


			Connection con;
			try {
				con = MySqlUtils.getConnection();
				Statement state = con.createStatement();
				boolean result = state.execute(querySql);
				//System.out.println(result.getRow());
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println(querySql);
			//todo sql insert update
			saveRecipelFrame.setVisible(false);
			DbUtils.refreshpre(rTable,ConfigUtils.fangyi);
			recipelFrame.setVisible(true);
		});


		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("宋体", Font.BOLD,20));
		returnButton.setBounds(1000, 500, 100, 50);
		panel.add(returnButton);

		returnButton.addActionListener(l -> {
			saveRecipelFrame.setVisible(false);
			recipelFrame.setBounds(saveRecipelFrame.getBounds());
			recipelFrame.setVisible(true);
		});

		saveRecipelFrame.add(panel);
		return saveRecipelFrame;
	}


	private static JTable getProductTable() {
		JTable table=new JTable();
		table.setFont(new Font("宋体", Font.BOLD,20));
		table.setRowHeight(30);
		return table;
	}

	private static JTable getWuLiuTable(){
		JTable table=new JTable();
		table.setFont(new Font("宋体", Font.BOLD,20));
		table.setRowHeight(30);
		return table;
	}
	private static JTable getPreventTable() {
		JTable table=new JTable();
		table.setFont(new Font("宋体", Font.BOLD,20));
		table.setRowHeight(30);
		return table;
	}

	private static JTable getPointTable(){
		JTable table=new JTable();
		table.setFont(new Font("宋体", Font.BOLD,20));
		table.setRowHeight(30);
		return table;
	}
	private static JTable getPersonTable(){
		JTable table=new JTable();
		table.setFont(new Font("宋体", Font.BOLD,20));
		table.setRowHeight(30);
		return table;
	}

}
