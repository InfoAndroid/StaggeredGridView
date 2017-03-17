package com.example.admin.staggeredgridview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Window;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    RelativeLayout mRelativeLayout;
    private Context mContext;
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        // Change the action bar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Initialize a new String array
        String[] colors = {
                "Red", "Green", "Blue", "Yellow", "Magenta", "Cyan", "Orange",
                "Aqua", "Azure", "Beige", "Bisque", "Brown", "Coral", "Crimson"
        };

        // Define a layout for RecyclerView
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // Initialize a new instance of RecyclerView Adapter instance
        mAdapter = new ColorAdapter(mContext, colors);

        mRecyclerView.setAdapter(mAdapter);
    }
}
