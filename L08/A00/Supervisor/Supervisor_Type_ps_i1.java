package L08.A00.Supervisor;

public record Supervisor_Type_ps_i1(Integer R, Integer E, Integer L) {

  @Override
  public String toString() {
    return "[R=" + R + ",E=" + E + ",L=" + L + "]";
  }

}
