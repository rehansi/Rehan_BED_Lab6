package com.greatlearning.college.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Bycrypt {

	public static void main(String[] args) {
		

	BCryptPasswordEncoder passwordEnconoder = new BCryptPasswordEncoder();

	String password = "welcome";

	String cyphertext = passwordEnconoder.encode(password);
	String cyphertext1 = passwordEnconoder.encode(password);
	String cyphertext2 = passwordEnconoder.encode(password);
	String cyphertext3= passwordEnconoder.encode(password);
	String cyphertext4= passwordEnconoder.encode(password);

	System.out.println("Hashed Password: " + cyphertext);
	System.out.println(cyphertext1);
	System.out.println(cyphertext2);
	System.out.println(cyphertext3);
	System.out.println(cyphertext4);
	
	
	boolean matches =  passwordEnconoder.matches(password, cyphertext);
	boolean matches1 =  passwordEnconoder.matches(password, cyphertext1);
	boolean matches2 =  passwordEnconoder.matches(password, cyphertext2);
	boolean matches3 =  passwordEnconoder.matches(password, cyphertext3);
	boolean matches4 =  passwordEnconoder.matches(password, cyphertext4);
	
	System.out.println(matches);
	System.out.println(matches1);
	System.out.println(matches2);
	System.out.println(matches3);
	System.out.println(matches4);
}
}


