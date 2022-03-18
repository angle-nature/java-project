package shiyan;

import java.applet.*;
import java.awt.*;

public class App extends Applet{
	String name;
	public void init() {
		name=getParameter("name");
	}
	public void paint(Graphics g) {
		g.drawString("Welcome"+name,120,50);
	}
}

