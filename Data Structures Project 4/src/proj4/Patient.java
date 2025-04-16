package proj4;

public class Patient implements Comparable<Patient> {
    private final String firstName;
    private final String lastName;
    private String triageCode;
    private int priority;
    private int arrivalOrder;

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

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    public void setArrivalOrder(int arrivalOrder) {
        this.arrivalOrder = arrivalOrder;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + triageCode;
    }

    @Override
    public int compareTo(Patient other) {
        // if priorities are not the same
        if (this.priority != other.priority){
            // compare patient priorities to sort them based on the lower value
            return Integer.compare(this.priority, other.priority);
        } else {
            // if priorities are the same, sort them based on arrival order
            return Integer.compare(this.arrivalOrder, other.arrivalOrder);
        }
    }
}
