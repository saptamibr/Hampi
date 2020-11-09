package com.example.hampi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Place4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla lobortis, risus at blandit scelerisque, tortor dolor sodales odio, fringilla efficitur magna dolor sed orci. Aliquam nec ullamcorper elit, id ullamcorper metus. Aenean euismod erat at mollis fermentum. Curabitur pulvinar, arcu nec commodo elementum, nisl est bibendum felis, ut sagittis dolor ex in nisi. Suspendisse molestie vel mauris id facilisis. Suspendisse eleifend, felis in egestas scelerisque, augue nulla vestibulum sapien, eget tristique lectus nibh nec turpis. Fusce sed ultricies sem. Etiam consectetur sollicitudin quam vel vehicula. Fusce tempus imperdiet turpis, nec pharetra risus rhoncus nec. Nunc tincidunt risus non tincidunt mollis. Proin luctus nisl a ultricies iaculis. Sed eget ultrices odio. Maecenas feugiat mi quis lacus pulvinar, non facilisis nunc venenatis. Donec et tortor feugiat turpis egestas varius eget sed felis. Suspendisse nec tempus lorem, vitae dapibus nulla. Proin at ultricies velit, ut dictum neque.\n" +
                "\n" +
                "Nulla mattis augue quis tellus egestas porta. Proin viverra pretium neque, non fringilla enim mattis eu. Proin nibh tellus, pulvinar vitae justo sit amet, eleifend tempus magna. Nam ut tincidunt purus. Vivamus eu interdum velit. Aliquam at diam molestie, vulputate est nec, rutrum leo. Fusce ac ornare nisi, sed rhoncus risus. Cras felis nulla, porttitor in.";


        TextView t1 = (TextView) findViewById(R.id.txt1);
        t1.setText(content);

        TextView t2 = (TextView) findViewById(R.id.txt2);
        t2.setText(content);

        ImageView i1 = (ImageView) findViewById(R.id.img_id1);
        i1.setImageResource(R.drawable.img4);

        ImageView i2 = (ImageView) findViewById(R.id.img_id2);
        i2.setImageResource(R.drawable.img4);
    }
}
