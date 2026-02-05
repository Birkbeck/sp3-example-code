package factory.factorydemo;

class NotificationFactory { // singleton
    public Notification createNotification(String type){
        if (type == null || type.isEmpty()) return null;

        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            default -> throw new IllegalArgumentException("Unknown type: " + type)
        };
    }
}
/*
NotificationFactory nf = NotificationFactory.getInstance();
Notification email = nf.createNotification("email");
Notification sms= nf.createNotification("sms");
Notification rubbish = nf.createNotification("ahhhh");
*/

// ADD, MOV, STO, LDD, LDA...
// Instruction 
// "ADD" -> instance of the class that represents the ADD instruction.
// AddInstruction.class

// "ADD" -> "Add"
// "Add" + "Instruction" -> "AddInstruction"
// Using reflection dynamically load the AddInstruction.class and create an instance of it.