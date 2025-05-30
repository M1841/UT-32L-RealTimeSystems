package L08.A00.Supervisor;

import java.util.List;

import L08.A00.Interfaces.PlaceTemplate;

public class Supervisor_Cl_ps_1 implements PlaceTemplate {
  List<Supervisor_Type_ps_i1> value;
  String name;

  public Supervisor_Cl_ps_1(String name, List<Supervisor_Type_ps_i1> value) {
    this.Init(name, value);
  }

  @Override
  public String GetPlaceName() {
    return this.name;
  }

  @Override
  public void SetPlaceName(String name) {
    this.name = name;
  }

  @Override
  public Object Get() {
    return this.value;
  }

  @Override
  public Boolean IsNull() {
    return this.value.isEmpty();
  }

  @Override
  public void Set(Object value) {
    this.value.add((Supervisor_Type_ps_i1) value);
  }

  @Override
  public String Print() {
    return "[" + this.name + "=" + this.value + "]";
  }

  @SuppressWarnings("unchecked")
  @Override
  public void Init(String name, Object value) {
    this.SetPlaceName(name);
    this.value = (List<Supervisor_Type_ps_i1>) value;
  }
}
