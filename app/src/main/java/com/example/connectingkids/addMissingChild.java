package com.example.connectingkids;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.storage.StorageReference;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.security.Permission;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addMissingChild#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addMissingChild extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int REQUEST_IMAGE_PICK = 1;
    ImageView eimageFromUser = getView().findViewById(R.id.imageFromUser);


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public addMissingChild() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addMissingChild.
     */
    // TODO: Rename and change types and number of parameters
    public static addMissingChild newInstance(String param1, String param2) {
        addMissingChild fragment = new addMissingChild();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_missing_child,container,false);

        Button takeImageFromUser=view.findViewById(R.id.takeImageFromUser);

        takeImageFromUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeimageFunction();
            }
        });

        return view;

    }



    private void takeimageFunction() {
        Dexter.withContext(requireContext())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        // Permission is granted, proceed with selecting an image from the gallery or accessing storage
                        selectImage();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        // Permission is denied
                        // You can show a message to the user or handle the denial case as per your requirements
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        // Permission needs to be requested again
                        permissionToken.continuePermissionRequest();
                    }
                })
                .check();
    }

    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        startActivityForResult(intent, REQUEST_IMAGE_PICK);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK && data != null) {
            Uri imageUri = data.getData();

            int targetSize = Math.min(eimageFromUser.getWidth(), eimageFromUser.getHeight());

            Glide.with(requireContext())
                    .load(imageUri)
                    .apply(RequestOptions.circleCropTransform()
                            .apply(new RequestOptions())
                            .override(targetSize, targetSize))
                    .into(eimageFromUser);

            //eimageFromUser.setImageURI(imageUri);
            // Do something with the selected image URI
            // For example, you can display the image in an ImageView or perform further processing
        }
    }




}