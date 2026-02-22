package tests;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.*;

public class APITesting {

    @Test
    public void getAPITest() {
//        String responseString = given()
//                .when().get("https://reqres.in/api/users?page=2")
//                .then().extract().asPrettyString();
        String responseString =
                "{\n" +
                        "  \"page\": 2,\n" +
                        "  \"per_page\": 6,\n" +
                        "  \"total\": 12,\n" +
                        "  \"total_pages\": 2,\n" +
                        "  \"data\": [\n" +
                        "    {\n" +
                        "      \"id\": 7,\n" +
                        "      \"email\": \"michael.lawson@reqres.in\",\n" +
                        "      \"first_name\": \"Michael\",\n" +
                        "      \"last_name\": \"Lawson\",\n" +
                        "      \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 8,\n" +
                        "      \"email\": \"lindsay.ferguson@reqres.in\",\n" +
                        "      \"first_name\": \"Lindsay\",\n" +
                        "      \"last_name\": \"Ferguson\",\n" +
                        "      \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 9,\n" +
                        "      \"email\": \"tobias.funke@reqres.in\",\n" +
                        "      \"first_name\": \"Tobias\",\n" +
                        "      \"last_name\": \"Funke\",\n" +
                        "      \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 10,\n" +
                        "      \"email\": \"byron.fields@reqres.in\",\n" +
                        "      \"first_name\": \"Byron\",\n" +
                        "      \"last_name\": \"Fields\",\n" +
                        "      \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 11,\n" +
                        "      \"email\": \"george.edwards@reqres.in\",\n" +
                        "      \"first_name\": \"George\",\n" +
                        "      \"last_name\": \"Edwards\",\n" +
                        "      \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 12,\n" +
                        "      \"email\": \"rachel.howell@reqres.in\",\n" +
                        "      \"first_name\": \"Rachel\",\n" +
                        "      \"last_name\": \"Howell\",\n" +
                        "      \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"support\": {\n" +
                        "    \"url\": \"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\n" +
                        "    \"text\": \"Tired of writing endless social media content? Let Content Caddy generate it for you.\"\n" +
                        "  },\n" +
                        "  \"_meta\": {\n" +
                        "    \"powered_by\": \"ReqRes\",\n" +
                        "    \"docs_url\": \"https://app.reqres.in/documentation\",\n" +
                        "    \"upgrade_url\": \"https://app.reqres.in/upgrade\",\n" +
                        "    \"example_url\": \"https://app.reqres.in/examples/notes-app\",\n" +
                        "    \"variant\": \"v1_b\",\n" +
                        "    \"message\": \"Need more than fake data? Projects give you real CRUD + auth in minutes.\",\n" +
                        "    \"cta\": {\n" +
                        "      \"label\": \"Get started\",\n" +
                        "      \"url\": \"https://app.reqres.in/upgrade\"\n" +
                        "    },\n" +
                        "    \"context\": \"legacy_success\"\n" +
                        "  }\n" +
                        "}";
        JsonPath jsonPath = new JsonPath(responseString);
        List<String> list = jsonPath.getList("data.id");
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), 12)) {
                System.out.println(jsonPath.getString("data.email[" + i + "]"));
            }
        }
    }

}
