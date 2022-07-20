package employee.view;

import employee.utils.DuplicatePersonalRecordException;
import employee.utils.ConverterDateTimeAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDisplay {
    static Scanner scanner = new Scanner(System.in);
    public static String FORMAT_ID_PERSON_EMPLOYEE = "^NV-\\d{3}$";

    public static String FORMAT_PHONE = "(0)\\d{9}";
    public static String FORMAT_ID_PERSON_STUDENT = "^HV-\\d{3}$";
    public static String FORMAT_DAY = "^(([0-2]\\d|)|(3)[0-1])/(((0)[1-9])|((1)[0-2]))/(((19)[3-9]\\d)|((20)\\d{2}))$";

    public static final String COMMA_DELIMITER = ",";

    public static List<String> collectDataFromUserInput(String props, String check) {
        String[] properties = props.split(COMMA_DELIMITER);
        List<String> answer = new ArrayList<>();
        String dateIn = "";
        for (String line : properties) {
            if (line.equalsIgnoreCase("idPerson")) {
                answer.add(getIdPersonValue(line, check));
                continue;
            }
            if (line.contains("point")) {
                answer.add(getPoint(line));
                continue;
            }

            if (line.contains("phone")) {
                answer.add(getDataCorrectValid(line, FORMAT_PHONE));
                continue;
            }

            if (line.equalsIgnoreCase("day_join")) {
                answer.add(getDayJoin(line, dateIn));
                continue;
            }

            if (line.contains("day")) {
                dateIn = getDataCorrectValid(line, FORMAT_DAY);
                answer.add(dateIn);
                continue;
            }

            if (line.contains("Number")) {
                answer.add(getSalary(line));
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

    public static String getStringValue(String line) {
        boolean flagAgain = false;
        while (true) {
            String currentLine = flagAgain ? String.format("Input %s again", line) : String.format("Input %s", line);
            System.out.println(currentLine);
            String str = scanner.nextLine();

            if (!str.trim().isEmpty()) {
                return DisplayEnumChoice.upperFirstLetter(str);
            }

            System.out.println("Input something please !!!");
            flagAgain = true;
        }
    }

    public static String getSalary(String line) {
        int number;
        while (true) {
            try {
                System.out.println("Input " + line);
                number = Integer.parseInt(scanner.nextLine());

                if (number < 0) {
                    System.out.println(line + " BIGGER ZERO");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println(line + " MUST NUMBER");
            }
        }
        return String.valueOf(number);
    }
    public static String getPoint(String line) {
        int number;
        while (true) {
            try {
                System.out.println(line);
                number = Integer.parseInt(scanner.nextLine());

                if (number < 0) {
                    System.out.println(line + "BIGGER ZERO");
                    continue;
                }

                if(number > 10){
                    System.out.println(line + " MUST SMALLER OR EQUALS 10");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println(line + " MUST NUMBER");
            }
        }
        return String.valueOf(number);
    }
    public static String getIdPersonValue(String line, String check) {
        String idPerson;
        boolean flagAgain = false;
        while (true) {
            try {
                System.out.println(flagAgain ? "Input " + line + " again" : "Input " + line);
                idPerson = scanner.nextLine();
                if (check.equalsIgnoreCase("nv")) {
                    if (!idPerson.matches(FORMAT_ID_PERSON_EMPLOYEE)) {
                        System.out.println("NOT CORRECT FORMAT NV-123");
                        flagAgain = true;
                        continue;
                    }
                } else {
                    if (!idPerson.matches(FORMAT_ID_PERSON_STUDENT)) {
                        System.out.println("NOT CORRECT FORMAT HV-123");
                        flagAgain = true;
                        continue;
                    }
                }
                DuplicatePersonalRecordException.isExistsInList(idPerson);
                flagAgain = true;
                break;
            } catch (DuplicatePersonalRecordException e) {
                System.out.println(e.getMessage());
            }
        }
        return idPerson.toUpperCase();
    }

    public static String getDayJoin(String line, String birthday) {
        String date;
        while (true) {
            System.out.println("Input " + line);
            date = scanner.nextLine();

            if (date.matches(FORMAT_DAY)) {
                if (isBiggerDate(date, birthday)) {
                    break;
                }
                System.out.println("Day Join classes must bigger your birthday " + birthday);
                continue;
            }
            System.out.println("day wrong type dd/mm/yyyy");
        }
        return date;
    }

    public static boolean isBiggerDate(String dayJoin, String birthday) {
        return ConverterDateTimeAndString.converterStringToLocalDate(dayJoin).isAfter(ConverterDateTimeAndString.converterStringToLocalDate(birthday));
    }

}
