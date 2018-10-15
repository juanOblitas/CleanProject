/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import model.Employee;



/**
 *
 * @author jc
 */
public class JsonConverter {
    private final Gson gson;
    
    public JsonConverter() {
        
        gson = new GsonBuilder().create();
    }
    
    public String convertToJson(List<Employee> employees) {
    
        JsonArray jarray = gson.toJsonTree(employees).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("employees", jarray);
        return jsonObject.toString();
    }

}
