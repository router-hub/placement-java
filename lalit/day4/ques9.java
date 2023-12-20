import java.util.*;

public class ques9 {
public static double surfaceArea(double x,double y,double z){
    double s = (x+y+z)/2.0;
    return Math.sqrt(s*(s-x)*(s-y)*(s-z));
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            double d = sc.nextDouble();
            double e = sc.nextDouble();
            double f = sc.nextDouble();

            double uu = (b * b) + (c * c) - (f * f);
            double vv = (a*a) + (c * c) - (e*e);
            double ww = (a*a) + (b*b) - (d*d);

            double vol = 4*a*a*b*b*c*c - (a*a*uu) - (b*b*vv) - (c*c*ww) + (uu*vv*ww);
            double volume = Math.sqrt(vol)/12;

            double surface = surfaceArea(a,b,d)+surfaceArea(b,c,f)+surfaceArea(a,c,e)+surfaceArea(d,e,f);

            System.out.println((3*volume)/surface);
        }
    }
}
