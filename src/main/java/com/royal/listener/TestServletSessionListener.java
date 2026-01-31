package com.royal.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class TestServletSessionListener implements HttpSessionListener 
{
	@Override
	public void sessionCreated(HttpSessionEvent se) 
	{
		System.out.println("TestServletSessionListener - sessionCreated()");
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) 
	{
		System.out.println("TestServletSessionListener - sessionDestroyed()");
	}
}
