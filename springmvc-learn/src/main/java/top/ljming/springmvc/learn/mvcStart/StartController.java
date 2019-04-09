package top.ljming.springmvc.learn.mvcStart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController implements EnvironmentAware {
    private final Logger logger = LoggerFactory.getLogger(StartController.class);
    private Environment environment = null;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index.jsp";
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
