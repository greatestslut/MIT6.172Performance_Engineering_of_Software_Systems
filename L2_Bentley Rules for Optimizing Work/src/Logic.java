public class Logic {
  //1.constant folding and propagation(the constant will be substituted at compile-time)
  public static final String a = "constant";
  public static final int b = 1;
  //2.common-subexpression elimination
  //3.algebraic identities(%-->for)
  //4.short-circuiting filtering layer first
  //5.combining predicate

  public static void main(String[] args) {
    String b = a + a;//will be compiled as LDC "constantconstant"

  }

}
