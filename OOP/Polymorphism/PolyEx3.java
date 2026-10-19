package Polymorphism;

import java.util.*;

// Exercise 3 - same as exercise 2, plus a device id in every message.
class PolyEx3 {

	static class Alarm {
		private String id;

		Alarm(String id) {
			this.id = id;
		}

		public void operateAlarm(int waterLevel) {
			System.out.println(waterLevel > 50 ? id + "-->Alarm ON" : id + "-->Alarm OFF");
		}
	}

	static class Splitter {
		private String id;

		Splitter(String id) {
			this.id = id;
		}

		public void split(int waterLevel) {
			System.out.println(waterLevel > 75 ? id + "-->Splitter ON" : id + "-->Splitter OFF");
		}
	}

	static class Display {
		private String id;

		Display(String id) {
			this.id = id;
		}

		public void display(int waterLevel) {
			System.out.println(id + "-->Water Level : " + waterLevel);
		}
	}

	static class SMSSender {
		private String id;

		SMSSender(String id) {
			this.id = id;
		}

		public void sendSMS(int waterLevel) {
			System.out.println(id + "-->Sending SMS..." + waterLevel);
		}
	}

	static class ControlRoom {
		private Alarm alarm;
		private Display display;
		private SMSSender smsSender;
		private Splitter splitter;

		private int waterLevel;

		public void addAlarm(Alarm alarm) {
			this.alarm = alarm;
		}

		public void addDisplay(Display display) {
			this.display = display;
		}

		public void addSMSSender(SMSSender smsSender) {
			this.smsSender = smsSender;
		}

		public void addSplitter(Splitter splitter) {
			this.splitter = splitter;
		}

		public void setWaterLevel(int waterLevel) {
			if (this.waterLevel != waterLevel) {
				this.waterLevel = waterLevel;
				notifyDevices();
			}
		}

		private void notifyDevices() {
			alarm.operateAlarm(waterLevel);
			display.display(waterLevel);
			smsSender.sendSMS(waterLevel);
			splitter.split(waterLevel);
		}
	}

	public static void main(String[] args) {
		ControlRoom controlRoom = new ControlRoom();
		controlRoom.addAlarm(new Alarm("A0001"));
		controlRoom.addSMSSender(new SMSSender("SM001"));
		controlRoom.addDisplay(new Display("D0001"));
		controlRoom.addSplitter(new Splitter("SP001"));

		Random r = new Random();
		while (true) {
			int waterLevel = r.nextInt(101); // 0 to 100
			controlRoom.setWaterLevel(waterLevel);
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
}
