package amllado.test.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amllado.test.cdi.services.CDITestInterface;
import amllado.test.ejb.services.EJBTestService;

/**
 * Servlet implementation class TestController
 */
@WebServlet("/testController")
public class TestController extends HttpServlet {
	
	@Inject
	CDITestInterface cdiTestInterface;
	
	@EJB
	EJBTestService ejbTestService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(cdiTestInterface.test("Arturo"));
		response.getWriter().append("\n");
		response.getWriter().append(ejbTestService.test("Arturo"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
