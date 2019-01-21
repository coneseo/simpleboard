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

@WebServlet(name = "ModifyServlet", urlPatterns="/modify")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        long id = 0L;
        try{
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        BoardService boardService = new BoardServiceImpl();
        BoardVO board = boardService.getBoard(id);
        if(board == null){
            return;
        }
        req.setAttribute("board", board);
        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/WEB-INF/views/modify.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("id");
        String title = req.getParameter("title");
        String nickname = req.getParameter("nickname");
        String content = req.getParameter("content");

        long id = 0L;
        try{
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        BoardService boardService = new BoardServiceImpl();
        BoardVO board = new BoardVO();
        board.setId(id);
        board.setTitle(title);
        board.setContent(content);
        board.setNickname(nickname);
        boardService.updateBoard(board);

        resp.sendRedirect("/board");
    }


}
