package controlServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreationBlogS
 */
@WebServlet("/CreationBlogS")
public class CreationBlogS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HOME_PAGE="/HomePageS";
	ImpBlog impBlog =new ImpBlog();
	Utilisateur user=new Utilisateur();
	Blog b =new Blog();
	Blog findblog =new Blog();
	
	CreationBlogForm blog=new CreationBlogForm(impBlog);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationBlogS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();

	
	    	user =(Utilisateur)request.getSession().getAttribute("Myuser");
	    	System.out.println("CBS is entred");
	    /*b.setDateBlog("1999-11-12");
	    b.setDescription("la description doit etre court mais pas mal");
	    b.setTitre("le titre est pret");
	   
	       
	       b.setUtilisateur(user);
	       b.setIntro("david@gmail.com");
		System.out.println(user.getNom());*/
	    	if (blog.CreerBlog(request)!=null) {
	       request.getRequestDispatcher("/HomePageS").forward(request, response);}
	    	else out.append(blog.getResultat());
	       
	       
	
	
	}
	   
        		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
