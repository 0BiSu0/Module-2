package hospital.controller;

import hospital.models.MedicalNormal;
import hospital.models.MedicalRecord;
import hospital.models.MedicalVIP;
import hospital.utils.RegexCheck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordController {

    static final String COMMA_DELIMITER = ",";

    static String empty = "empty";
    static String fileName = "src\\hospital\\data\\medical_records.csv";
    public List<MedicalRecord> recordList  = new ArrayList<>();

    public MedicalRecordController() {
       readAndUpdateList();
    }

    public void addNewMedicalRecorde(MedicalRecord medicalRecord) {
        if (isNotExistByPosition(medicalRecord.position) && isNotExistByIdMedicalRecord(medicalRecord.idMedicalRecord)) {
            recordList.add(medicalRecord);
        }
    }

    public boolean isNotExistByPosition(int position) {
        for (MedicalRecord medicalRecord : recordList) {
            if (medicalRecord.position == position) {
                return false;
            }
        }
        return true;
    }

    public int getNextIdIsCorrectAscending() {
        if (recordList.isEmpty()) return 1;
        int number_check = 0;
        for (MedicalRecord medicalRecord : recordList) {
            ++number_check;
            if (medicalRecord.position != number_check) {
                return number_check;
            }
        }
        return number_check + 1;
    }


    public boolean isNotExistByIdMedicalRecord(String idMedicalRecord) {
        for (MedicalRecord medicalRecord : recordList) {
            if (medicalRecord.idMedicalRecord.equalsIgnoreCase(idMedicalRecord)) {
                return false;
            }
        }
        return true;
    }

    public void removeMedicalRecorde(MedicalRecord medicalRecord){
        recordList.remove(medicalRecord);
    }
    public void displayListMedicalRecorde() {
        if (recordList.isEmpty()) {
            System.out.println("Empty list, update data !!!");
        }
        recordList.forEach(System.out::println);
    }

    public MedicalRecord searchMedicalRecordeByIdMedicalRecord(String idMedicalRecord) {
        for (MedicalRecord medicalRecord : recordList) {
            if (medicalRecord.idMedicalRecord.equalsIgnoreCase(idMedicalRecord)) return medicalRecord;
        }
        return null;
    }

    public boolean isEmpty() {
        return recordList.isEmpty();
    }

    public void saveCSV() {
        recordList.sort((a, b) -> a.position - b.position);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(MedicalRecord.allProps);
            bufferedWriter.newLine();
            for (MedicalRecord medicalRecord : recordList) {
                bufferedWriter.write(medicalRecord.getData());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("File NOT FOUND");
        }
        System.out.println("Saving...");
    }

    public void readAndUpdateList() {
        File file = new File(fileName);
        if(file.length() == 0) return;

        boolean flag = true;
        int number = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                boolean flagId = true;

                if (line.trim().isEmpty()) continue;

                if (flag) {
                    flag = false;
                    continue;
                }

                String[] currentArray = line.split(COMMA_DELIMITER);
                List<String> tempList = new ArrayList<>();
                for (String element : currentArray) {

                    if (flagId) {
                        number = (Integer.parseInt(element));
                        flagId = false;
                        continue;
                    }

                    if (element.equalsIgnoreCase(empty)) {
                        continue;
                    }

                    tempList.add(element);
                }

                String check = tempList.get(tempList.size() - 1);

                if (RegexCheck.isInteger(check)) {
                    addNewMedicalRecorde(new MedicalNormal(number,tempList));
                    continue;
                }

                addNewMedicalRecorde(new MedicalVIP(number,tempList));
            }
            recordList.sort((a, b) -> a.position - b.position);
        } catch (IOException e) {
            System.out.println("File NOT FOUND");
        }}

}
