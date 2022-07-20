package employee.utils;

import employee.controller.PersonController;

public class DuplicatePersonalRecordException extends Exception {
    public DuplicatePersonalRecordException(String errorLine) {
        super(errorLine);
    }

    public static void isExistsInList(String idPerson) throws DuplicatePersonalRecordException {
        if (PersonController.isExistByIdPerson(idPerson))
            throw new DuplicatePersonalRecordException(idPerson + " is duplicate!");
    }
}
