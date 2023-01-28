package com.cdac.demo.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cdac.demo.model.Student;
import com.cdac.demo.repo.StudentRepo;

@Component
public class StudentAuthnticationProvider implements AuthenticationProvider {

	StudentRepo srRepo;
	PasswordEncoder encoder;
	public StudentAuthnticationProvider(StudentRepo srRepo, PasswordEncoder encoder) {
		super();
		this.srRepo = srRepo;
		this.encoder = encoder;
	}
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username=authentication.getName();
		String password=authentication.getCredentials().toString();
		Student stu=srRepo.findBySname(username);
		
		if(stu==null)
		{
			throw new BadCredentialsException("User Not Exists");	
		}
		if(encoder.matches(password, stu.getPassword()))
		{
			return new UsernamePasswordAuthenticationToken(username,password,getStudentRoles(stu.getSrole()));
		}
		else
		{
			throw new BadCredentialsException("Password is incorrect");
		}
		
	}
	@Override
	public boolean supports(Class<?> authentication) {
		
		 return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	private List<GrantedAuthority> getStudentRoles(String roles)              
	{
		List<GrantedAuthority> list=new ArrayList<>();
		String []role=roles.split(",");
		for(String s:role)
		{
			list.add(new SimpleGrantedAuthority(s.replaceAll("\\s+", "")));             
		}
		return list;
	}
	
	
}
