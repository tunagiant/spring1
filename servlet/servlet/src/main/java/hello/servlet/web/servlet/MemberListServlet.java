package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta charset=\"utf-8\">" +
                "<title>목록</title>" +
                "</head>" +
                "<body>" +
                "<a href=\"/index.html\">메인</a>" +
                "<table>" +
                "   <thead>" +
                "       <th>id</th>" +
                "       <th>username</th>" +
                "       <th>age</th>" +
                "   </thead>" +
                "   <tbody>");
        for (Member member : members) {

            writer.write("<tr>" +
                    "           <td>" + member.getId() + "</td>" +
                    "           <td>" + member.getUsername() + "</td>" +
                    "           <td>" + member.getAge() + "</td>" +
                    "       </tr>" +
                    "   </tbody>");
        }
        writer.write(
                "</table>" +
                        "</body>" +
                        "</html>");

    }
}
