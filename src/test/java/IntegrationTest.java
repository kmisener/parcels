import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import org.junit.*;
import static org.junit.Assert.*;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
    public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("");
    }

    @Test
      public void outputTest() {
        goTo("http://localhost:4567/");
        fill("#packageWidth").with("5");
        fill("#packageHeight").with("5");
        fill("#packageLength").with("12");
        fill("#packageSpeed").with("5");
        fill("#packageDistance").with("500");
        fill("#packageWeight").with("5");
        submit(".btn");
        assertThat(pageSource()).contains("Height: 5 cm");
        assertThat(pageSource()).contains("Length: 12 cm");
        assertThat(pageSource()).contains("Width: 5 cm");
        assertThat(pageSource()).contains("Weight: 5 lbs");
        assertThat(pageSource()).contains("Distance: 500 km");
        assertThat(pageSource()).contains("Speed: 5 days");
      }
}
