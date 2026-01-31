package com.royal.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class TestFilter1 implements Filter 
{
	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		// Pre-Filtering Code---place your code here
		
		System.out.println("==============TestFilter1----Pre-Filtering==============");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		
		// Post-Filtering Code--place your code here
		System.out.println("==============TestFilter1----Post-Filtering==============");
	}

	public void destroy() 
	{
	}
}
