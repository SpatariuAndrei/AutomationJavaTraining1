package Steps;

import Help.ShareData;
import Pages.AccountPage;
import Pages.BlogListPage;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class BlogListSteps extends BaseSteps {

    public BlogListPage blogListPage=new BlogListPage(share.driver).get();

    //Constructor
    public BlogListSteps(ShareData share) {
        super(share);
    }


    //Steps
    @When("I select a blog from displayed list")
    public void enterBlogListPage() {

        blogListPage.selectBlog();
    }

    @Then("I validate the blogListPage")
    public void validateBlogListPage()
    {
        String expected=ShareData.getValue("blogPage");
        blogListPage.validatePage(expected);
    }



}
