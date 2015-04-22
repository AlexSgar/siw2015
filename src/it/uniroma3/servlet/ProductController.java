package it.uniroma3.servlet;

import it.uniroma3.model.Product;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/productController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean ciSonoErrori=false;
		String prossimaPagina="prodotti.jsp";
		String nome = request.getParameter("name");
		String codice = request.getParameter("code");
		String descrizione = request.getParameter("description");
		String prezzoString = request.getParameter("price");
		Float prezzo = new Float(0);

		if(nome.isEmpty()){
			ciSonoErrori=true;
			request.setAttribute("nameError", "Campo Obbligatorio");
		}
		if(codice.isEmpty()){
			ciSonoErrori=true;
			request.setAttribute("codeError", "Campo Obbligatorio");
		}
		if(descrizione.isEmpty()){
			ciSonoErrori=true;
			request.setAttribute("descriptionError", "Campo obbligatorio");
		}
		try{
			prezzo = new Float(prezzoString);			
		}catch(Exception e){
			ciSonoErrori=true;
			request.setAttribute("priceError", "numero errato");
		}

		if (ciSonoErrori) prossimaPagina="newProduct.jsp";

		HttpSession s = request.getSession();
		Product p = new Product();
		p.setName(nome);
		p.setCode(codice);
		p.setDescription(descrizione);
		p.setPrice(prezzo);
		List<Product> l = new LinkedList<Product>();
		if(s.getAttribute("products")!=null){
			l = (LinkedList<Product>)s.getAttribute("products");
		}
		l.add(p);
		s.setAttribute("products", l);



		ServletContext application = this.getServletContext();
		String urlNextPage = response.encodeURL(prossimaPagina);
		RequestDispatcher rd = application.getRequestDispatcher("/"+urlNextPage);
		rd.forward(request, response);
	}
}
