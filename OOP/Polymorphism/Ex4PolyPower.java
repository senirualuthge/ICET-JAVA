package Polymorphism;

import java.util.*;

/*
 * Exercise 4 - the Observer version.
 *
 * ControlRoom keeps a WaterLevelObserver[] and notifies every element, so adding
 * a new device needs no change here at all.
 *
 * The observer classes are nested inside Ex4PolyPower because top-level classes
 * with the same name (Alarm, Display, SMSSender, Splitter, ControlRoom) also
 * exist in the other exercise files of this package, and a package may only
 * contain one top-level class per name.
 */
public class Ex4PolyPower {

	static class WaterLevelObserver {
		public void update(int waterLevel) {
			//
		}
	}

	static class Alarm extends WaterLevelObserver {
		private String id;

		Alarm(String id) {
			this.id = id;
		}

		@Override
		public void update(int waterLevel) {
			System.out.println(waterLevel > 50 ? id + "-->Alarm ON" : id + "-->Alarm OFF");
		}
	}

	static class Display extends WaterLevelObserver {
		private String id;

		Display(String id) {
			this.id = id;
		}

		@Override
		public void update(int waterLevel) {
			System.out.println(id + "-->Water Level : " + waterLevel);
		}
	}

	static class SMSSender extends WaterLevelObserver {
		private String id;

		SMSSender(String id) {
			this.id = id;
		}

		@Override
		public void update(int waterLevel) {
			System.out.println(id + "-->Sending SMS..." + waterLevel);
		}
	}

	static class Splitter extends WaterLevelObserver {
		private static final int LOW_LIMIT = 30;
		private static final int MEDIUM_LIMIT = 70;

		private String id;

		Splitter(String id) {
			this.id = id;
		}

		@Override
		public void update(int waterLevel) {
			String level;
			if (waterLevel <= LOW_LIMIT) {
				level = "LOW";
			} else if (waterLevel <= MEDIUM_LIMIT) {
				level = "MEDIUM";
			} else {
				level = "HIGH";
			}
			System.out.println(id + "-->" + level + " (" + waterLevel + ")");
		}
	}

	static class ControlRoom {
		private WaterLevelObserver[] waterLevelObserverArray = new WaterLevelObserver[0];
		private int waterLevel;

		public void addWaterLevelObserver(WaterLevelObserver waterLevelObserver) {
			extendArray();
			waterLevelObserverArray[waterLevelObserverArray.length - 1] = waterLevelObserver;
		}

		public void setWaterLevel(int waterLevel) {
			if (this.waterLevel != waterLevel) {
				this.waterLevel = waterLevel;
				notifyDevices();
			}
		}

		private void notifyDevices() {
			for (WaterLevelObserver ob : waterLevelObserverArray) {
				ob.update(waterLevel);
			}
		}

		// Grows the array by one and copies the existing observers over.
		private void extendArray() {
			WaterLevelObserver[] tempWaterLevelObserverArray =
					new WaterLevelObserver[waterLevelObserverArray.length + 1];
			for (int i = 0; i < waterLevelObserverArray.length; i++) {
				tempWaterLevelObserverArray[i] = waterLevelObserverArray[i];
			}
			waterLevelObserverArray = tempWaterLevelObserverArray;
		}
	}

	public static void main(String[] args) {
		ControlRoom controlRoom = new ControlRoom();
		controlRoom.addWaterLevelObserver(new Alarm("A0001"));
		controlRoom.addWaterLevelObserver(new Display("D0001"));
		controlRoom.addWaterLevelObserver(new SMSSender("SM0001"));

		controlRoom.addWaterLevelObserver(new Alarm("A0002"));
		controlRoom.addWaterLevelObserver(new Display("D0002"));
		controlRoom.addWaterLevelObserver(new SMSSender("SM0002"));

		controlRoom.addWaterLevelObserver(new Splitter("SP0001"));

		Random r = new Random();
		int previous = -1; // ControlRoom only notifies when the level changes
		for (int i = 0; i < 10; i++) {
			int waterLevel;
			do {
				waterLevel = r.nextInt(101); // 0 to 100
			} while (waterLevel == previous);

			controlRoom.setWaterLevel(waterLevel);
			previous = waterLevel;
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
