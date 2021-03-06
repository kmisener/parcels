import org.junit.*;
import static org.junit.Assert.*;

public class ParcelTest {
  Parcel parcel;

    @Before
    public void setUp() {
      parcel = new Parcel(12, 5, 5, 500, 5, 5);
    }
    
  @Test
  public void volume_MultipliesDimensionsToGiveVolume_300 () {
    assertEquals(300, parcel.Volume());
  }

  @Test
  public void costToShip_CalculateCostToShip_3 () {
    assertEquals(37.5, parcel.costToShip(), .25);
  }
}
