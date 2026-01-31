package com.royal.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class TestRequestListener implements ServletRequestListener 
{
	@Override
	public void requestInitialized(ServletRequestEvent sre) 
	{
		// code/logic
		System.out.println("TestRequestListener : requestInitialized(ServletRequestEvent sre)");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) 
	{
		// code/logic
		System.out.println("TestRequestListener : requestDestroyed(ServletRequestEvent sre)");
	}
}
