package com.axis.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.axis.modal.SecureUser;
import com.axis.repo.SecurituUserRepo;
import com.axis.security.MyUserDetails;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	Logger log = LoggerFactory.getLogger(UserDetailsService.class);
			
	@Autowired
	SecurituUserRepo securituUserRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("Inside loadUserByUsername of UserDetailsServiceImpl");
		SecureUser secureUser = securituUserRepo.findByEmail(userName);
		return new  MyUserDetails(secureUser);
	}
}
