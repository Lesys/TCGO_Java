package view;

import javax.swing.JPanel;

public interface StrategieView {	
	public void executer(JPanel jpanel);
	
	public static StrategieView getInstance() {
		return null;
	}
}
