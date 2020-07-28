package com.kodilla.exception.nullpointer;

public class MessageSender {
    public void sendMessageTo(User user, String message) throws MessageNotSentException {
        //W momencie kiedy nie mamy pewności czy obiekt trafi do nas w jego pełnej okazałości, możemy zabezpieczyć się przed NullPointerException w poniższy sposób.
        //Wystarczy jeden mały if, aby mieć 100% pewności, że obiekt który został do nas przekazany nie jest null - dzięki temu nasz program nie przestanie działać!
        //Oczywiście powinniśmy pamiętać o tym, że jeśli zastosujemy takie rozwiązanie, nigdy nie dowiemy się, że obiekt był wartości null.
        //Najlepszym wyjściem z tej sytuacji byłoby rzucenie wyjątku checked, który będzie musiał zostać obsłużony przez osobę korzystającą z tej metody.
        if(user != null) {
            System.out.println("Sending message: " + message + " to: " + user.getName());
        } else {
            throw new MessageNotSentException("Object User was null");
        }
    }
}
