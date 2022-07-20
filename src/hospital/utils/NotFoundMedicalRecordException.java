package hospital.utils;

import hospital.controller.MedicalRecordController;

public class NotFoundMedicalRecordException extends Exception {
    public NotFoundMedicalRecordException(String errorLine) {
        super(errorLine);
    }

    public static void checkIsExist(MedicalRecordController medicalRecordController, String idMedicalRecord) throws NotFoundMedicalRecordException {
        if (medicalRecordController.searchMedicalRecordeByIdMedicalRecord(idMedicalRecord) == null) {
            throw new NotFoundMedicalRecordException("Id Medical Record not exist");
        }
    }
}
