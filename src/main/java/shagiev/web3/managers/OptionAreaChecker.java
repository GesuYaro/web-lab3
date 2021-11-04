package shagiev.web3.managers;

import java.io.Serializable;

public class OptionAreaChecker implements AreaChecker, Serializable {

    @Override
    public boolean check(double x, double y, double r) {
        return hitRectangle(x, y ,r) || hitTriangle(x, y, r) || hitSector(x, y, r);
    }

    private boolean hitRectangle(double x, double y, double r) {
        return (x >= -r && x <= 0) && (y >= -r/2 && y <= 0);
    }

    private boolean hitTriangle(double x, double y, double r) {
        return x >= 0 && y >= 0 && (y <= -x + r);
    }

    private boolean hitSector(double x, double y, double r) {
        return x <= 0 && y >= 0 && (x * x + y * y <= r * r);
    }
}
