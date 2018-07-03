package code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
public class Clock {
	/*
	 * 数字钟表
	 */
	JLabel clock = new JLabel("00:00:00");
	JPanel thispanel = new JPanel();
	String h,m,s;
	public Clock() {
		//nothing here
		gettime();
	}
	public Clock(JPanel thispanel) {
		this.thispanel = thispanel;
		createClock();
		gettime();
		Timer timer = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gettime();
				thispanel.updateUI();
			}
		});
		timer.start();
	}
	private void createClock() {
		clock.setFont(new Font("宋体",0,150));
		clock.setBounds(50, 150, 700, 400);
		thispanel.add(clock);
	}
	@SuppressWarnings("deprecation")
	private void gettime() {
		int h,m,s;
		Date date = new Date();
		h = date.getHours();
		m = date.getMinutes();
		s = date.getSeconds();
		if(h<10)
			this.h = "0" + h;
		else
			this.h = h + "";
		if(m<10)
			this.m = "0" + m;
		else
			this.m = m + "";
		if(s<10)
			this.s = "0" + s;
		else
			this.s = s + "";
		clock.setText(this.h+":"+this.m+":"+this.s);
	}
	public String obtaintime() {//调用当前时间
		return this.h+":"+this.m+":"+this.s;
	}
}
