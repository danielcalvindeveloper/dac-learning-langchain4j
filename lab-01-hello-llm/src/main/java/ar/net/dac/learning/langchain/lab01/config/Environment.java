package ar.net.dac.learning.langchain.lab01.config;

import io.github.cdimascio.dotenv.Dotenv;

public final class Environment {

    private static final Dotenv DOTENV = Dotenv.load();

    private Environment() {
    }

    public static String get(String key) {
        return DOTENV.get(key);
    }
}