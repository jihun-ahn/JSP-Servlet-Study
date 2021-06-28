package com.vote.controller;

import java.util.Calendar;

public class test {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		
		String vDate = "19960512";
		
		int age = today.get(Calendar.YEAR);
		System.out.println(age);
	}
}
