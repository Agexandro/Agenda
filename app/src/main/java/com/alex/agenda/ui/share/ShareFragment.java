package com.alex.agenda.ui.share;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alex.agenda.R;

public class ShareFragment extends Fragment {
    Button btnEmail;
    Button btnFace;

    private ShareViewModel shareViewModel;

    public void click() {
        try {
            Intent i =new Intent(Intent.ACTION_SEND);
            i.setData(Uri.parse("email"));
            String[] s = {"kleon0313@gmail.com"};
            i.putExtra(Intent.EXTRA_EMAIL,s);
            i.putExtra(Intent.EXTRA_SUBJECT,"Prueba La app Agenda");
            i.putExtra(Intent.EXTRA_TEXT,"ven y ordena tus tareas y recordatorios eficientemene");
            i.setType("message/rfc822");
            Intent ic = Intent.createChooser(i,"Abrir Email Con:");
            startActivity(ic);
        }catch (Exception e){
            Toast.makeText(getActivity(),"",Toast.LENGTH_SHORT).show();
        }
    }

    public void click2() {
        try {
            Intent i =new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT,"http://www.Agenda.com"+"\nMiTexto");
            i.setPackage("com.facebook.katana");
            Intent ic = Intent.createChooser(i,"Abrir facebook Con:");
            startActivity(ic);
        }catch (Exception e){
            Toast.makeText(getActivity(),"",Toast.LENGTH_SHORT).show();
        }
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        btnEmail = (Button) root.findViewById(R.id.email);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
        btnFace = (Button) root.findViewById(R.id.facebook);
        btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click2();
            }
        });
        shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}