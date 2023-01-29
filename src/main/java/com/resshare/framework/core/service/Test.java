package com.resshare.framework.core.service;

import org.openjdk.jol.vm.VM;

import android.support.v7.widget.Toolbar;

public class Test {

	public static void main(String[] args) {
		System.out.println("Hello World");
		Integer i = new Integer("0");
		Integer k = new Integer("0");
		Integer j = new Integer(2);
		String answer = "42";
 
		Toolbar tb = new Toolbar();
		Integer lm= tb.getContentInsetLeft();
		Integer lm1= tb.getContentInsetLeft();
		
		System.out.println("The memory address is " + VM.current().addressOf(lm));
		System.out.println("The memory address is " + VM.current().addressOf(lm1));
		System.out.println("The memory address is " + VM.current().addressOf(i));
		System.out.println("The memory address is " + VM.current().addressOf(k));

	}

}
