package com.game.team3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.team3.mapper.UserInfoMapper;
import com.game.team3.vo.UserInfoVO;

import lombok.AllArgsConstructor;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;

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
}
