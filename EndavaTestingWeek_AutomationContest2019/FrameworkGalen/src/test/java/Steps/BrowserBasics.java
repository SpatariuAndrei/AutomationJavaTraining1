package Steps;

import Help.ShareData;
import org.jbehave.core.annotations.AfterStories;

public class BrowserBasics extends BaseSteps {

    public BrowserBasics(ShareData share)
    {
        super(share);
    }


    //Steps
    @AfterStories
    public void closeBrowser()
    {
        if(share.driver!=null)
        {
            share.driver.quit();
        }
    }
}
