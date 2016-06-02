package ch24.ex24_01;

import java.util.ResourceBundle;

public class GlobalHello {
    public static void main(String[] args) {
        ResourceBundle res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes");

        String msg;
        if (0 < args.length) {
            msg = res.getString(GlobalRes.GOODBYE);
        } else {
            msg = res.getString(GlobalRes.HELLO);
        }

        System.out.println(msg);
    }
}