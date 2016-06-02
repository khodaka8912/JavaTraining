package ch24.ex24_01;

import java.util.ListResourceBundle;

public class GlobalRes_zh extends ListResourceBundle {
    @Override
    public Object[][] getContents() {
        return contents;
    }

    private static final Object[][] contents = {
            {GlobalRes.HELLO, "你好"},
            {GlobalRes.GOODBYE, "再见"},
    };
}