package com.blackmirror;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends Activity {

    static {
        System.loadLibrary("blackmirror");
    }

    public native void run(String input);

    private static final String KEY = "hardcoded_key_12";

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        TextView mode = findViewById(R.id.mode);
        TextView tokenView = findViewById(R.id.token);
        TextView decryptedView = findViewById(R.id.decrypted);
        TextView log = findViewById(R.id.log);

        log.append("\n> activity started");

        Intent i = getIntent();

        if (i != null && i.hasExtra("token")) {
            String token = i.getStringExtra("token");
            tokenView.setText("TOKEN: " + token);

            try {
                String decrypted = decrypt(token);
                decryptedView.setText("DECRYPTED: " + decrypted);
                log.append("\n> token decrypted");

                if ("admin".equals(decrypted)) {
                    mode.setText("MODE: ADMIN");
                    mode.setTextColor(0xFF00FF9C);
                    log.append("\n> admin unlocked");
                }

            } catch (Exception e) {
                log.append("\n> decrypt failed");
                e.printStackTrace();
            }
        }
    }

    private String decrypt(String input) throws Exception {
        Key key = new SecretKeySpec(KEY.getBytes(), "AES");
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, key);
        return new String(c.doFinal(Base64.decode(input, 0)));
    }
}