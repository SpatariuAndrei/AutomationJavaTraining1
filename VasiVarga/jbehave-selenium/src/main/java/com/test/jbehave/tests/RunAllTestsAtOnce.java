package com.test.jbehave.tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddToCartStories.class,
        ProductsCompareStories.class,
        SignInStories.class,
        SignUpStories.class
})

public class RunAllTestsAtOnce {
}
