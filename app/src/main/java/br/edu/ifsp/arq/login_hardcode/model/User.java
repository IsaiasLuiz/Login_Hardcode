package br.edu.ifsp.arq.login_hardcode.model;

import java.io.Serializable;

public class User implements Serializable {

    //usei strings porque pode conter letras no prontuario do aluno

    public static final  String REGISTRATION_ALLOWED = "3000389";

    public static final  String PASSWORD_ALLOWED = "9830003";

    private String registration;

    private String password;

    public User(final String registration, final String password) {
        this.registration = registration;
        this.password = password;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
