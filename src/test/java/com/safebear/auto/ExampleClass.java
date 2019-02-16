package com.safebear.auto;

// This is a comment

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

// This is a Class, which contains variables and methods.
public class ExampleClass {

    // This is a variable - and integer, which can only contain whole numbers. We've called it 'exampleVariable'
    int exampleVariable = 5;

    // This is a test that checks to see if exampleVariable is '5'
    @Test
    public void emptyMethod(){

        // We use an Assertion to check that our example variable is equal to 5
        Assertions.assertThat(exampleVariable).isEqualTo(5);

        // We can print something to screen
        System.out.println("This is our cloned project");

    }

}
