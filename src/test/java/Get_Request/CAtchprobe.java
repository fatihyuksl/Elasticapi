package Get_Request;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class CAtchprobe {
    @Test
    public void get01() {
        //  i)  Set the URL,
        String url = "http://162.55.230.167:9200/_cat/thread_pool/write?v=true&h=node_name,active,queue,rejected,completed&s=queue:desc&format=json";

        // ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        // Bizden post, put ya da patch istenmedigi icin bu case de kullanmayacagiz.
        // iii) Type code to send request ( Talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();
    /*    Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);*/

        // iv) Do Assertion (dogrulama yapmak)

        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // Status Code konsola yazdiralim
        System.out.println("Status Code : " + response.getStatusCode());

        // Content Type konsola yazdiralim
        System.out.println("Content Type : " + response.getContentType());

        // Status Line konsola yaziralim
        System.out.println("Status Line : " + response.getStatusLine());

        // Header konsola yazdiralim
        System.out.println("Header : " + response.getHeader("Server"));

        // Headers konsola yazdiralim
        System.out.println("Headers : " + response.getHeaders());

        // Time konsola yazdiralim

        System.out.println("Time : " + response.getTime());
        assertEquals(200, response.getStatusCode());
        assertTrue(response.asString().contains("0"));
        assertTrue(response.asString().contains("node_name"));
        assertTrue(response.asString().contains("1"));
        assertTrue(response.asString().contains("2"));
        assertTrue(response.asString().contains("elasticsearch-master-3"));
        assertTrue(response.asString().contains("elasticsearch-master-5"));


        assertFalse(response.asString().contains("100"));
        assertFalse(response.asString().contains("201"));
        assertFalse(response.asString().contains("300"));
        assertFalse(response.asString().contains("400"));
        assertFalse(response.asString().contains("500"));
        assertFalse(response.asString().contains("600"));





/*        String str = response.asString();


        String[] kelimeler = str.split(" ");
        List<Integer> sayiListesi=new ArrayList<>();



            System.out.println(Arrays.toString(kelimeler));*/



       /* response.
                then().
                statusCode(200).
                contentType(ContentType.TEXT).and().
                body("node_name",equalTo("elasticsearch-master-4"),
                        "active",equalTo(0),
                        "queue",equalTo(0),
                        "rejected",equalTo(0),
                        "completed",equalTo(2373254)
                        );*/



        /*response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("node_name",hasSize(6),
                        "active",hasItem(""),
                        "userId",hasItems(2,8,9));*/


    }

        /*@Test
        public void dddd () {
            String url = "http://162.55.230.167:9200/_cat/thread_pool/write?v=true&h=node_name,active,queue,rejected,completed&s=queue:desc";
            Response response = given().when().get(url);
            response.prettyPrint();
            Catchprobe expectedData = new Catchprobe("elasticsearch-master-8,elasticsearch-master-2", 3, 3, 3, 3);
            System.out.println("expectedData = " + expectedData);


            Catchprobe actualData = response.as(Catchprobe.class);
            System.out.println("actualData = " + actualData);
*//*
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());*/

    @Test
    public void name() {
        String url = "http://162.55.230.167:9200/_cat/health?v";
        // ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        // Bizden post, put ya da patch istenmedigi icin bu case de kullanmayacagiz.
        // iii) Type code to send request ( Talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();


        // iv) Do Assertion (dogrulama yapmak)

        response.then().assertThat().statusCode(200).contentType("text/plain").statusLine("HTTP/1.1 200 OK");

        // Status Code konsola yazdiralim
        System.out.println("Status Code : " + response.getStatusCode());

        // Content Type konsola yazdiralim
        System.out.println("Content Type : " + response.getContentType());

        // Status Line konsola yaziralim
        System.out.println("Status Line : " + response.getStatusLine());

        // Header konsola yazdiralim
        System.out.println("Header : " + response.getHeader("Server"));

        // Headers konsola yazdiralim
        System.out.println("Headers : " + response.getHeaders());

        // Time konsola yazdiralim

        System.out.println("Time : " + response.getTime());
        assertEquals(200, response.getStatusCode());
        assertTrue(response.asString().contains("elasticsearch"));
        assertTrue(response.asString().contains("green"));
        assertTrue(response.asString().contains("10"));
        assertTrue(response.asString().contains("10"));
        assertTrue(response.asString().contains("status"));
        assertTrue(response.asString().contains("timestamp"));
        assertTrue(response.asString().contains("node.total"));
        assertTrue(response.asString().contains("epoch"));


        assertFalse(response.asString().contains("red"));
        assertFalse(response.asString().contains("yellow"));




    }
}
