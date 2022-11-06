public enum RimDiget {
    I(1),II(2),III(3),IV(4),V(5),VI(6),VII(7),VIII(8),IX(9),X(10);

    final int value;

    RimDiget(int value) {
        this.value = value;
    }

    static int decodeRim(String s) throws Exception {
        int value = -1;
        for (RimDiget c : RimDiget.values()) {
            if (c.name().equals(s)) {
                value = c.value;
            }
        }
        if (value == -1) {
            throw new Exception("Можно вводить либо римские цифры от I до X, либо арабские от 1 до 10");
        }
        return value;
    }
    static String intToRimDiget( int value) {
        if (value == 100) return "C";
        int ten = value / 10;
        int one = value % 10;
        String oneRim = "";
        String tenRim = "";
        switch (one) { // соотносим единицы
            case (1) -> oneRim = "I";
            case (2) -> oneRim = "II";
            case (3) -> oneRim = "III";
            case (4) -> oneRim = "IV";
            case (5) -> oneRim = "V";
            case (6) -> oneRim = "VI";
            case (7) -> oneRim = "VII";
            case (8) -> oneRim = "VII";
            case (9) -> oneRim = "IX";
        }

        switch (ten) { // соотносим десятки
            case (1) -> tenRim = "X";
            case (2) -> tenRim = "XX";
            case (3) -> tenRim = "XXX";
            case (4) -> tenRim = "XL";
            case (5) -> tenRim = "L";
            case (6) -> tenRim = "LX";
            case (7) -> tenRim = "LXX";
            case (8) -> tenRim = "LXXX";
            case (9) -> tenRim = "XC";
        }
        return tenRim + oneRim;
    }
}
