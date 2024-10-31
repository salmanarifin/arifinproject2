public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public double slope() {
        return Math.round((((double) y2 - y1) / (x2 - x1)) * 100.0) / 100.0;
    }
    public double yIntercept() {
        return Math.round((y1 - slope() * (double) x1) * 100.0) / 100.0;
    }
    public double distance() {
        return Math.round((Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))) * 100.0) / 100.0;
    }
    public String coordinateForX(double x) {
        double coordForX = Math.round((x * slope() + yIntercept()) * 100.0) / 100.0;
        ;
        return "(" + x + ", " + coordForX + ")";
    }
    public String equation() {
        String result = "";
        if (x2 == x1) {
            result = "x = " + x1;
        }
        if (y2 == y1) {
            result += "y = " + y1;
        }
        else {
            result = "y = ";
            if (slope() == 1) {
                result += "x";
            } else if (slope() == -1) {
                result += "-x";
            } else if (slope() % 1 == 0.0) {
                result += (int) slope() + "x";
            } else if (y2 - y1 < 0 && x2 - x1 > 0 || y2 - y1 > 0 && x2 - x1 < 0) {
                result += "-" + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x";
            }  else {
                result += Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x";
            }
        }
        if (y2 != y1) {
            if (yIntercept() > 0) {
                result += " + " + yIntercept();
            } else if (yIntercept() < 0) {
                result += " - " + Math.abs(yIntercept());
            }
        }
        return result;
    }
    public String lineInfo() {
        if (x1 == x2) {
            return "These points are on a vertical line: x = " + x1 + "\nThe slope is undefined.\nThere is no y-intercept.\nThe distance between the two points is: " + distance();
        } else {
            return "The two points are (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\nThe equation of the line between these points is: " + equation() + "\nThe slope of this line is: " + slope() + "\nThe y-intercept of the line is: " + yIntercept() + "\nThe distance between the two points is: " + distance();
        }
    }
}

