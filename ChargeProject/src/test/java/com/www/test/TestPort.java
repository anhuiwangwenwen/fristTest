package com.www.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import com.www.serialport.util.SerialPortUtil;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class TestPort {
	public static final byte[] init = new byte[] { 0x1B, 0x40 };  
    public static final byte[] clean = new byte[] { 0x0C };  
    public static final byte[] pre_display = new byte[] { 0x1B, 0x51, 0x41 };  
    public static final byte[] post_display = new byte[] { 0x0D };  
  
    public static void displayCustomerScreen(String data, byte[] mode) {  
        try {  
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("COM3"); //串口号  
            SerialPort serialPort = (SerialPort) portIdentifier.open("test",5000); //使用者  和 最大响应时长(ms)  
            serialPort.setSerialPortParams(9600,  //波特率  
                    SerialPort.DATABITS_8,          //校验位  
                    SerialPort.STOPBITS_1,          //数据位  
                    SerialPort.PARITY_NONE);        //停止位  
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);           
            try {  
                OutputStream outputStream = serialPort.getOutputStream();  
                if (mode != null) {  
                    outputStream.write(mode);  
                }  
                if (data != null) {  
                    outputStream.write(pre_display);  
                    outputStream.write(data.getBytes());  
                    outputStream.write(post_display);  
                }  
                outputStream.flush();  
                outputStream.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            } finally {  
                serialPort.close();  
            }  
        } catch (NoSuchPortException e) {  
            e.printStackTrace();  
        } catch (PortInUseException e) {  
            e.printStackTrace();  
        } catch (UnsupportedCommOperationException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String[] args) { 
    	DSerialPort dp = new DSerialPort();
    	dp.selectPort("COM3");
    	dp.write("11111");
    	dp.startRead(500);
    	
    	
//        displayCustomerScreen(null,"1231ffff0000010d0a".getBytes());
//        SerialPort serialPort = SerialPortUtil.createPort("COM3", 5000, 9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//        InputStream inputStream = null;
//        String test = "";
//        while(true){
//        	 try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//        	 byte[] readBuffer = new byte[1024];  
//             try {  
//                 inputStream = serialPort.getInputStream();  
//                 // 从线路上读取数据流  
//                 int len = 0;  
//                 while ((len = inputStream.read(readBuffer)) != -1) {  
//                	
//                     System.out.println("实时反馈：" +len+"||||"+ new String(readBuffer, 0, len).trim());  
//                     test += new String(readBuffer, 0, len).trim();  
//                     break;  
//                 }  
//             } catch (IOException e) {  
//                 e.printStackTrace();  
//             }  
//        }
    }  
}
