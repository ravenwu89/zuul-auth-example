package shuaicj.example.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A simple controller.
 *
 * @author shuaicj 2017/10/18
 */
@RestController
public class BackendController {
	
	@Autowired
	PasswordEncoder encoder;

    @GetMapping("/admin")
    public String admin() {
        return encoder.encode("admin");
    }

    @GetMapping("/user")
    public String user() {
        return encoder.encode("user");
    }

    @GetMapping("/guest")
    public String guest() {
        return encoder.encode("guest");
    }
}

