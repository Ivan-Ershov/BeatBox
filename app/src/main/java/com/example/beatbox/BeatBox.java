package com.example.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";

    private static final String SOUND_FOLDER = "sample_sounds";

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox (Context context) {
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds () {
        String[] soundNames = {};

        try{

            soundNames = mAssets.list(SOUND_FOLDER);

            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (IOException ioException) {
            Log.e(TAG, "Could not list assets", ioException);
        }

        for (String filename : soundNames) {

            String assetPath = SOUND_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);

            mSounds.add(sound);

        }

    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
