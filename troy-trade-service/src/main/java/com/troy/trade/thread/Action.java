package com.troy.trade.thread;

import cn.hutool.http.HttpUtil;

/**
 * 
 * @author yanping
 */
public abstract class Action implements Runnable {
	
	@Override
	public void run() {
		execute();
	}
	
	
	public abstract void execute();

	public static void main(String[] args) {
		String s = HttpUtil.get("https://www.baidu.com");
		System.out.println(s);
	}

}
