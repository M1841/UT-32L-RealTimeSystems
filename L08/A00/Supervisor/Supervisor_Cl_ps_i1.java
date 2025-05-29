package L08.A00.Supervisor;

import L08.A00.Interfaces.PlaceTemplate;

public class Supervisor_Cl_ps_i1 implements PlaceTemplate {
  Supervisor_Type_ps_i1 value;
  String name;

  Supervisor_Cl_ps_i1(String name, Supervisor_Type_ps_i1 value) {
    this.name = name;
    this.value = value;
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
    return value;
  }

  @Override
  public Boolean IsNull() {
    return this.Get() == null;
  }

  @Override
  public void Set(Object value) {
    this.value = (Supervisor_Type_ps_i1) value;
  }

  @Override
  public String Print() {
    return "[" + this.name + "=" + this.value + "]";
  }

  @Override
  public void Init(String name, Object value) {
    this.SetPlaceName(name);
    this.Set(value);
  }
}
