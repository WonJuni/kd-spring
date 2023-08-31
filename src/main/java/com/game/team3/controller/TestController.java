package com.game.team3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@CrossOrigin("*")
public class TestController {
	
	@RequestMapping(value = "/test/**", method = RequestMethod.GET) // GetMapping 과 같은 동작
	public String test() {
		return "str";
	}
	
	@RequestMapping(value = "/api/list", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getList(){
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		return list;
	}
	
	@GetMapping("/api/users")
	@ResponseBody
	public List<Map<String, String>>getUsers(){
		List<Map<String, String>>users = new ArrayList<>();
		for(int i=1; i<11; i++) {
			Map<String, String> userMap = new HashMap<String, String>();
			userMap.put("name", "name"+i);
			userMap.put("num", i+"");
			userMap.put("age", i+"");
			users.add(userMap);
		}
		return users;
	}
}
