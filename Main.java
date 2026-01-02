import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Service serv = new Service();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("1. Add Pet\n" +"2. Update Pet\n" +"3. Fetch All Pets\n" +"4. Delete Pet by ID\n" +"Any to Exit");

            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        Pet p = new Pet();
                        p.setPetId(sc.nextInt());
                        p.setName(sc.next());
                        p.setSpecies(sc.next());
                        p.setAge(sc.nextInt());
                        serv.add(p);
                        break;

                    case 2:
                        Pet u = new Pet();
                        u.setPetId(sc.nextInt());
                        u.setName(sc.next());
                        u.setSpecies(sc.next());
                        u.setAge(sc.nextInt());
                        serv.update(u);
                        break;

                    case 3:
                        System.out.println(serv.fetchAll());
                        break;

                    case 4:
                        serv.deleteById(sc.nextInt());
                        break;

                    default:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true);
    }
}
