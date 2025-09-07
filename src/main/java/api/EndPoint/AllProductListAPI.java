package api.EndPoint;

import api.Base.BaseAPI;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.response.Response;
import org.assertj.core.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllProductListAPI {
    BaseAPI baseAPI;

    public AllProductListAPI(BaseAPI api){
        this.baseAPI=api;
    }

    public Response getAllProduct(){
        return baseAPI.api.get("/productsList").perform();
    }

    public Response searchForProduct() {
        //search for product by parameter "search_product"
        Map<String, Object> params = new HashMap<>();
        params.put("search_product", "top");
        return baseAPI.api.post("/searchProduct").setParameters(params,RestActions.ParametersType.QUERY).perform();
    }

    public Response searchProductWithoutParameter() {
        return baseAPI.api.post("/searchProduct").perform();
    }
}
