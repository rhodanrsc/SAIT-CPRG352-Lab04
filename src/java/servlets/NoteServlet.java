package servlets;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

public class NoteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File(path)));
        
        Note note = new Note();
        note.setTitle(br.readLine());
        note.setContent(br.readLine());
        
        String title = note.getTitle(); 
        String content = note.getContent();
        

        request.setAttribute("title", title);
        request.setAttribute("content", content);
        
        br.close();
        
        String editParam = request.getParameter("edit");

        if (editParam == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return;
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 

        String title = request.getParameter("editTitle");
        String edit = request.getParameter("editContent");
        
        pw.println(title);
        pw.println(edit);
        
        pw.close();
        
        Note note = new Note();
        note.setTitle(title);
        note.setContent(edit); 
        
        request.setAttribute("note", note);
        
        request.setAttribute("title", note.getTitle());
        request.setAttribute("content", note.getContent());
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;  
    }
}
