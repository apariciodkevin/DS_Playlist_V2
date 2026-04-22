public class Test {
        public static void main(String[] args) throws InterruptedException {
            Player p = new Player();
            p.play("audio/20 Cigarettes--Morgan Wallen.wav");
            System.out.println("Playing for 10 seconds...");
            Thread.sleep(10000);
            p.stop();
            System.out.println("Stopped.");
        }

}
