package api.helpers;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class DogApi {
    private static final String BASE_URI = "https://dog.ceo/api/";

    public Response getAllBreeds() {
        return given()
                .baseUri(BASE_URI)
                .when()
                .get("breeds/list/all")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }

    public Response getBreed(String breed) {
        return given()
                .baseUri(BASE_URI)
                .when()
                .get("breed/" + breed + "/list")
                .then()
                .extract()
                .response();
    }

    public Response getRandomImageForBreed() {
        return given()
                .baseUri(BASE_URI)
                .when()
                .get("breeds/image/random")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }
}
