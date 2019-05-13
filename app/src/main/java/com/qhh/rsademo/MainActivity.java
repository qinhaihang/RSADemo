package com.qhh.rsademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.security.KeyPair;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createSecret(View view) {
        try {
            byte[] randomKey = AESUtils.getRandomKey(128);
            Log.d("qhh","randomKey length = " + randomKey.length);
            KeyPair keyPair = RSAUtils.generateRSAKeyPair(1024);
            byte[] publicKey = RSAUtils.getPublicKey(keyPair);
            byte[] encrypt = RSAUtils.encryptByPublicKey(randomKey, publicKey);
            Log.i("qhh", "encrypt length = " + encrypt.length);
            byte[] privateKey = RSAUtils.getPrivateKey(keyPair);
            byte[] decrypt = RSAUtils.decryptByPrivateKey(encrypt, privateKey);
            Log.i("qhh", "decrypt length = " + decrypt.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AES(View view) {
        String Hello = "hello";
        try {
            byte[] randomKey = AESUtils.getRandomKey(128);
            byte[] encrypt = AESUtils.encrypt(Hello, randomKey);
            Log.i("qhh", "encrypt = " + new String(encrypt, "UTF-8"));
            byte[] decrypt = AESUtils.decrypt(encrypt, randomKey);
            String decryptStr = new String(decrypt, "UTF-8");
            Log.d("qhh","decryptStr = "+decryptStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
