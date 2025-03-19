package main;

import example.Example;

public class Launcher {
	public static void main(String... args){
		Example ex = Example.newInstance();
		System.out.println(ex.msg("Modular Hello World"));
	}
}