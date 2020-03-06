package com.github.mbarbeaux;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class HelloSWT {

    public static final void main(final String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setText("Hello World");
        shell.setSize(600, 400);
        final Label label = new Label(shell, SWT.NONE);
        label.setText("Hello World");
        label.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

}
