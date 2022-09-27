package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpenNeighbourActivity extends AppCompatActivity {

    @BindView(R.id.profilePhoto)
    ImageView profilePhoto;

    @BindView(R.id.textNameOnPhoto)
    TextView textNameOnPhoto;
    @BindView(R.id.textName)
    TextView textName;
    @BindView(R.id.textAdress)
    TextView textAdress;
    @BindView(R.id.textPhone)
    TextView textPhone;
    @BindView(R.id.textFacebook)
    TextView textFacebook;
    @BindView(R.id.textAbout)
    TextView textAbout;

//    @BindView(R.id.favoriteButton)
//    MaterialButton favoriteButton;

    private Neighbour currentNeighbour;

    public Neighbour getCurrentNeighbour() {
        return currentNeighbour;
    }

    public void setCurrentNeighbour(Neighbour currentNeighbour) {
        this.currentNeighbour = currentNeighbour;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_neighbour);
        ButterKnife.bind(this);

        currentNeighbour = (Neighbour) getIntent().getSerializableExtra("Editing");
        loadNeighbour(currentNeighbour);

    }

    public void loadNeighbour(Neighbour mNeighbour)
    {

        Glide.with(this).load(mNeighbour.getAvatarUrl()).placeholder(R.drawable.ic_account)
                .apply(RequestOptions.circleCropTransform()).into(profilePhoto);
        this.textNameOnPhoto.setText(mNeighbour.getName());
        textName.setText(mNeighbour.getName());
        textAdress.setText(mNeighbour.getAddress());
          textPhone.setText(mNeighbour.getPhoneNumber());
          textFacebook.setText("wwww.facebook.fr/" + mNeighbour.getName().toLowerCase(Locale.ROOT));
          textAbout.setText(mNeighbour.getAboutMe());
    }

    public static void navigate(FragmentActivity activity,Neighbour neighbour) {
        Intent intent = new Intent(activity, OpenNeighbourActivity.class);

        ActivityCompat.startActivity(activity, intent, null);
    }

    @OnClick(R.id.favoriteButton)
    void addFavorite() {

    }

    @OnClick(R.id.backButton)
    void backOnListActivity(){
        OpenNeighbourActivity.this.finish();
    }
}