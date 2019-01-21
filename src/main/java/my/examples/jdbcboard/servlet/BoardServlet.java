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
import java.util.List;

@WebServlet(name = "BoardServlet", urlPatterns="/board")
public class BoardServlet extends HttpServlet {
    private static final int SIZE = 5;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        int page = 1;
        try{
            page = Integer.parseInt(pageStr);
        }catch(Exception ignore){}


        BoardService boardService = new BoardServiceImpl();
        List<BoardVO> boards = boardService.getBoards(page);
        req.setAttribute("boards", boards);

        RequestDispatcher requestDispatcher
                    = req.getRequestDispatcher("/WEB-INF/views/board.jsp");
            requestDispatcher.forward(req, resp);
        }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
