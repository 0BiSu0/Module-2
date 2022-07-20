package hospital.view;

import hospital.controller.MedicalRecordController;
import hospital.controller.MenuController;
import hospital.models.MedicalNormal;
import hospital.models.MedicalVIP;
import hospital.utils.NotFoundMedicalRecordException;

import java.util.List;

public class Solution {
    static MedicalRecordController controller = new MedicalRecordController();

    public static void main(String[] args) {
        loop:
        while (true) {
            MenuController.displayMenu("ADD NEW,DELETE,DISPLAY,QUIT");
            String option = MenuController.getStringValue("YOUR CHOICE");
            switch (option) {
                case "1":
                    displayAddNewMedicalRecord();
                    break;
                case "2":
                    displayDeleteMedicalRecord();
                    break;
                case "3":
                    displayListMedicalRecord();
                    break;
                default:
                    break loop;
            }
        }
    }

    private static void displayAddNewMedicalRecord() {
        MenuController.displayMenu("ADD VIP,ADD NORMAL,BACK MAIN MENU");
        String option = MenuController.getStringValue("YOUR CHOICE");
        switch (option) {
            case "1": {
                List<String> list = MenuController.collectDataFromUserInput(MedicalVIP.getProps());
                controller.addNewMedicalRecorde(new MedicalVIP(controller.getNextIdIsCorrectAscending(),list));
                controller.saveCSV();
                break;
            }
            case "2": {
                List<String> list = MenuController.collectDataFromUserInput(MedicalNormal.getProps());
                controller.addNewMedicalRecorde(new MedicalNormal(controller.getNextIdIsCorrectAscending(),list));
                controller.saveCSV();
                break;
            }
            default:
                break;
        }
    }

    private static void displayDeleteMedicalRecord() {
        if(controller.isEmpty()) {
            System.out.println("Empty List!!! Update!!!");
            return;
        }

        controller.displayListMedicalRecorde();

        String idMedicalRecord;
        while (true) {
            try {
                idMedicalRecord = MenuController.getDataCorrectValid("idMedicalRecord want delete: ",MenuController.FORMAT_ID_MEDICAL);
                NotFoundMedicalRecordException.checkIsExist(controller, idMedicalRecord);
                break;
            } catch (NotFoundMedicalRecordException e) {
                System.out.println(e.getMessage());
            }
        }

        String option = MenuController.getStringValue(String.format("Search %s in\n%s.\nYour delete this ???",
                idMedicalRecord,
                controller.searchMedicalRecordeByIdMedicalRecord(idMedicalRecord)));

        if (option.equalsIgnoreCase("yes")) {
            controller.removeMedicalRecorde(controller.searchMedicalRecordeByIdMedicalRecord(idMedicalRecord));
            controller.saveCSV();
            System.out.println("delete done ....");
        }
    }

    private static void displayListMedicalRecord() {
        controller.displayListMedicalRecorde();
    }
}
