package in.arunangshu.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import in.arunangshu.dao.IProductDao;
import in.arunangshu.dao.productDaoImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
maxFileSize = 10 * 1024 * 1024,  // 10MB
maxRequestSize = 20 * 1024 * 1024) // 20MB
public class uploadProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public uploadProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	            // Get the Part for the uploaded file
				String msg="";
	            Part filePart = request.getPart("imageFile");
	            
	            // Read the content of the file into a byte array
	            InputStream fileContent = filePart.getInputStream();
	            ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = fileContent.read(buffer)) != -1) {
	                byteBuffer.write(buffer, 0, bytesRead);
	            }
	            byte[] imageData = byteBuffer.toByteArray();
	            byteBuffer.close();
	            
	            String name=request.getParameter("name");
	            String price=request.getParameter("price");
	            String category=request.getParameter("category");
	            
	            IProductDao product=new productDaoImpl();
	            msg = product.uploadProduct(name, category, price, imageData);
	            if(msg=="Success") {
	            		response.sendRedirect("index.jsp");
	            }
	            else {
	            		response.sendRedirect("login.jsp");
	            }
	            
	        } catch (IOException | ServletException e) {
	            e.printStackTrace();
	            response.getWriter().println("Error: " + e.getMessage());
	        }
	}

}
