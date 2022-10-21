/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author colem
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String seshName = (String) request.getSession().getAttribute("username");
        
        if (seshName != null) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Action = request.getParameter("action");
        
        if (Action.equals("register")) {
            String username = request.getParameter("username");
            if (username != null) {
                request.getSession().setAttribute("username", username);
                
                ArrayList<String> items = new ArrayList<>();
                request.getSession().setAttribute("items", items);
            }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else if (Action.equals("add")) {
            String item = request.getParameter("item");
            
            ArrayList<String> items = (ArrayList<String>)request.getSession().getAttribute("items");
            
            items.add(item);
            
            request.getSession().setAttribute("items", items);
        } else if (Action.equals("delete")){
            String itemValue = request.getParameter("item");
            
            ArrayList<String> items = (ArrayList<String>) request.getSession().getAttribute("items");
            
            int indexToDelete = -1;
            
            for(int i = 0; i < items.size(); i++){
                if(items.get(i).equals(itemValue)){
                    indexToDelete = i;
                    break;
                }
            }
            
            if (indexToDelete != -1){
                items.remove(indexToDelete);
            }
            
            request.getSession().setAttribute("items", items);
        }else if (Action.equals("logout")){
            this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
