package view;


import controller.CalculatorDAO;


public interface ICalculatorRepository {
    void inputandcalculatorShape();

    class CalculatorRepository implements ICalculatorRepository {
        @Override
        public void inputandcalculatorShape() {
            CalculatorDAO.Instance().inputandcalculatorShape();
        }
    }
}
