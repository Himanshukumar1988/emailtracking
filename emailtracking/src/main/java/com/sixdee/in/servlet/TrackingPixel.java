package com.sixdee.in.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrackingPixel
 */
public class TrackingPixel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackingPixel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        // set the content type to image/jpeg.
	        response.setContentType("image/jpeg");  
	          
	        ServletOutputStream out;
	          
	        // Writing this image 
	        // content as a response 
	        out = response.getOutputStream(); 
	          
	        // path of the image
	        Date d= new Date();
	        System.out.println("email read time " + d.getTime() +"\n Campaign name :" + request.getParameter("camp") +"\n receipient email :" + request.getParameter("email"));
	        FileInputStream fin = new FileInputStream("/opt/cmsuser/himanshu/p.jpg");  
	  
	        // getting image in BufferedInputStream  
	        BufferedInputStream bin = new BufferedInputStream(fin);
	        BufferedOutputStream bout = new BufferedOutputStream(out);  
	          
	        int ch =0;  
	        while((ch=bin.read())!=-1)  
	        {  
	            // display image
	            bout.write(ch);  
	        }  
	          
	        // close all classes
	        bin.close();  
	        fin.close();  
	        bout.close();  
	        out.close();  
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
