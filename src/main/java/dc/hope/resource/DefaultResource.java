package dc.hope.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class DefaultResource {

    @GetMapping("/")
    public void myController(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui/index.html");
    }
    
}