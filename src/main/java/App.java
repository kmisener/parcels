import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/output", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/output.vtl");

      int length = Integer.parseInt(request.queryParams("packageLength"));
      int width = Integer.parseInt(request.queryParams("packageWidth"));
      int height = Integer.parseInt(request.queryParams("packageHeight"));
      int speed = Integer.parseInt(request.queryParams("packageSpeed"));
      int distance = Integer.parseInt(request.queryParams("packageDistance"));
      int weight = Integer.parseInt(request.queryParams("packageWeight"));

      model.put("length", length);
      model.put("width", width);
      model.put("height", height);
      model.put("speed", speed);
      model.put("distance", distance);
      model.put("weight", weight);

      Parcel parcel = new Parcel(length, width, height, distance, speed, weight);

      int cost = (int) Math.round(parcel.costToShip());
      model.put("cost", cost);


      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
