package com.game.team3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.team3.mapper.UserInfoMapper;
import com.game.team3.util.JWTToken;
import com.game.team3.vo.UserInfoVO;

import lombok.AllArgsConstructor;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private JWTToken jwtToken;
	

	public List<UserInfoVO> getUserInfos(UserInfoVO user){
		return userInfoMapper.selectUserInfos(user);
	}
	
	public UserInfoVO getUserInfo(int uiNum) {
		return userInfoMapper.selectUserInfo(uiNum);
	}
	
	public int insertUserInfo(UserInfoVO user) {
		return userInfoMapper.insertUserInfo(user);
	}
	public int updateUserInfo(UserInfoVO user) {
		return userInfoMapper.updateUserInfo(user);
	}
	public int deleteUserInfo(int uiNum) {
		return userInfoMapper.deleteUserInfo(uiNum);
	}
	public UserInfoVO login(UserInfoVO user) {
		user = userInfoMapper.selectUserInfoByIdAndPwd(user);
		if(user != null) {
			String token = jwtToken.getToken(user.getUiId());
			user.setToken(token);
			user.setUiPwd(null);
		}
		return user;
	}
}
