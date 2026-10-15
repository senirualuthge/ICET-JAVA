package Polymorphism;

import java.util.*;

// Exercise 1 - before polymorphism: ControlRoom knows every concrete device type.
class PolyEx1 {

	static class Alarm {
		public void operateAlarm(int waterLevel) {
			System.out.println(waterLevel > 50 ? "Alarm ON" : "Alarm OFF");
		}
	}

	static class Display {
		public void display(int waterLevel) {
			System.out.println("Water Level : " + waterLevel);
		}
	}

	static class SMSSender {
		public void sendSMS(int waterLevel) {
			System.out.println("Sending SMS..." + waterLevel);
		}
	}

	static class Splitter {
		public void operateAlarm(int waterLevel) {
			System.out.println(waterLevel > 75 ? "Splitter ON" : "Splitter OFF");
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

		// Adding a device means editing ControlRoom too.
		private void notifyDevices() {
			alarm.operateAlarm(waterLevel);
			display.display(waterLevel);
			smsSender.sendSMS(waterLevel);
			splitter.operateAlarm(waterLevel);
		}
	}

	public static void main(String[] args) {
		ControlRoom controlRoom = new ControlRoom();
		controlRoom.addAlarm(new Alarm());
		controlRoom.addSMSSender(new SMSSender());
		controlRoom.addDisplay(new Display());
		controlRoom.addSplitter(new Splitter());

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
