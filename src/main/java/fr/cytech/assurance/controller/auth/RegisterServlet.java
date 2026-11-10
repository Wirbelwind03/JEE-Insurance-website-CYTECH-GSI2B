package fr.cytech.assurance.controller.auth;

import fr.cytech.assurance.dto.request.RegisterRequest;
import fr.cytech.assurance.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final String VIEW = "/WEB-INF/views/auth/register.jsp";
    private final AuthService authService = new AuthService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(VIEW).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        RegisterRequest dto = new RegisterRequest(
                req.getParameter("firstName").trim(),
                req.getParameter("name").trim(),
                req.getParameter("email").trim(),
                req.getParameter("phoneNumber").trim(),
                LocalDate.parse(req.getParameter("birthDate")),
                req.getParameter("address").trim(),
                req.getParameter("password").trim()
        );
    }
}
