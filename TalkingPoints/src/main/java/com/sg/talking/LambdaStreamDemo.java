/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.talking;

import com.sg.talking.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author augie email: aschau@wiley.com date: 2022.02.04 purpose:
 */
class LambdaStreamDemo {

    private List<Person> people;

    public LambdaStreamDemo() {
        people = new ArrayList<>();
        loadPeople();
    }

    public void demo(String[] args) {

        // Old style of processing a collection
        List<Person> adults = new ArrayList<>();
        for (Person currentPerson : people) {
            if (currentPerson.getAge() >= 18) {
                adults.add(currentPerson);
            }
        }
        simpleStream();
        System.out.println("");
        integratedForEach();
        
    }

    private void simpleStream(){
    
        // Stream approach to processing a collections data
        
        List<String> fullyProcessedList = 
        people.stream()
                .filter(
                        //(aPerson) -> aPerson.getAge() >= 18
                        // single argument lambda does not require parens
                        aPerson -> aPerson.getAge() >= 18)
                .filter(
                        filteredPerson -> filteredPerson.getName().startsWith("B")
                )
                .map(
                        doubleFiltered -> doubleFiltered.getName()
                )
                .collect(Collectors.toList());

           for(var a : fullyProcessedList){
               System.out.println(a);
           }
        }
    
    private void loadPeople() {
        people.add(new Person("Fred", 25));
        people.add(new Person("Wilma", 24));
        people.add(new Person("Pebbles", 5));
        people.add(new Person("Barney", 26));
        people.add(new Person("Betty", 25));
        people.add(new Person("Bambam", 6));
        people.add(new Person("Dino", 21));
    }

    int countOfCharacters = 0;

    private void integratedForEach() {
     
        // Stream approach to processing a collections data
        people.stream()
                .filter(
                        //(aPerson) -> aPerson.getAge() >= 18
                        // single argument lambda does not require parens
                        aPerson -> aPerson.getAge() >= 18)
                .filter(
                        filteredPerson -> filteredPerson.getName().startsWith("B")
                )
                .map(
                        doubleFiltered -> doubleFiltered.getName()
                )
                .forEach(
                        str -> countOfCharacters += str.length()
                );
//                .forEach(
//                        someString -> {
//                            var repeated = someString.repeat(2);
//                            System.out.println(repeated);
//                                    }
//                );
            System.out.println(countOfCharacters);
    }

}
