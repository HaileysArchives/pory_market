package com.example.grocery_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import android.graphics.Bitmap;
import com.example.grocery_app.R;

public class CreateQRActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);

        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap("https://www.naver.com/", BarcodeFormat.QR_CODE, 400, 400);
            ImageView imageViewQrCode = findViewById(R.id.imageViewQrCode);
            imageViewQrCode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
