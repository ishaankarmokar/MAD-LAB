package com.example.q1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);

        GridView gridView = view.findViewById(R.id.simpleGridView);
        // 4 rows * 3 cols = 12 images

        int[] imageResources = {
                R.drawable.my_image, R.drawable.my_image, R.drawable.my_image,
                R.drawable.my_image, R.drawable.my_image, R.drawable.my_image,
                R.drawable.my_image, R.drawable.my_image, R.drawable.my_image,
                R.drawable.my_image, R.drawable.my_image, R.drawable.my_image,
                R.drawable.my_image, R.drawable.my_image, R.drawable.my_image,
                R.drawable.my_image, R.drawable.my_image, R.drawable.my_image,
                R.drawable.my_image, R.drawable.my_image, R.drawable.my_image,
                R.drawable.my_image, R.drawable.my_image, R.drawable.my_image,
                R.drawable.my_image, R.drawable.my_image, R.drawable.my_image,
                R.drawable.my_image, R.drawable.my_image, R.drawable.my_image
        };


        // Simple adapter to display images
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() { return imageResources.length; }
            @Override
            public Object getItem(int i) { return null; }
            @Override
            public long getItemId(int i) { return 0; }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new AbsListView.LayoutParams(250, 250));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                // This effectively plays the GIF
                com.bumptech.glide.Glide.with(getContext())
                        .load(imageResources[i])
                        .into(imageView);

                return imageView;
            }
        };

        gridView.setAdapter(adapter);
        return view;
    }
}