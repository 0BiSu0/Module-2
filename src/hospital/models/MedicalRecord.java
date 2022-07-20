package hospital.models;

import java.time.LocalDate;

public abstract class MedicalRecord {

    public static String allProps = "POSITION,ID_MEDICAL_RECORD,ID_PATIENT,NAME,DATE_IN,DATE_OUT,REASON,VIP,TERM_VIP,PAYMENT";

    public int position;
    public String idMedicalRecord;

    public String idPatient;

    public int getPosition() {
        return position;
    }

    public String name;

    public LocalDate dateIn;

    public LocalDate dateOut;

    public String reason;

    public MedicalRecord(int position, String idMedicalRecord, String idPatient, String name, LocalDate dateIn, LocalDate dateOut, String reason) {
        this.position = position;
        this.idMedicalRecord = idMedicalRecord;
        this.idPatient = idPatient;
        this.name = name;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reason = reason;
    }

    public abstract String getData();

    @Override
    public abstract String toString();

    public String getIdMedicalRecord() {
        return idMedicalRecord;
    }

    public MedicalRecord setIdMedicalRecord(String idMedicalRecord) {
        this.idMedicalRecord = idMedicalRecord;
        return this;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public MedicalRecord setIdPatient(String idPatient) {
        this.idPatient = idPatient;
        return this;
    }

    public String getName() {
        return name;
    }

    public MedicalRecord setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public MedicalRecord setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
        return this;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public MedicalRecord setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public MedicalRecord setReason(String reason) {
        this.reason = reason;
        return this;
    }
}
