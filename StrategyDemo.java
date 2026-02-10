public class StrategyDemo {

    // ===== STRATEGY INTERFACES =====
    interface Talkable {
        void talk();
    }

    interface Walkable {
        void walk();
    }

    interface Flyable {
        void fly();
    }

    // ===== TALK STRATEGIES =====
    static class NormalTalk implements Talkable {
        public void talk() {
            System.out.println("Talking normally...");
        }
    }

    static class NoTalk implements Talkable {
        public void talk() {
            System.out.println("I cannot talk.");
        }
    }

    // ===== WALK STRATEGIES =====
    static class NormalWalk implements Walkable {
        public void walk() {
            System.out.println("Walking normally...");
        }
    }

    static class NoWalk implements Walkable {
        public void walk() {
            System.out.println("I cannot walk.");
        }
    }

    // ===== FLY STRATEGIES =====
    static class NormalFly implements Flyable {
        public void fly() {
            System.out.println("Flying in the sky...");
        }
    }

    static class NoFly implements Flyable {
        public void fly() {
            System.out.println("I cannot fly.");
        }
    }

    // ===== CONTEXT CLASS =====
    static class Robot {
        Talkable talkBehavior; // It only creates a reference variable of type Talkable.
        Walkable walkBehavior;
        Flyable flyBehavior;

        public Robot(Talkable t, Walkable w, Flyable f) {
            this.talkBehavior = t;
            this.walkBehavior = w;
            this.flyBehavior = f;
        }

        public void performTalk() {
            talkBehavior.talk();
        }

        public void performWalk() {
            walkBehavior.walk();
        }

        public void performFly() {
            flyBehavior.fly();
        }

        // Change behaviors at runtime
        public void setTalkBehavior(Talkable t) {
            this.talkBehavior = t;
        }

        public void setWalkBehavior(Walkable w) {
            this.walkBehavior = w;
        }

        public void setFlyBehavior(Flyable f) {
            this.flyBehavior = f;
        }
    }

    // ===== CONCRETE ROBOT =====
    static class CompanionRobot extends Robot {
        public CompanionRobot(Talkable t, Walkable w, Flyable f) {
            super(t, w, f);
        }
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        Robot robot = new CompanionRobot(
                new NormalTalk(),
                new NormalWalk(),
                new NoFly());

        robot.performTalk();
        robot.performWalk();
        robot.performFly();

        System.out.println("---- Changing Behavior ----");

        robot.setFlyBehavior(new NormalFly());
        robot.performFly();
    }
}
