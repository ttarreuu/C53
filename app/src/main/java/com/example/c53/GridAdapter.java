package com.example.c53;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c53.GridItem;
import com.example.c53.HistoryActivity;
import com.example.c53.R;

import java.util.List;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private List<GridItem> gridItems;

    public GridAdapter(Context context) {
        this.context = context;
        this.gridItems = createGridItems(); // Implement this method to create your grid items
    }

    private List<GridItem> createGridItems() {
        gridItems.add(new GridItem(R.drawable.img_1, "Item 1"));
        gridItems.add(new GridItem(R.drawable.img_2, "Item 2"));
        gridItems.add(new GridItem(R.drawable.img_3, "Item 3"));
        gridItems.add(new GridItem(R.drawable.img_4, "Item 4"));
        // Add more items as needed

        return gridItems;
    }

    @Override
    public int getCount() {
        return gridItems.size();
    }

    @Override
    public Object getItem(int position) {
        return gridItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        GridItem gridItem = gridItems.get(position);
        ImageView imageView = convertView.findViewById(R.id.image);
        TextView textView = convertView.findViewById(R.id.text);

        imageView.setImageResource(gridItem.getImageResource());
        textView.setText(gridItem.getText());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item click event
                Intent intent = new Intent(context, HistoryActivity.class);
                intent.putExtra("imageResource", gridItem.getImageResource());
                intent.putExtra("text", gridItem.getText());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
