package com.idc.file.exec;

public class App {
	public static void main(String[] arg) throws Exception {
		ExecuteCommand app = new ExecuteCommand();
		app.executeCommand("ifconfig");
		app.executeCommand("ls");
	}
}
