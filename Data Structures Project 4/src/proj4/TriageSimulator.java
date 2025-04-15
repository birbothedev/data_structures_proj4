package proj4;

import java.util.PriorityQueue;
import java.util.Queue;

public class TriageSimulator {
    private final PriorityQueue<Patient> priorityQueue = new PriorityQueue<>();
    private final Queue<Patient> firstQueue;
    private final Queue<Patient> secondQueue;
    private final Queue<Patient> thirdQueue;

    public TriageSimulator(Queue<Patient> firstQueue, Queue<Patient> secondQueue, Queue<Patient> thirdQueue) {
        this.firstQueue = firstQueue;
        this.secondQueue = secondQueue;
        this.thirdQueue = thirdQueue;
    }

    public void addRegularQueue(Patient patient){
        if (patient.getTriageCode() == null){
            System.out.println("Please add a triage code for the patient.");
        } else if (patient.getTriageCode().equalsIgnoreCase("AH") ||
                patient.getTriageCode().equalsIgnoreCase("HA") ||
                patient.getTriageCode().equalsIgnoreCase("ST")){
            firstQueue.offer(patient);
            patient.setPriority(1);
        } else if (patient.getTriageCode().equalsIgnoreCase("BL") ||
                patient.getTriageCode().equalsIgnoreCase("SF") ||
                patient.getTriageCode().equalsIgnoreCase("IW") ||
                patient.getTriageCode().equalsIgnoreCase("KS") ||
                patient.getTriageCode().equalsIgnoreCase("OT")){
            secondQueue.offer(patient);
            patient.setPriority(2);
        } else {
            thirdQueue.offer(patient);
            patient.setPriority(3);
        }
    }

    public void addPriorityQueue(Patient patient) {
        priorityQueue.add(patient);
    }

    public String remove(){
        priorityQueue.remove(patient);
    }
}
