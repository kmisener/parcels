public class Parcel {
  private int mLengthInCm;
  private int mWidthInCm;
  private int mHeightInCm;
  private int mDistanceInKm;
  private int mSpeedInDays;
  private int mWeightInLbs;
  private double mCostToShip;
  private int mVolume;

  public Parcel(int length, int width, int height, int distance, int speed, int weight){
    mLengthInCm = length;
    mWidthInCm = width;
    mHeightInCm = height;
    mDistanceInKm = distance;
    mSpeedInDays = speed;
    mWeightInLbs = weight;
  }

  public int Volume() {
    return mVolume = mLengthInCm * mWidthInCm * mHeightInCm;
  }

  public double costToShip() {
     return mCostToShip = (this.Volume() / mWeightInLbs) * (mDistanceInKm * (mSpeedInDays * .00025));
  }
}
