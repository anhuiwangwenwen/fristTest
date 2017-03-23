package com.www.dwr.serviceImpl;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;

@RemoteProxy
public class TestService {

	@RemoteMethod
	public String getStr(String abc) {
		
		return abc;
	}

	@RemoteMethod
	public String sayHello(String abc) {
		// TODO Auto-generated method stub
		return abc;
	}

}
