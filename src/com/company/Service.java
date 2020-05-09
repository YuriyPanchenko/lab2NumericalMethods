package com.company;

public class Service {
    public static boolean converge(double[] xk, double[] xkp, double eps) {
        for (int i = 0; i < xk.length; i++) {
            if (Math.abs(xk[i] - xkp[i]) >= eps) {
                return false;
            }
        }
        return true;
    }

    public static void zeidel(double[][] a, double[] b, double EPS) {
        int size = a.length;
        double[] x = new double[size];
        double[] p = new double[size];
        do {
            for (int i = 0; i < size; i++) {
                double var = 0;
                for (int j = 0; j < size; j++) {
                    if (j != i) {
                        var += (a[i][j] * x[j]);
                    }
                }
                p[i] = x[i];
                x[i] = (b[i] - var) / a[i][i];
            }
        } while (!converge(x, p, EPS));


        for(int i = 0; i < x.length; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
