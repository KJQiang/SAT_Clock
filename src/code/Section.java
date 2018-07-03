package code;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.*;

public class Section {
	/*
	 * 创建剩余时间以及进度条
	 */
	Integer[] tasktime = new Integer[]{65,35,25,55,50};
	int time,task;
	JLabel current = new JLabel("当前正在做:Section 0,剩余时间:65min00sec");
	JLabel stick = new JLabel();
	JPanel thispanel = new JPanel();
	ImageIcon stickicon = new ImageIcon(Section.class.getResource("/resource/process.png"));
	Timer timer = new Timer(1000,new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			time--;
			if(time>0) {
				currentsection();
			}else {
				timeisup();
			}
			if(time<-60) {
				remove();
			}
			createStick();
			thispanel.updateUI();
			
		}
	});
	public Section(JPanel thispanel,int task) {
		this.thispanel = thispanel;
		this.task = task;
		time = tasktime[task] * 60;
		timer.start();
		current.setBounds(20, 600, 600, 60);
		current.setFont(new Font("宋体",0,25));
		stick.setIcon(stickicon);
		stick.setBounds(50, 700, 700, 50);
		thispanel.add(stick);
		this.thispanel.add(current);
	}
	private void currentsection() {
		int temp = 0;
		String time;
		temp = this.time / 60 ;
		if(temp<10) {
			time = "0"+temp;
		}else {
			time = ""+temp;
		}
		temp = this.time % 60;
		if(temp<10) {
			time = time + "min" + "0"+temp+"sec";
		}else {
			time = time + "min" + ""+temp+"sec";
		}
		int tempsection = task +1;
		double temp1 = tasktime[task]*60;
		double left = this.time;
		double percentage = left/temp1;
		percentage = percentage*100;
		int percent = (int) percentage;
		current.setText("当前正在做:Section "+tempsection+",剩余时间:"+time+" "+percent+"%");
	}
	private void createStick() {
		double temp = tasktime[task]*60;
		double left = time;
		double percentage = left/temp;
		stick.setBounds(50, 700, (int) (700*percentage), 50);
	}
	private void timeisup() {
		int temp = task + 1;
		current.setText("Section "+temp+" 时间到！");
		thispanel.updateUI();
	}
	private void remove() {//删除当前计时器
		thispanel.remove(current);
		thispanel.remove(stick);
	}
}
