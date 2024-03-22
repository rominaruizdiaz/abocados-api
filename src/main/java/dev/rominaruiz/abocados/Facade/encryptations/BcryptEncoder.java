package dev.rominaruiz.abocados.Facade.encryptations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dev.rominaruiz.abocados.generics.IEncoder;

public class BcryptEncoder implements IEncoder {

    BCryptPasswordEncoder encoder;

    public BcryptEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String encode(String data) {
        String dataEncode = encoder.encode(data);
        return dataEncode;
    }
}