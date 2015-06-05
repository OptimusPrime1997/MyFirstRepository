package com.free.swtjface.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class MyLabel{

	private Label myLabel;
	private Shell shell;
	private Display display;

	public MyLabel() {
		super();
		display = new Display();

		shell = new Shell(display);

		shell.setSize(200, 200);
		myLabel = new Label(shell, SWT.NONE);
		myLabel.setBounds(38, 21, 100, 18);
		myLabel.setText("Hello, World!");
	}

	public void start() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static void main(String[] args) {
		MyLabel label = new MyLabel();
		label.start();

	}

}
