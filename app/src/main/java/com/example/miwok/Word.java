package com.example.miwok;

import android.media.Image;

public class Word
{
    private static final int No_Image_Provided = -1;
    private String englishWord;
    private String miwokTranslation;
    private int imageResourceId = No_Image_Provided;
    private int audioResourceId;

    /**
     *
     * @param english    the word in known language to the user
     * @param miwok      word in miwok language
     * @param audio      pronunciation of the word in miwok language
     */
    public Word(String english, String miwok, int audio)
    {
        englishWord = english;
        miwokTranslation = miwok;
        audioResourceId = audio;
    }

    /**
     *
     * @param english    the word in known language to the user
     * @param miwok      word in miwok language
     * @param picture    image related to the word
     * @param audio      pronunciation of the word in miwok language
     */
    public Word(String english, String miwok, int picture, int audio)
    {
        englishWord = english;
        miwokTranslation = miwok;
        imageResourceId = picture;
        audioResourceId = audio;
    }

    //Get the english word
    public String getDefaultTranslation()
    {
        return englishWord;
    }

    //Get the Miwok word
    public String getMiwokTranslation()
    {
        return miwokTranslation;
    }

    //Get the image associated with the word
    public int getImageResourceId()
    {
        return imageResourceId;
    }

    //Get the audio associated with the word
    public int getAudioResourceId()
    {
        return audioResourceId;
    }

    //Checks if an image if provided or not
    public boolean hasImage()
    {
        return (imageResourceId != No_Image_Provided);
    }
}
