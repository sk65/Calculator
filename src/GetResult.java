import java.util.ArrayList;

class GetResult {

    String calcString(String string) {
        ArrayList<String> res = stringToList(string);
        calculationString(res);
        return res.get(0);
    }

    private ArrayList<String> stringToList(String string) {
        char[] chars = string.toCharArray();
        ArrayList<String> list = new ArrayList<>(chars.length);
        StringBuilder str = new StringBuilder(chars.length);
        int k = 0;
        if (chars[0] == '-') {
            k = 1;
            str.append(chars[0]);
            do {
                str.append(chars[k]);
                k++;
            } while (chars[k] != '+' && chars[k] != '-' && chars[k] != '/' && chars[k] != '*');
        }
        for (int i = k; i < chars.length; i++) {
            if (chars[i] != '+'
                    || chars[i] != '-'
                    || chars[i] != '/'
                    || chars[i] != '*') {
                if (chars[i] != '+' && chars[i]
                        != '-' && chars[i]
                        != '/' && chars[i]
                        != '*')
                    str.append(chars[i]);
                if (i == chars.length - 1) {
                    list.add(str.toString());
                    str.delete(0, i);
                }
            }
            if (chars[i] == '+' || chars[i] == '-' || chars[i] == '/' || chars[i] == '*') {
                list.add(str.toString());
                list.add(String.valueOf(chars[i]));
                str.delete(0, i);
            }
        }
        return list;
    }

    private void calculationString(ArrayList<String> list) {
        if (list.size() == 1) {
            return;
        }
        if (list.contains("*")) {
            operations(list, "*");
            calculationString(list);
        }
        if (list.contains("/")) {
            operations(list, "/");
            calculationString(list);
        }

        if (list.contains("+")) {
            operations(list, "+");
            calculationString(list);
        }
        if (list.contains("-")) {
            operations(list, "-");
            calculationString(list);
        }
    }

    private void operations(ArrayList<String> list, String operation) {
        String res = null;
        int temple = 0;
        double a, b;
        switch (operation) {
            case "-":
                temple = list.indexOf("-");
                a = Double.parseDouble(list.get(temple - 1));
                b = Double.parseDouble(list.get(temple + 1));
                res = String.valueOf(a - b);
                break;
            case "+":
                temple = list.indexOf("+");
                a = Double.parseDouble(list.get(temple - 1));
                b = Double.parseDouble(list.get(temple + 1));
                res = String.valueOf(a + b);
                break;
            case "*":
                temple = list.indexOf("*");
                a = Double.parseDouble(list.get(temple - 1));
                b = Double.parseDouble(list.get(temple + 1));
                res = String.valueOf(a * b);
                break;
            case "/":
                temple = list.indexOf("/");
                a = Double.parseDouble(list.get(temple - 1));
                b = Double.parseDouble(list.get(temple + 1));
                res = String.valueOf(a / b);
                break;
        }
        list.remove(temple);
        list.remove(temple);
        list.remove(temple - 1);
        list.add(temple - 1, res);
    }

}



