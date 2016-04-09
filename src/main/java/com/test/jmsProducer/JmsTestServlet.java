package com.test.jmsProducer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JmsTestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try { 
			/*InitialContext ctx=new InitialContext();  
			QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("jms/EventConnectionFactory");  
			QueueConnection con=f.createQueueConnection();  
			con.start();
			System.out.println("jms/EventConnectionFactory created successfully");
			//2) create queue session  
			QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
			//3) get the Queue object  
			Queue t=(Queue)ctx.lookup("jms/EventQueue");  
			//4)create QueueSender object         
			QueueSender sender=ses.createSender(t);
			System.out.println("jms/EventQueue created successfully");
			//5) create TextMessage object  
			TextMessage textMsg = ses.createTextMessage();  

			String msg = req.getParameter("message");
			
			textMsg.setText(msg);
			sender.send(textMsg);
			System.out.println("message sent successfully");
			con.close();
			ses.close();*/
			PrintWriter out = resp.getWriter();
			out.println("<p>msg</p>");
			out.println("<b>The above message has been put into the queue successfully</b>");
			out.println("<br><b>Major version</b>" + getServletContext().getMajorVersion());
			out.println("<br><b>Minor version</b>" + getServletContext().getMinorVersion());
			out.flush();
		}catch(Exception e) {
			System.out.println("Error - JmsTestServlet" + e.getMessage());
			e.printStackTrace();
		}
	}



}
