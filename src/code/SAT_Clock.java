package code;
import javax.swing.*;

public class SAT_Clock {
	/*
	 * 主程序，创建全局时钟、菜单选项和进度条
	 */
	static JFrame frame = new JFrame("SAT专用计时器");
	static JPanel panel = new JPanel();
	
	public static void main(String args[]) {
		frame.setSize(800, 800);
		frame.setTitle("SAT考试专用计时器");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);
		new Menu(panel);
		new Clock(panel);
		frame.setVisible(true);
	}
}
