package com.kodilla.stream.lambda;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;
import org.omg.PortableServer.POA;

public class StreamMainPrzykladyTeoria {
    public static void main(String[] args) {
       /*JEDYNIE WYDRUKOWANIE NA EKRAN
        System.out.println("Welcome to module 7 - Stream");

        PODEJŚCIE OBIEKTOWE
        //utwórz obiekt klasy SaySomething oraz uruchom jego metodę say():
        SaySomething saySomething = new SaySomething();
        saySomething.say();

        PODEJŚCIE OBIEKTOWE- DO METOD KLAY PRZEKAZUJEMY WARTOŚCI ZMEINNYCH I KOD
        //obiekt klasy Processor który będzie odpowiedzialny za uruchomienie przekazywanych do metody execute(Executor executor) obiektów implementujących interfejs Executor
        Processor processor = new Processor();
        //obiekt implementujący interfejs Executor
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        //wywołanie metody execute(Executor executor) klasy Processor, której za pośrednictwem argumentu przekazujemy obiekt
        processor.execute(executeSaySomething);
        //do klasy Processor przekazaliśmy nie tylko tekst do wyświetlenia.
        // Przekazaliśmy również kod, który ma być wykonany (w postaci implementacji metody execute() obiektu executeSaySomething).
        // W ten sposób zyskaliśmy cenną możliwość - oprócz danych, możemy również przekazywać kod, który na tych danych operuje!
        //dzięki powyższemu rozwiązaniu, do metod klasy możemy przekazać nie tylko wartości zmiennych, ale również kod, który ma być wykonany.

        //WYRAŻENIE LAMBDA DlUzSZA WERSJA
        // obiekt klasy Processor, który odpowiedzialny jest za wykonywanie kodu, który zostanie przekazany jako parametr (kod musi implementować interfejs Executor)
        Processor processor = new Processor();
        //tworzone jest wyrażenie lambda i przypisywane do zmiennej codeToExecute
        //to inaczej: Executor codeToExecute = public void process() {System.out.println("This is an example text.");
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        //wywoływana jest metoda execute klasy Processor, która jako argument otrzymuje wyrażenie lambda codeToExecute
        processor.execute(codeToExecute);
        !!!!!
        Zawsze gdy chcemy przekazywać do metody wyrażenia lambda, to metoda ta musi oczekiwać argumentu typu interfejsowego.
        Interfejs zaś musi mieć TYLKO jedną metodę. Implementacją tej właśnie metody stanie się otrzymane wyrażenie lambda.
        !!!!!

        //WYRAŻENIE LAMBDA KRÓTSZA WERSJA- Zmiennej codeToExecute w ogóle nie musimy tworzyć - możemy nasz kod przekazać wprost do argumentu metody execute klasy ProcessoR
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));
        */
        //Przykład kalkulatora wykorzystującego wyrażenia lambda i referencji do metod
        //tworzenie obiektu
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        //czterokrotnie wywołujemy metodę executeExpression(double a, double b, MathExpression mathExpression) - każdorazowo podajemy (poprzez wyrażenie lambda z parametrami) inny kod działania matematycznego do wykonania

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        //Przykłąd kalkulatora- referencja do metod- Jest to inny sposób na przekazanie do metody kodu, który ma zostać wykonany
        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);


}
}

