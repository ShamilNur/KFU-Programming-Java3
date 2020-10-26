package ru.kpfu.itis.group903.nurkaev.validations;

import org.apache.commons.validator.routines.EmailValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class Validator {
    public static boolean dataIsCorrect(HttpServletRequest req, HttpServletResponse resp) {
        boolean nameValid = !req.getParameter("name").equals("");
        boolean emailValid = EmailValidator.getInstance().isValid(req.getParameter("email"));
        boolean passwordValid = req.getParameter("password").length() >= 3;
        boolean confirmPasswordValid = req.getParameter("password").equals(req.getParameter("confirm_password"));

        return nameValid && emailValid && passwordValid && confirmPasswordValid;
    }
}
