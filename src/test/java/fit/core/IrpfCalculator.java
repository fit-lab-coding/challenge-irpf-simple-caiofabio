package fit.core;

public class IrpfCalculator {
  private static final int inssAliq = 11;
  
  public static double calculateBaseSalary(double totalSalary) {
    double totalBaseSalary = totalSalary - (totalSalary*inssAliq/100);
    return totalBaseSalary;
  }

  public static double calculateExemption() {
    return 1903.98;
  }

  public static double calculateDiscount(double baseSalary) {
    return baseSalary - calculateExemption();
  }

  public static double calculateTaxLayer(double baseSalary) {
    if ( baseSalary <= calculateExemption())//primeira faixa
      return 0.000;
    return 0.075;
  }

  public static double calculateIrpf(double totalSalary) {
    double baseSalary = calculateBaseSalary(totalSalary);
    double irrf = (baseSalary - calculateExemption()) * calculateTaxLayer(baseSalary);
    return irrf;
  }
}