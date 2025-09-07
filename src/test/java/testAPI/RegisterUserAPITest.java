package testAPI;

import api.EndPoint.AllProductListAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserAPITest {


    @Test
    public void getAllProductList() {
        AllProductListAPI allProductListAPI = new AllProductListAPI(new api.Base.BaseAPI());
        Response response = allProductListAPI.getAllProduct();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void searchForProduct() {
        AllProductListAPI allProductListAPI = new AllProductListAPI(new api.Base.BaseAPI());
        Response response = allProductListAPI.searchForProduct();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void searchProductWithoutParameter() {
        AllProductListAPI allProductListAPI = new AllProductListAPI(new api.Base.BaseAPI());
        Response response = allProductListAPI.searchProductWithoutParameter();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("responseCode"), "400");
        Assert.assertEquals(response.jsonPath().getString("message"), "Bad request, search_product parameter is missing in POST request.");
    }
}
