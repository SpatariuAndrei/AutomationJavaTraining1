package tests;

import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.AddToCartSteps;

/**
 *
 */
//@RunWith(SerenityRunner.class)
public class AddToCartStory extends BaseStory {

//    public AddToCartStory(){
//
//        useStepsFactory(stepsFactory());
//    }


    @Steps
    AddToCartSteps addToCartSteps;

    @Test
    public void testExample(){
        addToCartSteps.givenIGoToPcgarageHomePage();
        addToCartSteps.whenISearchForProduct("product");
        addToCartSteps.whenIGoToTheProductPage("productName");
        addToCartSteps.whenIAddItToMyCart();
        addToCartSteps.thenICanSeeTheProductnameInMyCart("cartProductName");
    }


//    @Override
//    public InjectableStepsFactory stepsFactory(){
//        ArrayList<AddToCartSteps> stepFileList = new ArrayList<>();
//        stepFileList.add(new AddToCartSteps(sharedData));
//        return new InstanceStepsFactory(configuration(), stepFileList);
//    }
//
//    public List<String> storyPaths(){
//        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
//                "**/stories/shopping/cart/AddToCartStory.story","");
//    }
//

}



