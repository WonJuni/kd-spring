package com.game.team3.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.team3.mapper.UserInfoMapper;
import com.game.team3.service.UserInfoService;
import com.game.team3.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin("*")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("/user-infos")
	public List<UserInfoVO> getUserInfos(UserInfoVO user){
		return userInfoService.getUserInfos(user);
	}
	
	@GetMapping("/user-infos/{uiNum}")
	public UserInfoVO getUserInfos(@PathVariable int uiNum){
		return userInfoService.getUserInfo(uiNum);
	}
	
	@PostMapping("/user-infos")
	public int insertUserInfo(@RequestBody UserInfoVO user) {
		
		return userInfoService.insertUserInfo(user);
	}
	
	@PutMapping("/user-infos")
	public int updateUserInfo(UserInfoVO user) {
		return userInfoService.updateUserInfo(user);
	}
	
	@DeleteMapping("/user-infos/{uiNum}")
	public int deleteUserInfo(@PathVariable int uiNum) {
		return userInfoService.deleteUserInfo(uiNum);
	}
}
