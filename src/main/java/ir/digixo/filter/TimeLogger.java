package ir.digixo.filter;

import ir.digixo.annotation.TimeTracker;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Instant;

@WebFilter("/time")
public class TimeLogger extends HttpFilter {
    @Override
   // @TimeTracker //zeinal
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {


        //pre processing
        long start = Instant.now().toEpochMilli();

        chain.doFilter(req, res);
        long end = Instant.now().toEpochMilli();
        System.out.println("time elapsed log in filter: " + (end - start));
        //post processing


    }
}
