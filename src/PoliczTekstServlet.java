import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@WebServlet("/policz")
public class PoliczTekstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        String tekst = request.getParameter("tekst");
        writer.println(tekst);

        String[] split = tekst.split(" ");
        writer.println("ilosc slów: " + split.length);
        writer.println("ilosc znaków: " + tekst.length());
        int ilosZnakowBezSpacji = 0;
        for (int i = 0; i < split.length; i++) {
            ilosZnakowBezSpacji += split[i].length();
        }
        writer.println("ilosc znaków bez spacji: " + ilosZnakowBezSpacji);
        int i = 0;
        int dlugoscTekstu = tekst.length();
        writer.println("Palindrom: " + czyPalindrom(tekst, i, dlugoscTekstu));

    }

    private boolean czyPalindrom(String tekst, int i, int dlugoscTekstu) {
        while (i < tekst.length()) {
            if (tekst.charAt(dlugoscTekstu - 1) != tekst.charAt(i)) {
                return false;
            }
            dlugoscTekstu--;
            i++;
        }
        return true;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}