import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheHeiganDance { //100/100
    private static boolean isCloudOn;
    private static boolean isEruptionOn;
    private static int playerRow = 7;
    private static int playerColumn = 7;
    private static boolean isHeiganDead = false;
    private static boolean isPlayerDead = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double playerDamage = Double.parseDouble(sc.nextLine());

        int plegueCloudDamage = 3500;
        int eruptionDamage = 6000;

        int playerHealth = 18500;
        double heiganHealth = 3000000.00;

        String input = sc.nextLine();
        String lastSpell = "";

        while (true) {
            heiganHealth -= playerDamage;
            if (checkForDead(playerHealth, heiganHealth)) break;
            if (isCloudOn) {
                playerHealth -= plegueCloudDamage;
                isCloudOn = false;
            }
            if (!isCloudOn && isEruptionOn) {
                playerHealth -= eruptionDamage;
            }
            String[] spellCoord = input.split("\\s+");
            String spell = spellCoord[0];
            int spellRow = Integer.parseInt(spellCoord[1]);
            int spellColumn = Integer.parseInt(spellCoord[2]);

            List<Integer> rowsHitted = new ArrayList<>();
            rowsHitted.add((spellRow - 1) < 0 ? 0 : (spellRow - 1));
            rowsHitted.add(spellRow);
            rowsHitted.add((spellRow + 1) >= 15 ? 14 : (spellRow + 1));

            List<Integer> columnsHitted = new ArrayList<>();
            columnsHitted.add((spellColumn - 1) < 0 ? 0 : (spellColumn - 1));
            columnsHitted.add(spellColumn);
            columnsHitted.add((spellColumn + 1) >= 15 ? 14 : (spellColumn + 1));
            switch (spell) {
                case "Cloud":
                    if (isPlayerHit(playerRow, playerColumn, rowsHitted, columnsHitted) && !isPlayerEscape(playerRow, playerColumn, rowsHitted, columnsHitted)) {
                        isCloudOn = true;
                        playerHealth -= plegueCloudDamage;
                    }
                    break;
                case "Eruption":
                    if (isPlayerHit(playerRow, playerColumn, rowsHitted, columnsHitted) && !isPlayerEscape(playerRow, playerColumn, rowsHitted, columnsHitted)) {
                        if (isCloudOn) {
                            isEruptionOn = true;
                        } else {
                            playerHealth -= eruptionDamage;
                        }
                    }
                    break;
            }
            if (spell.equals("Cloud")) {
                lastSpell = "Plague Cloud";
            } else {
                lastSpell = spell;
            }
            if (checkForDead(playerHealth, heiganHealth)) break;
            if (isCloudOn) {
                playerHealth -= plegueCloudDamage;
                isCloudOn = false;
            }
            input = sc.nextLine();
        }

        System.out.printf("Heigan: %s\n", isHeiganDead ? "Defeated!" : String.format("%.2f", heiganHealth));
        System.out.printf("Player: %s\n", isPlayerDead ? String.format("Killed by %s", lastSpell) : playerHealth);
        System.out.printf("Final position: %d, %d\n", playerRow, playerColumn);
    }

    private static boolean checkForDead(int playerHealth, double heiganHealth) {
        if (heiganHealth <= 0 && playerHealth <= 0) {
            isHeiganDead = true;
            isPlayerDead = true;
            return true;
        } else if (heiganHealth <= 0) {
            isHeiganDead = true;
            return true;
        } else if (playerHealth <= 0) {
            isPlayerDead = true;
            return true;
        }
        return false;
    }

    private static boolean isPlayerHit(int plRow, int plColumn, List<Integer> rowsHitted, List<Integer> columnsHitted) {
        if (rowsHitted.contains(plRow) && columnsHitted.contains(plColumn)) {
            return true;
        }
        return false;
    }

    private static boolean isPlayerEscape(int plRow, int plColumn, List<Integer> rowsHitted, List<Integer> columnsHitted) {
        if (!isPlayerHit((plRow - 1) < 0 ? 0 : (plRow - 1), plColumn, rowsHitted, columnsHitted)) {
            playerRow = (plRow - 1) < 0 ? 0 : (plRow - 1);
            return true;
        } else if (!isPlayerHit(plRow, (plColumn + 1) >= 15 ? 14 : plColumn + 1, rowsHitted, columnsHitted)) {
            playerColumn = (plColumn + 1) >= 15 ? 14 : plColumn + 1;
            return true;
        } else if (!isPlayerHit((plRow + 1) >= 15 ? 14 : (plRow + 1), plColumn, rowsHitted, columnsHitted)) {
            playerRow = (plRow + 1) >= 15 ? 14 : (plRow + 1);
            return true;
        } else if (!isPlayerHit(plRow, (plColumn - 1) < 0 ? 0 : plColumn - 1, rowsHitted, columnsHitted)) {
            playerColumn = (plColumn - 1) < 0 ? 0 : plColumn - 1;
            return true;
        }
        return false;
    }
}
