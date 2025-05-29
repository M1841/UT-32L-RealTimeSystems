package L08.A00.Interfaces;

public interface PlaceHandlerTemplate {
  public void AddPlace(PlaceTemplate place);

  public PlaceTemplate GetPlaceByName(String Name);

  public String PrintAllPlaces();
}
