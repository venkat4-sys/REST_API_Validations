package com.getinfy.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getinfy.dto.UserDto;
import com.getinfy.entity.User;
import com.getinfy.repo.UserRepo;
import com.getinfy.service.UserService;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserRepo userrepo;
	@Override
	public boolean saveUser(UserDto userdto) {
		
		User user=new User();
		
		BeanUtils.copyProperties(userdto, user);
		
		userrepo.save(user);
		
		
		return true;
	}

}
