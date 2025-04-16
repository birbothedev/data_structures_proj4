package proj4;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TriageSimulator {
    private final PriorityQueue<Patient> priorityQueue = new PriorityQueue<>();
    private Queue<Patient> firstQueue = new LinkedList<>();
    private Queue<Patient> secondQueue = new LinkedList<>();
    private Queue<Patient> thirdQueue =  new LinkedList<>();
    private int arrivalOrder;

    public TriageSimulator(Queue<Patient> firstQueue, Queue<Patient> secondQueue, Queue<Patient> thirdQueue) {
        this.firstQueue = firstQueue;
        this.secondQueue = secondQueue;
        this.thirdQueue = thirdQueue;
    }

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
        return (firstQueue.isEmpty() && secondQueue.isEmpty() && thirdQueue.isEmpty());
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
        return " ";
    }

}
