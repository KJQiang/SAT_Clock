package code;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Menu {
	/*
	 * 靠上面的菜单
	 */
	JPanel thispanel = new JPanel();
	JComboBox<String> selection = new JComboBox<String>();
	public Menu(JPanel thispanel) {
		this.thispanel = thispanel;
		createMenu();
	}
	private void createMenu() { //创建菜单
		JLabel currentsection = new JLabel("当前Section");
		currentsection.setBounds(200, 20, 200, 100);
		currentsection.setFont(new Font("宋体",0,20));
		thispanel.add(currentsection);
		selection.addItem("Section 1 Reading");
		selection.addItem("Section 2 Language and Writing");
		selection.addItem("Section 3 Math I");
		selection.addItem("Section 4 Math II");
		selection.addItem("Essay");
		selection.setBounds(350, 20, 200, 100);
		thispanel.add(selection);
		JButton start = new JButton("开始计时");
		start.setBounds(600, 50, 80, 40);
		thispanel.add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
	}
	private void start() {
		Section s1 = new Section(thispanel,selection.getSelectedIndex());
	}
}
