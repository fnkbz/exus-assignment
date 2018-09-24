package nikos.bouris.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@Controller
@RequestMapping(path="/assignment")
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(value="/saveuser")
	public ResponseEntity saveUser(@RequestBody Map<String,Object> body
							) {
		User usr = new User();
		usr.setFirstName(body.get("first_name").toString());
		usr.setLastName(body.get("last_name").toString());
		usr.setEmail(body.get("email").toString());
		usr.setGender(body.get("gender").toString());
		usr.setIpAddress(body.get("ip_address").toString());
		userRepository.save(usr);
		return ResponseEntity.ok(HttpStatus.OK);

	}

	@GetMapping(path="/getusers")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}


}
