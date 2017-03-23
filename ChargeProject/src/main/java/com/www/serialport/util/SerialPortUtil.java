package com.www.serialport.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

/***
 * 串口通讯工具类
 * @author usb9usb
 *
 */
public class SerialPortUtil {
	/***
	 * 创建端口
	 * @param CommPortName 端口名 如COM3
	 * @param timeout 超时时间
	 *  SerialPort.DATABITS_8,           //数据位  
	 *  SerialPort.STOPBITS_1,         //停止位
	 *  SerialPort.PARITY_NONE //校验位
	 */
	public static SerialPort createPort(String CommPortName, int timeOutms, int baudRate,
			int databits, int stopbits, int parity){
		SerialPort  serialPort = null;
		try {
			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(CommPortName); //串口号  
	        serialPort = (SerialPort) portIdentifier.open("charge",5000); //程序名称  和 最大响应时长(ms)  
	        serialPort.setSerialPortParams(baudRate, databits, stopbits, parity);            
	        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
        return serialPort;
        
	}
	
	//发送消息
	public static void sendMsg(SerialPort serialPort,String data){
		try {
			 OutputStream outputStream = serialPort.getOutputStream();
			 outputStream.write(data.getBytes()); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
	}
	
	//接受消息
	public static String getMsg(SerialPort serialPort){
		 InputStream inputStream = null;
		 byte[] readBuffer = new byte[1024];
		 String res = "";
		 try {  
	         inputStream = serialPort.getInputStream();  
	         // 从线路上读取数据流  
	         int len = 0;  
	         while ((len = inputStream.read(readBuffer)) != -1) {  
	             //System.out.println("实时反馈：" +len+"||||"+ new String(readBuffer, 0, len).trim());  
	             res += new String(readBuffer, 0, len).trim();  
	             break;  
	         }  
	     } catch (IOException e) {  
	         e.printStackTrace();  
	     }  
		 return res;
	}
	
	

}
