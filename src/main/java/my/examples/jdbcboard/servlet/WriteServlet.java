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

@WebServlet(name = "WriteServlet", urlPatterns="/write")
public class WriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("WEB-INF/views/write.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");



        User user = (User) req.getSession().getAttribute("user");

        BoardService boardService = new BoardServiceImpl();
        BoardVO board = new BoardVO();

        board.setTitle(title);
        board.setContent(content);
        board.setUserId(user.getId());
        board.setNickname(user.getNickname());

        boardService.addBoard(board);

        resp.sendRedirect("/board");
    }
}
