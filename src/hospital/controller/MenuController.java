package hospital.controller;

import hospital.utils.RegexCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    static Scanner scanner = new Scanner(System.in);
    public static String FORMAT_ID_MEDICAL = "^[Bb][aA]-\\d{3}$";
    public static String FORMAT_ID_PATIENT = "^[Bb][nN]-\\d{3}$";
    public static String FORMAT_VIP = "^[iI]{1,3}$";
    public static String FORMAT_DAY = "^(([0-2]\\d|)|(3)[0-1])/(((0)[1-9])|((1)[0-2]))/(((19)[3-9]\\d)|((20)\\d{2}))$";


    public static final String COMMA_DELIMITER = ",";

    public static void displayMenu(String string) {
        List<String> list = new ArrayList<>(Arrays.asList(string.split(",")));
        final int[] i = {1};
        list.forEach(x -> System.out.printf("%d. %s\n", i[0]++, x));
    }

    public static String getStringValue(String line) {
        boolean flagAgain = false;
        while (true) {
            String currentLine = flagAgain ? String.format("Input %s again", line) : String.format("Input %s", line);
            System.out.println(currentLine);
            String str = scanner.nextLine();
            if (!str.trim().isEmpty()) {
                return str;
            }

            System.out.println("Input something");
            flagAgain = true;
        }
    }


    public static List<String> collectDataFromUserInput(String props) {
        String[] properties = props.split(COMMA_DELIMITER);
        List<String> answer = new ArrayList<>();
        String dateIn = "";
        for (String line : properties) {
            if (line.contains("MedicalRecord")) {
                answer.add(getDataCorrectValid(line, FORMAT_ID_MEDICAL));
                continue;
            }

            if (line.equalsIgnoreCase("vip")) {
                answer.add(getDataCorrectValid(line, FORMAT_VIP));
                continue;
            }

            if (line.contains("Patient")) {
                answer.add(getDataCorrectValid(line, FORMAT_ID_PATIENT));
                continue;
            }


            if (line.equalsIgnoreCase("dateOut")) {
                answer.add(getDateOut(line, dateIn));
                continue;
            }

            if (line.contains("date")) {
                dateIn = getDataCorrectValid(line, FORMAT_DAY);
                answer.add(dateIn);
                continue;
            }
            answer.add(getStringValue(line));
        }
        return answer;
    }

    public static String getDataCorrectValid(String line, String regex) {
        String result;
        boolean flagAgain = false;
        while (true) {
            System.out.println(flagAgain ? "Input " + line + " again" : "Input " + line);
            result = scanner.nextLine();

            if (result.matches(regex)) {
                return result.toUpperCase();
            }

            System.out.println(result + " not correct valid type ");
            flagAgain = true;
        }
    }

//    private static String getVipValue(String line) {
//        String record;
//        while (true) {
//            System.out.println(line);
//            record = scanner.nextLine();
//
//            if (RegexCheck.isCorrectVip(record)) {
//                break;
//            }
//            System.out.println("Type VIP is I or II or III");
//        }
//        return record.toUpperCase();
//    }

//    public static String getMedicalRecord(String line) {
//        String record;
//        while (true) {
//            System.out.println(line);
//            record = scanner.nextLine();
//
//            if (RegexCheck.isCorrectIdMedical(record)) {
//                break;
//            }
//            System.out.println("Type ba-123 or BA-123 !!!");
//        }
//        return record.toUpperCase();
//    }

//    public static String getPatient(String line) {
//        String record;
//        while (true) {
//            System.out.println(line);
//            record = scanner.nextLine();
//
//            if (RegexCheck.isCorrectIdPatient(record)) {
//                break;
//            }
//            System.out.println("Type bn-123 or BN-123 !!!");
//        }
//        return record.toUpperCase();
//    }

    public static String getDateOut(String line, String dateIn) {
        String date;
        while (true) {
            System.out.println(line);
            date = scanner.nextLine();

            if (date.matches(FORMAT_DAY)) {
                if (RegexCheck.isBiggerDate(date, dateIn)) {
                    break;
                }
                System.out.println("DAY OUT MUST BIGGER DATE IN " + dateIn);
                continue;
            }
            System.out.println("day wrong type dd/mm/yyyy");
        }
        return date;
    }

//    public static String getDateCorrect(String line) {
//        String date;
//        while (true) {
//            System.out.println(line);
//            date = scanner.nextLine();
//
//
//            if (RegexCheck.isCorrectTypeDate(date)) {
//                break;
//            }
//
//            System.out.println("Day Type dd/mm/yyyy");
//        }
//        return date;
//    }
}