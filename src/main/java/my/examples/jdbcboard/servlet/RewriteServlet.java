package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dto.BoardVO;
import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.service.BoardService;
import my.examples.jdbcboard.service.BoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RewriteServlet", urlPatterns="/rewrite")
public class RewriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = 0;
        String idStr = req.getParameter("id");

        try{
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            ex.printStackTrace();
            return;
        }

        BoardService boardService = new BoardServiceImpl();
        BoardVO board = boardService.getBoard(id);

        String content = board.getContent();
        content = content.replaceAll("\n", "\n> ");
        System.out.println(content);
        board.setContent(content);

        req.setAttribute("board", board);

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/rewriteform.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = 0L;
        String idStr = req.getParameter("id");

        try{
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            ex.printStackTrace();
            return;
        }
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        User user = (User) req.getSession().getAttribute("user");

        BoardService boardService = new BoardServiceImpl();
        BoardVO board = new BoardVO();
        board.setId(id);
        board.setTitle(title);
        board.setContent(content);
        board.setUserId(user.getId());
        board.setNickname(user.getNickname());
        boardService.addReBoard(board);
        resp.sendRedirect("/board");
    }
}
