//<!--Nama : Kartika Aghni Safitri | NIM : 10119249 | Kelas : IF-6 | Tanggal Pengerjaan : 20/5/2022-->

package com.example.myselfapps;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    ImageView Phone, Instagram, Email, Maps, About;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        Phone = root.findViewById(R.id.phone);
        Email = root.findViewById(R.id.email);
        Instagram = root.findViewById(R.id.instagram);
        Maps = root.findViewById(R.id.logomap);
        About = root.findViewById(R.id.logoabout);

        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.phone) {
                    String phoneNumber = "082112662248";
                    Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                    startActivity(dialPhoneIntent);
                }
            }
        });

        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.email) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"kartikaaghnisafitri@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Email dari Rika APPS");
                    intent.putExtra(Intent.EXTRA_TEXT, "Halo! Text me!");

                    try {
                        startActivity(Intent.createChooser(intent, "Ingin Mengirim Email?"));
                    } catch (android.content.ActivityNotFoundException ex) {
                        //do something else
                    }
                }
            }
        });

        Instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.instagram.com/kartikaaghni");
                Intent followme = new Intent(Intent.ACTION_VIEW, uri);

                followme.setPackage("com.instagram.android");

                try {
                    startActivity(followme);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/kartikaaghni/")));
                }
            }
        });

        Maps.setOnClickListener(view -> {
            Intent map = new Intent();
            map.setAction(Intent.ACTION_VIEW);
            map.addCategory(Intent.CATEGORY_BROWSABLE);
            map.setData(Uri.parse("https://goo.gl/maps/DtrPeG73n4WKjwsd9"));
            startActivity(map);
        });

        About.setOnClickListener(view -> {
            AboutDialog Aboutdialog = new AboutDialog();
            Aboutdialog.show(getFragmentManager(), "About Dialog Apps");
        });
        return root;
    };

}