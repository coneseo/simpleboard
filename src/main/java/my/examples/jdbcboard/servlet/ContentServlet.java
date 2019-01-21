package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dto.BoardVO;
import my.examples.jdbcboard.service.BoardService;
import my.examples.jdbcboard.service.BoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContentServlet", urlPatterns="/content")
public class ContentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String idStr = req.getParameter("id");
       Long id = 0L;
       try{
           id = Long.parseLong(idStr);
       }catch(Exception ex){ return;}

        BoardService boardService = new BoardServiceImpl();
        BoardVO board = boardService.getBoard(id);
        if(board == null){
            return;
        }
        req.setAttribute("board", board);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/content.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
