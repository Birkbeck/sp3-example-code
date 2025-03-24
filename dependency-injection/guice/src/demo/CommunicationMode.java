package demo;


public interface CommunicationMode {

    CommunicationModel getMode();

    boolean sendMessage(String message);

}