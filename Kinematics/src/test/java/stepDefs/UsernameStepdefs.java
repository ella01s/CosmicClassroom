package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsernameStepdefs {
    @Given("I start the program and am requested to provide a username")
    public void iStartTheProgramAndAmRequestedToProvideAUsername() {
    }

    @When("I provide a username {string} for the first time and it does not already exist in the program")
    public void iProvideAUsernameForTheFirstTimeAndItDoesNotAlreadyExistInTheProgram(String arg0) {
    }

    @And("I press enter")
    public void iPressEnter() {
    }

    @Then("my username will be added to the database")
    public void myUsernameWillBeAddedToTheDatabase() {
    }
}
