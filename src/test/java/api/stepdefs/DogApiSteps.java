package api.stepdefs;
import api.helpers.Context;
import api.helpers.DogApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class DogApiSteps {
    private final Context context = new Context();
    private Response response;
    @Given("I send a request to the Dog API to list all breeds")
    public void iSendARequestToTheDogAPIToListAllBreeds() {
        context.testRetrieveAllDogBreeds();
    }

    @Then("I should see the retriever breed in the list")
    public void iShouldSeeTheRetrieverBreedInTheList() {
        context.validateRetrieverBreedExits();
    }

    @Given("I send a request to the Dog API to list sub-breeds of retriever")
    public void iSendARequestToTheDogAPIToListSubBreedsOfRetriever() {
        context.testRetrieveRetrieverSubBreeds();
    }

    @Given("I send a request to the Dog API to get a random image for the golden sub-breed")
    public void iSendARequestToTheDogAPIToGetARandomImageForTheGoldenSubBreed() {
        context.testRetrieveRandomImage();
    }
}
