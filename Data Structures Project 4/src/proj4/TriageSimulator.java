package proj4;

class TriageSimulator {
    private String firstName;
    private String lastName;
    private String triageCode;

    public TriageSimulator(String firstName, String lastName, String triageCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.triageCode = triageCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTriageCode() {
        return triageCode;
    }

    public void setTriageCode(String triageCode) {
        this.triageCode = triageCode;
    }
}
