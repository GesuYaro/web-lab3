package shagiev.web3.managers;

import java.io.Serializable;

public class OptionValidator implements Validator, Serializable {
    @Override
    public Double validateX(String x) {
        Double returningX = null;
        try {
            double numX = Double.parseDouble(x);
//            if (numX >= -2 && numX <= 1) {
//                returningX = numX;
//            }
            returningX = numX;
        } catch (NumberFormatException ignored) {}
        return returningX;
    }

    @Override
    public Double validateY(String y) {
        Double returningY = null;
        try {
            double numY = Double.parseDouble(y);
//            if (numY >= -3 && numY <= 3) {
//                returningY = numY;
//            }
            returningY = numY;
        } catch (NumberFormatException ignored) {}
        return returningY;
    }

    @Override
    public Double validateR(String r) {
        Double returningR = null;
        try {
            double numR = Double.parseDouble(r);
//            if (numR >= 1 && numR <= 3) {
//                returningR = numR;
//            }
            returningR = numR;
        } catch (NumberFormatException ignored) {}
        return returningR;
    }
}
