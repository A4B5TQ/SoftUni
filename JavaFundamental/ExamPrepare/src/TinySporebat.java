import java.util.Scanner;

public class TinySporebat {
    public static void main(String[] args) { //100/100
        Scanner sc = new Scanner(System.in);
        boolean isPlayerDead = false;
        int myHealth = 5800;
        int glowCaps = 0;
        String input = sc.nextLine();
        while (!input.equals("Sporeggar")) {
            int currentDamage = 0;
            int glowcapsCount = Character.getNumericValue(input.charAt(input.length() - 1));
            char[] enemy = input.toCharArray();
            for (int i = 0; i < enemy.length - 1; i++) {
                if (!(enemy[i] == 'L')) {
                    currentDamage += enemy[i];
                } else {
                    myHealth += 200;
                }

            }
            myHealth -= currentDamage;
            if (myHealth <= 0) {
                System.out.printf("Died. Glowcaps: %d", glowCaps);
                isPlayerDead = true;
                break;
            }
            glowCaps += glowcapsCount;
            input = sc.nextLine();
        }

        if (!isPlayerDead) {
            System.out.printf("Health left: %d\n", myHealth);
            if (glowCaps >= 30) {
                System.out.printf("Bought the sporebat. Glowcaps left: %d", glowCaps - 30);
            } else {
                System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", Math.abs(glowCaps - 30));
            }
        }
    }
}
