package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>
{
    private int mColorResourceId;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param word           A List of word objects to display in a list
     * @param colorResourceId   The background color of text view
     */
    public WordAdapter(Activity context, ArrayList<Word> word, int colorResourceId)
    {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, word);

        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwokTranslation
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwokTranslation);
        // Get the miwok translation from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID englishTranslation
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.englishTranslation);
        // Get the english translation from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        //check if current word has image
        if(currentWord.hasImage())
        {
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentWord.getImageResourceId());
            //set icon view as visible
            iconView.setVisibility(View.VISIBLE);
        }
        else
        {
            iconView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.textHolder);
        //Find the color that resource id maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of textHolder view
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
