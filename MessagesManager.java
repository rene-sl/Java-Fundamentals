import java.util.HashMap;
import java.util.Scanner;

public class MessagesManager {
    public static class Messeges{
        private String name;
        private int sent;
        private int received;
        private int sum;

        public void setSum(int sum) {
            this.sum = sum;
        }

        public int getSum() {
            return sum;
        }

        public Messeges(String name, int sent, int received, int sum) {
            this.name = name;
            this.sent = sent;
            this.received = received;
            this.sum = sum;
        }

        public void setSent(int sent) {
            this.sent = sent;
        }

        public void setReceived(int received) {
            this.received = received;
        }

        public int getSent() {
            return sent;
        }

        public int getReceived() {
            return received;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        HashMap<String, Messeges> manager = new HashMap<String, Messeges>();

        while (!input.equalsIgnoreCase("Statistics")) {
            String[] commands = input.split("=");
            String command = commands[0];

            switch (command) {
                case "Add":
                    String name = commands[1];
                    int sent = Integer.parseInt(commands[2]);
                    int received = Integer.parseInt(commands[3]);
                    int sum = sent + received;

                    Messeges message = new Messeges(name, sent, received, sum);
                    if (!manager.containsKey(name)) {
                        if (sum < capacity) {
                            manager.put(name, message);
                        }
                    }
                    break;

                case "Message":
                    String sentName = commands[1];
                    String receivedName = commands[2];
                    if (manager.containsKey(sentName) && manager.containsKey(receivedName)) {
                        int newSentMessages = manager.get(sentName).getSent() + 1;
                        if (newSentMessages < capacity) {
                            manager.get(sentName).setSent(newSentMessages);
                            int newSum = manager.get(sentName).getSum()+1;
                            manager.get(sentName).setSum(newSum);
                        } else {
                            System.out.println(sentName + " reached the capacity!\n");
                            manager.remove(sentName);
                        }

                        int newReceivedMessages = manager.get(receivedName).getReceived() + 1;
                        if (newReceivedMessages < capacity) {
                            manager.get(receivedName).setReceived(newReceivedMessages);
                            int newSum = manager.get(receivedName).getSum()+1;
                            manager.get(receivedName).setSum(newSum);
                        } else {
                            System.out.println(receivedName + "reached the capacity!\n");
                            manager.remove(receivedName);
                        }
                    }
                    break;
                case "Empty":
                    String username = commands[1];
                    if (manager.containsKey(username)) {
                        manager.remove(username);
                    }
                    if (username.equals("All")) {
                        manager.clear();
                    }
                    break;
                default:
                    break;
            }

            input = scanner.nextLine();

        }
        System.out.printf("Users count: %d%n", manager.size());
        manager.entrySet().stream().sorted(((firtst, second) -> {
            int res = Integer.toString(second.getValue().getReceived())
                    .compareTo(Integer.toString(firtst.getValue().getReceived()));
            if (res == 0) {
                firtst.getKey().compareTo(second.getKey());
            }
            return res;
        })).forEach(entry -> {
            System.out.print(String.format("%s - %d%n", entry.getKey(), entry.getValue().sum));
        });

    }
}
