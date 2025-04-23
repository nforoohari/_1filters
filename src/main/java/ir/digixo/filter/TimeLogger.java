package ir.digixo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Instant;

@WebFilter("/time")
public class TimeLogger extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        //pre processing
        System.out.println("A filter was started.");
        long start = Instant.now().toEpochMilli();

        chain.doFilter(req, res);

        //post processing
        long end = Instant.now().toEpochMilli();
        System.out.println("Elapsed time logging in filter: " + (end - start));
    }
}
