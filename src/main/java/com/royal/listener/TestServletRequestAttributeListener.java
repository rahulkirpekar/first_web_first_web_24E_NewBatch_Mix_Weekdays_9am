package com.royal.listener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;

public class TestServletRequestAttributeListener implements ServletRequestAttributeListener 
{
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) 
	{
		System.out.println("TestServletRequestAttributeListener : attributeAdded()");
	}
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) 
	{
		System.out.println("TestServletRequestAttributeListener : attributeReplaced()");
	}
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) 
	{
		System.out.println("TestServletRequestAttributeListener : attributeRemoved()");
	}
}
