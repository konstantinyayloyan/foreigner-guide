package com.upwork.foreigner.guide.crypto;

import com.upwork.foreigner.guide.model.Place;
import org.springframework.stereotype.Component;

@Component
public class CaesarCipherEncrypt {

    private static final int KEY = 4;

    public void encrypt(final Place place) {
        place.setName(encrypt(place.getName(), KEY));
        place.setType(encrypt(place.getType(), KEY));
    }

    public void decrypt(final Place place) {
        place.setName(decrypt(place.getName(), KEY));
        place.setType(decrypt(place.getType(), KEY));
    }

    public String encrypt(String cipher) {
        return encrypt(cipher, KEY);
    }

    private String encrypt(final String text, final int key) {
        final StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                final char ch = (char) (((int) text.charAt(i) +
                        key - 65) % 26 + 65);
                result.append(ch);
            } else {
                final char ch = (char) (((int) text.charAt(i) +
                        key - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }

    private String decrypt(String cipher, int shift) {
        return encrypt(cipher, 26 - shift);
    }
}
