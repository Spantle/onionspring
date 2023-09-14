package com.onionspring.app.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jakarta.servlet.http.HttpSession;

public class CardValidator {
    private String VisaCardPattern = "^4[0-9]{0,}$";
    private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private String CSVPattern = "[0-9]+";

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    public boolean validateName(String name) {
        return validate(namePattern, name);
    }

    public boolean validateCSV(String CSV) {
        if (CSV.length() == 3) {
            return validate(CSVPattern, CSV);
        } else {
            return false;
        }
    }

    // this checks if the card is real by doubling every second number, -9 if
    // its bigger than 10
    public boolean validNumber(String card) {
        int total = 0;
        for (int i = card.length() - 1; i >= 0; i--) {
            int num = Integer.parseInt(card.substring(i, i + 1));

            if ((card.length() - i) % 2 == 0) {
                int tempNum = num * 2;
                if (tempNum > 9) {
                    tempNum -= 9;
                }
                num = tempNum;
            }
            total += num;
        }
        return total % 10 == 0;
    }

    public boolean validateVisa(String card) {
        if (validate(VisaCardPattern, card) && card.length() >= 13 && card.length() <= 16) {
            return validNumber(card);
        } else {
            return false;
        }
    }

    public void clear(HttpSession session) {
        session.setAttribute("cardErr", "Enter card number");
        session.setAttribute("nameErr", "Enter name");
        session.setAttribute("csvErr", "Enter CSV");
    }
}
