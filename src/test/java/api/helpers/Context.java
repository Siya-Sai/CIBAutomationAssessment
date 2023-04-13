package api.helpers;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Context {
    private final DogApi dogApi = new DogApi();

    @Test
    public void testRetrieveAllDogBreeds() {
        // Call the DogApi to get all dog breeds
        Response response = dogApi.getAllBreeds();
        // Extract the list of all dog breeds from the JSON response using the "message" field
        Map<String, List<String>> allBreeds = response.jsonPath().getMap("message");
        List<String> breedNames = new ArrayList<>(allBreeds.keySet());
        // Print the list of all dog breeds
        System.out.println(breedNames);
    }

    @Test
    public void validateRetrieverBreedExits() {
        // Call the DogApi to get all dog breeds
        Response response = dogApi.getAllBreeds();
        // Extracts the breeds map from the response
        Map<String, Object> breedsMap = response.jsonPath().getMap("message");
        // Verifies that the "retriever" breed is in the list using Hamcrest's "hasItem" matcher
        assertThat(breedsMap.keySet(), hasItem("retriever"));
    }

    @Test
    public void testRetrieveRetrieverSubBreeds() {
        // Call the DogApi to get sub-breeds of retriever
        Response response = dogApi.getBreed("retriever");
        // Extract the list of sub-breeds from the JSON response using the "message" field
        List<String> subBreeds = response.jsonPath().getList("message");
        // Assert that the list of sub-breeds contains the expected values using Hamcrest's "hasItems" matcher
        assertThat(subBreeds, hasItems("chesapeake", "curly", "flatcoated", "golden"));
    }

    @Test
    public void testRetrieveRandomImage() {
        // Call the DogApi to get a random image for golden retriever
        Response response = dogApi.getRandomImageForBreed();
        // Extract the random image/link from the response body using Rest Assured's JsonPath API
        String randomImage = response.jsonPath().get("message");
        // Print the random image/link
        System.out.println(randomImage);
    }
}
