package proj4;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TriageSimulator {
    private final PriorityQueue<Patient> priorityQueue = new PriorityQueue<>();
    private final Queue<Patient> firstQueue = new LinkedList<>();
    private final Queue<Patient> secondQueue = new LinkedList<>();
    private final Queue<Patient> thirdQueue =  new LinkedList<>();
    private int arrivalOrder;

    public TriageSimulator(){

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
        patient.setArrivalOrder(arrivalOrder++);
    }

    public void addPriorityQueue() {
        while (!firstQueue.isEmpty()){
            priorityQueue.add(firstQueue.poll());
        }
        while (!secondQueue.isEmpty()){
            priorityQueue.add(secondQueue.poll());
        }
        while (!thirdQueue.isEmpty()){
            priorityQueue.add(thirdQueue.poll());
        }
    }

    public Boolean isEmpty(){
        // if all queues are empty return true
        return (firstQueue.isEmpty() && secondQueue.isEmpty() && thirdQueue.isEmpty() && priorityQueue.isEmpty());
    }

    public void add(String lineFromFile){
        String[] parts = lineFromFile.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];
        String code = parts[2];

        Patient patient = new Patient(firstName, lastName, code);
        addRegularQueue(patient);
    }

    public String remove(){
        Patient p1 = priorityQueue.poll();
        if (p1 == null){
            return "No patients in the queue.";
        }
        firstQueue.remove(p1);
        secondQueue.remove(p1);
        thirdQueue.remove(p1);
        return "Next patient to be seen: " + p1;
    }
}
