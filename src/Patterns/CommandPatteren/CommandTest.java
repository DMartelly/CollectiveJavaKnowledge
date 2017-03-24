package Patterns.CommandPatteren;

public class CommandTest {
    public interface Command {
        void execute();
    }

    public static class Fan {
        private boolean spinning;

        public Fan() {
            spinning = false;
        }

        public void TurnOn() {
            spinning = true;
        }

        public void TurnOff() {
            spinning = false;
        }

        @Override
        public String toString() {
            if (spinning)
                return "Spinning";
            else
                return "Not Spinning";
        }
    }

    public static class TurnFanOn implements Command {

        private Fan fan;

        public TurnFanOn(Fan f) {
            fan = f;
        }

        @Override
        public void execute() {
            System.out.println("TurnOn Button Pushed");
            fan.TurnOn();
        }
    }

    public static class TurnFanOff implements Command {

        private Fan fan;

        public TurnFanOff(Fan f) {
            fan = f;
        }

        @Override
        public void execute() {
            System.out.println("TurnOff Button Pushed");
            fan.TurnOff();
        }
    }

    public static void main(String[] args) {
        Fan myFan = new Fan();
        TurnFanOn OnButton = new TurnFanOn(myFan);
        TurnFanOff OffButton = new TurnFanOff(myFan);

        Command on = OnButton;
        Command off = OffButton;

        System.out.println(myFan);
        on.execute();
        System.out.println(myFan);
        off.execute();
        System.out.println(myFan);
    }
}
