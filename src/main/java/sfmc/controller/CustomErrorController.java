package sfmc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sfmc.model.ErrorJson;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Mapping /error to a custom controller by implementing ErrorController
 */
@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Value("${debug}")
    private boolean debug;

    @RequestMapping(value = PATH)
        //@ResponseBody
    ErrorJson error(HttpServletRequest request, HttpServletResponse response) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring.
        // Here we just define response body.
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        //String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
        Exception exception = null;
        String message = "";
        Object exceptionAttr = request.getAttribute("javax.servlet.error.exception");
        if (exceptionAttr != null) {
            if (debug)
                exception = (Exception) exceptionAttr;
            message = exception.getMessage();
        }
        else if(code == 404){
            message = "Not found";
        }

        return new ErrorJson(code, message, exception);
    }

    @RequestMapping("/testError")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}