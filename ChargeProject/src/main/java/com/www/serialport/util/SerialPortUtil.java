package com.www.serialport.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

/***
 * ����ͨѶ������
 * @author usb9usb
 *
 */
public class SerialPortUtil {
	/***
	 * �����˿�
	 * @param CommPortName �˿��� ��COM3
	 * @param timeout ��ʱʱ��
	 *  SerialPort.DATABITS_8,           //����λ  
	 *  SerialPort.STOPBITS_1,         //ֹͣλ
	 *  SerialPort.PARITY_NONE //У��λ
	 */
	public static SerialPort createPort(String CommPortName, int timeOutms, int baudRate,
			int databits, int stopbits, int parity){
		SerialPort  serialPort = null;
		try {
			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(CommPortName); //���ں�  
	        serialPort = (SerialPort) portIdentifier.open("charge",5000); //��������  �� �����Ӧʱ��(ms)  
	        serialPort.setSerialPortParams(baudRate, databits, stopbits, parity);            
	        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
        return serialPort;
        
	}
	
	//������Ϣ
	public static void sendMsg(SerialPort serialPort,String data){
		try {
			 OutputStream outputStream = serialPort.getOutputStream();
			 outputStream.write(data.getBytes()); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
	}
	
	//������Ϣ
	public static String getMsg(SerialPort serialPort){
		 InputStream inputStream = null;
		 byte[] readBuffer = new byte[1024];
		 String res = "";
		 try {  
	         inputStream = serialPort.getInputStream();  
	         // ����·�϶�ȡ������  
	         int len = 0;  
	         while ((len = inputStream.read(readBuffer)) != -1) {  
	             //System.out.println("ʵʱ������" +len+"||||"+ new String(readBuffer, 0, len).trim());  
	             res += new String(readBuffer, 0, len).trim();  
	             break;  
	         }  
	     } catch (IOException e) {  
	         e.printStackTrace();  
	     }  
		 return res;
	}
	
	

}
