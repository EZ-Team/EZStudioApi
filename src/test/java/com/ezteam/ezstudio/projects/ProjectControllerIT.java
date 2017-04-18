package com.ezteam.ezstudio.projects;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = RANDOM_PORT)
public class ProjectControllerIT {

    @LocalServerPort
    private int localServerPort;

    @Before
    public void init() {
        RestAssured.port = localServerPort;
    }

   /* @Test
    public void should_get_all_projects() {
        given()
                .log().all()
        .when()
                .get("/projects")
        .then()
                .log().all()
                .statusCode(200)
                .body("$", hasSize(4));
    }*/
}
