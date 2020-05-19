package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

    @Autowired
    private UserClient userClient;

    @Autowired
	private DiscoveryClient disco;

    @RequestMapping("/getall-hi")
	public List<String> getAllGreetings() {
		System.out.println(disco.getInstances("hello-service").get(0).getHost());
        System.out.println(disco.getInstances("hello-service").get(0).getMetadata());
        System.out.println(disco.getInstances("hello-service").get(0).getScheme());
        System.out.println(disco.getInstances("hello-service").get(0).isSecure());
		List<String> greetings = userClient.getGreetings();
		return greetings;
	}
}
