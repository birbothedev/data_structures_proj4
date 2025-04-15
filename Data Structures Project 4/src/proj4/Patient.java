package proj4;

public class Patient implements Comparable<Patient> {
    private final String firstName;
    private final String lastName;
    private String triageCode;
    private int priority;

    public Patient(String firstName, String lastName, String triageCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.triageCode = triageCode;
    }

    public String getTriageCode() {
        return triageCode;
    }

    public void setTriageCode(String triageCode) {
        this.triageCode = triageCode;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + triageCode;
    }

    @Override
    public int compareTo(Patient other) {
        //compare patient priorities to sort them based on the lower value
        return Integer.compare(this.priority, other.priority);
    }
}
